package com.sudaotech.user.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.account.service.RoleService;
import com.sudaotech.core.Session;
import com.sudaotech.core.annotation.RequirePermission;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.template.TemplateConfig;
import com.sudaotech.core.template.TemplateKey;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseUserCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseUserCottService.EnterpriseUserCott;
import com.sudaotech.huolijuzhen.util.Contains;
import com.sudaotech.sms.service.Sms;
import com.sudaotech.sms.service.SmsService;
import com.sudaotech.user.UserPermissionDef;
import com.sudaotech.user.UserType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.user.service.AdminUserService.BindPark;
import com.sudaotech.user.service.AdminUserService.Query;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.MapHelper;

@Path("/{platformSource}/admin/adminUser")
public class AdminUserResource extends BaseResource {

    @Inject
    private AdminUserService userService;
    @Inject
    private RoleService roleService;
    
    @Inject
    private MessageService messageService;
    
    @Inject
    private EnterpriseUserCottService enterpriseUserCottService;
    
    @Inject
    private SmsService smsService;
    
    @RequirePermission(UserPermissionDef.RETRIEVE_USER)
    @GET
    @Path("/regMessageUser")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> regMessageUser() {
    	
    	try{
        	Query query = new Query();
        	query.setLimit(300);
        	
        	Page<AdminUser> page = userService.find(query);
        	
        	List<AdminUser> users = page.getItems();
        	if(CollectionUtils.isNotEmpty(users)){
        		for(AdminUser item:users){
        			if(item.getPlatformSourceId() != 0){
        				
        				Long userId = item.getUserId();
        				Long userType = item.getUserType();
        				Long platformSourceId = item.getPlatformSourceId();
        				if(platformSourceId == 0){
        					continue;
        				}
        				
        				AuthToken token = new AuthToken(userId, userType, System.currentTimeMillis(), System.currentTimeMillis()+ (365 * 24 * 3600)*1000, "2383");
        		        Map<String, String> headers = new HashMap<String, String>();
        		        headers.put("appId", Contains.Base.appId);
        		        headers.put("token", token.token());
        		        
        		        messageService.regMiddleware(headers, userId.toString());
        			}
        		}
        	}
            return new Result<String>(ResultCode.OK);
    		
    	}catch(Exception e){
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(
    		@Valid final AdminUser obj,
    		@NotNull @PathParam("platformSource") String platformSource) {
    	try{
    		//判断用户名是否可用
    		AdminUser usernameUser = this.userService.getByCellphoneAndPlatformSource(obj.getCellphone(), PlatformSource.valueOf(platformSource.toUpperCase()));
            if (usernameUser != null) {
                this.logger.warn("手机号已被使用: {}", obj.getUsername());
                Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.CONFLICT);
                result.setMessage("手机号已被使用");
                return result;
            }
            //判断手机号是否可用
    		AdminUser cellphoneUser = this.userService.getByUsernameAndPlatformSource(obj.getUsername(),PlatformSource.valueOf(platformSource.toUpperCase()));
            if (cellphoneUser != null) {
                this.logger.warn("用户名已存在: {}", obj.getUsername());
                Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.CONFLICT);
                result.setMessage("用户名已存在");
                return result;
            }
            
            // create
            Session session = getSessionQuietly();
            obj.setPlatformSource(PlatformSource.valueOf(platformSource.toUpperCase()));
            obj.setPlatformSourceId(session.getPlatformId());
            obj.setOperator(session.getUserId());
            obj.setCompanyId(session.getCompanyId());
            obj.setUserType(UserType.NORMAL_USER);
            
            //企业用户需给初始密码
            if(obj.getPlatformSource() == PlatformSource.ENTERPRISE){
            	//默认密码取手机号后六位
            	obj.setPassword(obj.getCellphone().substring(5,11));
            }
            
            //初始化密码（明文）
            String pass = obj.getPassword();
            long id = userService.create(obj);
            //园区用户
            if(obj.getPlatformSource() == PlatformSource.PARK){
            	//发送消息
                Sms sms = new Sms();
                sms.setPhoneNum(obj.getCellphone());
                String content = TemplateConfig.format(TemplateKey.PARK_USER_CREATE, pass);
                sms.setContent(content);
            	smsService.sendSms(sms, session);
            }
            //企业用户
            if(obj.getPlatformSource() == PlatformSource.ENTERPRISE){
            	//用户绑定的园区
            	if(CollectionUtils.isNotEmpty(obj.getBindParks())){
            		for (BindPark bp : obj.getBindParks()) {
                    	EnterpriseUserCott euc = new EnterpriseUserCott();
                    	euc.setEnterpriseUserId(id);
                    	euc.setCottId(bp.getCottId());
                    	euc.setParkId(bp.getParkId());
                    	enterpriseUserCottService.create(euc);
					}
            	}
            	//发送消息
                Sms sms = new Sms();
                sms.setPhoneNum(obj.getCellphone());
                String content = TemplateConfig.format(TemplateKey.PASSWORD_INITIALIZED, obj.getCellphone().substring(5,11));
                sms.setContent(content);
            	smsService.sendSms(sms, session);
            }
            
            Map<String, Long> map = MapHelper.put("userId", id).getMap();
            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/adminUser/%s", id));
            result.setData(map);
            return result;	
    	}catch(Exception e){
    		logger.error("用户创建 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @RequirePermission(UserPermissionDef.UPDATE_USER)
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final AdminUser obj) {

        if (StringUtils.isNotBlank(obj.getUsername())) {
            AdminUser user = this.userService.getByUsername(obj.getUsername());
            if (user != null && !user.getUserId().equals(id)) {
                return new Result<String>(ResultCode.CONFLICT);
            }
        }
        
        // 密码长度小于6个字符，则不更改密码
        if (StringUtils.length(obj.getPassword()) < 6) {
            obj.setPassword(null);
        }

        Session session = getSession();
        obj.setOperator(session.getUserId());
        obj.setUserId(id);
        userService.update(obj);
        return ResultSupport.ok();
    }

    @RequirePermission(UserPermissionDef.DELETE_USER)
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        AdminUser obj = new AdminUser();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

    @RequirePermission(UserPermissionDef.DELETE_USER)
    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
    	if (!CollectionUtils.isEmpty(ids)) {
			for (Long id : ids) {
				delete(id);
			}
    	}
        return ResultSupport.ok();
    }

    @RequirePermission(UserPermissionDef.RETRIEVE_USER)
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<AdminUserVo> get(@NotNull @PathParam("id") final Long id) {
        AdminUser obj = userService.getById(id);
        AdminUserVo vo = toAdminUserVo(obj);
        return new Result<AdminUserVo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, vo);
    }
    
    
    /**
     * 获取园区下的物业管理账号
     * @param parkId
     * @return
     */
    @GET
    @Path("/propertyMG")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<AdminUser>> getPropertyMGByParkId(@QueryParam("parkId") Long parkId) {
    	
    	if(parkId == null){
    		return new Result<List<AdminUser>>(ResultCode.BAD_REQUEST);
    	}
    	if(getSessionQuietly().getUserId() == null){
    		return new Result<List<AdminUser>>(ResultCode.SESSION_IS_NULL);
    	}
    	
    	List<AdminUser> obj = userService.getPropertyMGByParkId(parkId);
    	
        return new Result<List<AdminUser>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
   
    }
    

