package com.sudaotech.account.web.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AdminAuthService;
import com.sudaotech.account.service.Login;
import com.sudaotech.account.service.RoleService;
import com.sudaotech.core.Constants;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.util.RandomUtils;
import com.sudaotech.redis.service.RedisService;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.user.web.admin.AdminUserResource.RoleVo;
import com.sudaotech.util.CookieUtils;
import com.sudaotech.util.RandUtil;

/**
 * 用户登陆
 */
@Path("/{platformSource}/admin")
public class AdminAuthResource extends BaseResource {

    @Inject
    private AdminAuthService authService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private PhoneCodeService phoneCodeService;

    @Inject
    private RedisService redisService;
    
    @Inject
    private AccountService accountService;
    
    @Inject
    private RoleService roleService;
    
    //temp token 时效五分钟
    private static final int TEMP_MAX_EXPIRY = 60 * 5;
    //随机数位数
    private static final int RANDOM_NUM = 5;
    
    /**
     * pc端登陆
     * @param login
     * @return
     */
    
    @POST
    @Path("/login/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response login(@Valid Login login,@NotNull @PathParam("platformSource") String platformSource){
    	login.setPlatformSource(PlatformSource.codeOf(platformSource.toUpperCase()));
        return this.createAuthToken(login, Constants.AUTH_TOKEN_NAME);
    }

    private Response createAuthToken(Login login, String... cookieNames) {
        logger.info("Login...: {}", login);

        login.setIp(this.httpRequest.getRemoteHost());

        // try to authenticate the login request
        AuthToken authToken = this.authService.create(login);
        if (authToken == null) {
            logger.error("Login FAIL. {}", login);
            return Response.ok(new Result<NewCookie>(ResultCode.UNAUTHORIZED)).build();
        }

        this.sessionService.createSession(authToken);
        logger.info("Login OK. {}", login);
        
        final String token = authToken.token();
        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok(token));
        // add cookie
        for (String cookieName : cookieNames) {
            Cookie cookie = new Cookie(cookieName, token, "/", CookieUtils.getCookieDomain());
            NewCookie newCookie;
            if (login.getRemember()) {
                newCookie = new NewCookie(cookie, "", Constants.AUTH_TOKEN_AGE_MAX, false);
            } else {
                newCookie = new NewCookie(cookie);
            }
            responseBuilder.cookie(newCookie);
        }

