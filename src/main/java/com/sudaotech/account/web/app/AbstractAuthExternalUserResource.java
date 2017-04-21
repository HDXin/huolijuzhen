package com.sudaotech.account.web.app;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.inject.Inject;
import com.sudaotech.account.service.AppAuthService;
import com.sudaotech.account.service.Login;
import com.sudaotech.core.Constants;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.util.PasswordGenerator;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserService.AppUser;
import com.sudaotech.user.service.ExternalUserService;
import com.sudaotech.user.service.ExternalUserService.ExternalUser;
import com.sudaotech.util.CookieUtils;

/**
 * 第三方用户账户注册，比如微信，微博，QQ
 * 微信，微博，QQ 用户登录后，要在后台用户账户
 * 1. APP先到微信，微博，QQ登录，获得用户信息，比如openid
 * 2. APP调用后台接口，后台接口生成一个用户账户，然后再关联表中将openid与用户关联
 */
public abstract class AbstractAuthExternalUserResource extends BaseResource {

    @Inject
    private AppUserService userService;

    @Inject
    private AppAuthService authService;
    
    @Inject
    private ExternalUserService externalUserService; // 关联表
    
    /**
     * 根据第三方 id查询平台用户
     * 
     * @param openid 用户 id
     * @param channel  渠道: wx, wb, qq
     * @return
     */
    protected ExternalUser getExternalUser(String openId, String channel) {
    	logger.info("Try to get ExternalUser: {} openId: {}", channel, openId);
    	return this.externalUserService.getByOpenId(openId);
    }
    
    /**
     * 创建新的APP用户
     * 
     * @param registerVo
     * @return
     */    
    protected Long createAppUser(AppUser obj) {
        obj.setPassword(PasswordGenerator.getPassword(8));
        
        /*
        if (obj.getNickname() == null) {
            obj.setNickname("用户");
        }
        // 生成 随机码代替cellphone
        if (obj.getCellphone() == null) {
            obj.setCellphone(PasswordGenerator.getPassword(8));
        }*/
        
        return this.userService.create(obj);
    }
    
    
    protected ExternalUser buildExternalUser(Long userId, String openId, int type, String accessToken, String json) {
    	ExternalUser vo = new ExternalUser();
    	vo.setUserId(userId);
    	vo.setOpenId(openId);
    	vo.setAccessToken(accessToken);
    	vo.setJson(json);
    	vo.setType(type);
    	return vo;
    }
    
    /**
     * 创建用户关联表记录
     * 
     * @param userId
     * @param openId
     * @param accessToken
     * @param json
     * @return
     */
	protected Long createExternalUser(Long userId, String openId, int type, String accessToken, String json) {
    	logger.error("Try to create ExternalUser for wx openid: {}", openId);
    	ExternalUser vo = this.buildExternalUser(userId, openId, type, accessToken, json);
        return this.externalUserService.create(vo);
    }
    
    /**
     * 为用户登陆生成auth token
     * 
     * @param userId
     * @param cookieName
     * @return
     */
    protected AuthToken createAuthToken(long userId, String openid) {
        AppUser user = this.userService.getById(userId);
        
        // login
        Login login = new Login();
        login.setUserId(userId);
        login.setOpenid(openid);
        login.setUsername(user.getUsername());
        login.setCellphone(user.getCellphone());
        login.setPassword(user.getPassword());
        login.setUserType(user.getUserType());
        login.setIp(this.httpRequest.getRemoteHost());

        logger.info("Login.createAuthToken..: {}", login);

        
        // try to authenticate the login request
        AuthToken authToken = this.authService.create(login);
        if (authToken == null) {
            logger.error("AuthToken creation FAIL. {}", login);
        } else {
        	logger.info("Auth token OK. {}", login.getUserId());
        }
        
        // 设置session
        this.sessionService.createSession(authToken);

        return authToken;
    }
    
    protected Response buildResponse(AuthToken authToken) {
        this.sessionService.createSession(authToken);

        final String token = authToken.token();
        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok(token));
        // add cookie
        Cookie cookie = new Cookie(Constants.AUTH_TOKEN_NAME, token, "/", CookieUtils.getCookieDomain());
        NewCookie newCookie = new NewCookie(cookie, "", Constants.AUTH_TOKEN_AGE_MAX, false);
        responseBuilder.cookie(newCookie);

        return responseBuilder.build();
    }

}