    private AdminUserVo toAdminUserVo(AdminUser obj) {
        if (obj == null) {
            return null;
        }
        AdminUserVo vo = BeanUtils.copyProperties(obj, AdminUserVo.class);
        //2016-08-10 add getRoleIdByUserId
        List<Long> roleIds = userService.getRoleIdByUserId(obj.getUserId());
        //用roleIds替代obj.getRoleIds()
        if (CollectionUtils.isNotEmpty(roleIds)) {
            List<RoleVo> roles = this.roleService.getRoles(roleIds);
            vo.setRoles(roles);
            vo.setRoleIds(roleIds);
        }
        return vo;
    }

    
    @RequirePermission(UserPermissionDef.RETRIEVE_USER)
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<AdminUserVo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("username") String username,
            @QueryParam("nickname") String nickname,
            @QueryParam("name") String name,
            @QueryParam("cellphone") String cellphone,
            @QueryParam("status") String status,
            @NotNull @PathParam("platformSource") String platformSource
            ) {
    	Session session=getSessionQuietly();
    	Long userId = session.getUserId();
    	
    	if(userId  == null || userId == 0 ){
    		return new Result<Page<AdminUserVo>>(ResultCode.SESSION_IS_NULL);
    	}
    	
    	Query query = new Query();
    	query.setPlatformId(session.getPlatformId());
    	query.setPlatformSource(PlatformSource.codeOf(platformSource.toUpperCase()));
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setUsername(username);
        query.setNickname(nickname);
        query.setName(name);
        query.setCellphone(cellphone);
		query.setStatus(Status.nameOf(status));
		
		Page<AdminUser> page = userService.find(query);
		Page<AdminUserVo> voPage = new Page<AdminUserVo>(page);
		for (AdminUser item : page.getItems()) {
		    voPage.addItem(this.toAdminUserVo(item));
		}
		
        return new Result<Page<AdminUserVo>>(ResultCode.OK, voPage);
    }

    public static class AdminUserVo extends AdminUser {
        private List<RoleVo> roles;
        public List<RoleVo> getRoles() {
            return roles;
        }
        public void setRoles(List<RoleVo> roles) {
            this.roles = roles;
        }
    }
    
    public static class RoleVo {
        private Long roleId;
        private String name;
        public Long getRoleId() {
			return roleId;
		}
		public void setRoleId(Long roleId) {
			this.roleId = roleId;
		}
		public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