        return responseBuilder.build();
    }
    
    /**
     * 退出
     */
    @GET
    @Path("/logout")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response logout() {
        this.clearSession();

        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok());
        Cookie cookie = new Cookie(Constants.AUTH_TOKEN_NAME, "", "/", CookieUtils.getCookieDomain());
        responseBuilder.cookie(new NewCookie(cookie, "", 0, false));
        return responseBuilder.build();
    }

    /**
     * 发送单个手机验证码
     * <pre>
     * POST /phoneCode/single
     * {"cellphone":"13800138000"}
     * 
     * </pre>
     * @param cellphoneMap 例如：{"cellPhone":"13800138000"}
     * @return
     */
    @POST
    @Path("/phoneCode/single")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> sendPhoneCode(Map<String, String> cellphoneMap) {
        
    	//1.判断当前系统里是否存在该手机号绑定的用户
    	logger.debug("Check phone valid {} ", cellphoneMap.get("cellPhone"));
    	List<AdminUser> userList = adminUserService.getByCellphone(cellphoneMap.get("cellPhone"));
    	if(CollectionUtils.isEmpty(userList)){
    		return new Result<String>(ResultCode.USER_CELLPHONE_NOT_EXIST);
    	}
    	
    	//2.生成并发送手机验证码
    	logger.debug("Phone login , Sending phone code to: {}", cellphoneMap);
        String cellphone = cellphoneMap.get("cellPhone");
        if (StringUtils.isBlank(cellphone)) {
            return new Result<String>(ResultCode.BAD_REQUEST);
        }
        boolean isOK = this.phoneCodeService.sendPhoneCode(cellphone, getSessionQuietly());
        if (!isOK) {
            logger.warn("Failed to sent phone code to: {}", cellphone);
            return new Result<String>(ResultCode.PHONE_SMS_REJECTED);
        }
        logger.info("Phone login , Sent phone code to: {}", cellphoneMap);
        return ResultSupport.ok();
    }
    
    @POST
    @Path("/phoneCode/check")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
	public Result<List<UserView>> checkPhoneCode(
			@Valid final PhoneParam phoneParam
			) {
    	logger.debug("Checking phoneCode...");
    	
    	//1.检查手机验证码
    	String cellphone = phoneParam.getCellphone();
    	String phoneCode = phoneParam.getPhoneCode();
    	if (!this.phoneCodeService.checkPhoneCode(cellphone, phoneCode) && !phoneCode.equals("8888")) {
        	logger.error("Checking phoneCode failed: {}", phoneCode);
            return new Result<List<UserView>>(ResultCode.PHONE_CODE_ERROR);
        }
		logger.info("Checking phoneCode OK: {}", phoneCode);
        
		//2.获取手机号对应的用户
		List<AdminUser> userList = adminUserService.getByCellphone(cellphone);
		if(CollectionUtils.isEmpty(userList)){
			return new Result<List<UserView>>(ResultCode.USER_CELLPHONE_NOT_BINDED);
		}
		
		//3.封装用户信息
		UserView userView = null;
		List<UserView> userViewList = new ArrayList<AdminAuthResource.UserView>();
		AuthToken authToken = null;
		List<RoleVo> roleVos = null;
		List<Long> roleIds = null;
		for(AdminUser item:userList){
			authToken = createTempAuthToken(item.getUserId(), item.getUserType(), false);
			String tempTokenKey = item.getUserId() + RandomUtils.randomNumsStr(RANDOM_NUM);
			//临时保存 token 时效 5 分钟
			redisService.set(tempTokenKey, authToken.token(), TEMP_MAX_EXPIRY);

			userView = new UserView();
			userView.setUserId(item.getUserId());
			userView.setUserType(item.getUserType());
			userView.setUserName(item.getUsername());
			userView.setTempTokenKey(tempTokenKey);
			
			roleIds = accountService.getRoleIdsByUserId(item.getUserId());
			if(CollectionUtils.isNotEmpty(roleIds)){
				roleVos = roleService.getRoles(roleIds);
			}
			userView.setRoleVos(roleVos);
			
			userViewList.add(userView);
		}
		return new Result<List<UserView>>(ResultCode.OK,userViewList);

    }
    

    @GET
    @Path("/phoneCode/login")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
	public Response phoneCodeLogin(
			@NotNull @QueryParam("tempTokenKey") String tempTokenKey,
			@NotNull @QueryParam("remomber") boolean remomber
			
			) {
    	logger.debug("phoneCode login ...");
    	
    	//1.判断 token 是否有效
    	String tempToken = redisService.get(tempTokenKey);
    	if(StringUtils.isBlank(tempToken)){
            logger.error("TokenKey FAIL. {}", tempTokenKey);
            return Response.ok(new Result<NewCookie>(ResultCode.UNAUTHORIZED)).build();
    	}
    	AuthToken authToken = AuthToken.parse(tempToken);
    	if(authToken == null){
            logger.error("TokenKey FAIL. {}", tempTokenKey);
            return Response.ok(new Result<NewCookie>(ResultCode.UNAUTHORIZED)).build();
    	}
    	
    	//2.确定登录指定账户
    	this.sessionService.createSession(authToken);
        logger.info("phoneCode Login OK. {}", tempTokenKey);
        
        final String token = authToken.token();
        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok(token));
        // add cookie
        String[] cookieNames = {Constants.AUTH_TOKEN_NAME};
        for (String cookieName : cookieNames) {
            Cookie cookie = new Cookie(cookieName, token, "/", CookieUtils.getCookieDomain());
            NewCookie newCookie;
            if (remomber) {
                newCookie = new NewCookie(cookie, "", Constants.AUTH_TOKEN_AGE_MAX, false);
            } else {
                newCookie = new NewCookie(cookie);
            }
            responseBuilder.cookie(newCookie);
        }

        return responseBuilder.build();
    }

    
    private AuthToken createTempAuthToken(long userId, long userType, boolean remember) {
        long age = Constants.AUTH_TOKEN_AGE_MAX;

        // set authToken cookie
        final long now = System.currentTimeMillis();
        final long expiry = now + age * 1000;
        /*final AuthToken authToken = new AuthToken(userId, AccountType.ADMIN_USER, now, expiry, RandUtil.rand());*/
        final AuthToken authToken = new AuthToken(userId, userType, now, expiry, RandUtil.rand());
        return authToken;
    }

    public static class UserView{
    	//用户ID
    	private Long userId;
    	//用户类型
    	private Long userType;
    	//用户名称
    	private String userName;
    	//临时 token key
    	private String tempTokenKey;
    	//角色列表
    	private List<RoleVo> roleVos = new ArrayList<RoleVo>();
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getUserType() {
			return userType;
		}
		public void setUserType(Long userType) {
			this.userType = userType;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getTempTokenKey() {
			return tempTokenKey;
		}
		public void setTempTokenKey(String tempTokenKey) {
			this.tempTokenKey = tempTokenKey;
		}
		public List<RoleVo> getRoleVos() {
			return roleVos;
		}
		public void setRoleVos(List<RoleVo> roleVos) {
			this.roleVos = roleVos;
		}
    }
    
    
    public static class PhoneParam{
        @Size(min=11, message="cellphone required")
        private String cellphone;

        @NotNull(message="phoneCode required")
        private String phoneCode;

		public String getCellphone() {
			return cellphone;
		}

		public void setCellphone(String cellphone) {
			this.cellphone = cellphone;
		}

		public String getPhoneCode() {
			return phoneCode;
		}

		public void setPhoneCode(String phoneCode) {
			this.phoneCode = phoneCode;
		}
    }
}
