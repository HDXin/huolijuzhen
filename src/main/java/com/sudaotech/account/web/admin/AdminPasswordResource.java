package com.sudaotech.account.web.admin;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.crypt.PasswordCrypt;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.commons.constant.Constants.Park;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.user.enums.PasswordStatus;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;

/**
 * 用户密码
 */
@Path("/admin/password")
public class AdminPasswordResource extends BaseResource {
    
    @Inject
    private AdminUserService userService;
    
    @Inject
    private PhoneCodeService phoneCodeService;

    @PUT
    @Path("/oldPassword")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> updatePassword(@Valid Password password) {
    	
        String encrypt = PasswordCrypt.encrypt(password.getPassword());
        
        //当前登录的用户ID
        Long userId = getSessionQuietly().getUserId();
        if(userId == null || userId == 0){
        	return new Result<String>(ResultCode.SESSION_IS_NULL);
        }

        //需要被修改密码的用户ID
        Long targetUserId = password.getUserId();
        if(targetUserId != null && targetUserId != 0){
        	userId = targetUserId;
        }
        //获取指定 ID 的用户信息
        AdminUser user = userService.getById(userId);
        if(!user.getPassword().equals(encrypt)){
        	return new Result<String>(ResultCode.USER_PASSWORD_ERROR);
        }
        AdminUser obj = new AdminUser();
        this.setOperator(obj);
        obj.setUserId(userId);
        obj.setPasswordStatus(PasswordStatus.NORMAL.code());
        obj.setPassword(password.getNewPassword());
        this.userService.update(obj);
        
        return new Result<String>(ResultCode.OK);
        
    }
    
    @PUT
    @Path("/resetPassword")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> resetPassword(@Valid Password password) {
    	
        //当前登录的用户ID
        Long userId = getSessionQuietly().getUserId();
        if(userId == null || userId == 0){
        	return new Result<String>(ResultCode.SESSION_IS_NULL);
        }

        //需要被修改密码的用户名
        String userName = password.getUserName();
        if(StringUtils.isBlank(userName)){
        	return new Result<String>(ResultCode.BAD_REQUEST);
        }
        
        //获取对应的用户信息
        AdminUser parkAmindUser = userService.getByUsername(userName);
        if(parkAmindUser == null){
        	return new Result<String>(ResultCode.BAD_REQUEST);
        }
        
        //重置用户密码
        AdminUser obj = new AdminUser();
        obj.setUserId(parkAmindUser.getUserId());
        obj.setOperator(userId);
        obj.setPassword(Park.ADMIN_USER_PWD);
        this.userService.update(obj);
        
        return new Result<String>(ResultCode.OK);
    }
    
    @PUT
    @Path("/phoneCode")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> updatePassword(@Valid PasswordParam param) {
        logger.debug("Checking phoneCode");
        if (!phoneCodeService.checkPhoneCode(param.getCellphone(), param.getPhoneCode())) {
            logger.error("updatePassword failed. Invalid phoneCode. Param: {}", param);
            return new Result<String>(ResultCode.PHONE_CODE_ERROR);
        }
        
        AdminUser user = this.userService.getByUsername(param.getUserName());
        if (user != null) {
        	AdminUser obj = new AdminUser();
            obj.setOperator(user.getUserId());
            obj.setUserId(user.getUserId());
            obj.setPassword(param.getPassword());
            obj.setPasswordStatus(PasswordStatus.NORMAL.code());
            this.userService.update(obj);
            
            return new Result<String>(ResultCode.OK);
        }
        
        return new Result<String>(ResultCode.BAD_REQUEST);
    }
    
    public static class PasswordParam {
    	
        @NotNull(message="userName required")
        private String userName;
    	
        @Size(min=11, message="cellphone required")
        private String cellphone;

        @Size(min=3, message="password required")
        private String password;

        @NotNull(message="phoneCode required")
        private String phoneCode;

        public String getCellphone() {
            return cellphone;
        }
        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getPhoneCode() {
            return phoneCode;
        }
        public void setPhoneCode(String phoneCode) {
            this.phoneCode = phoneCode;
        }
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
        
    }
    
    public static class Password {
    	
    	private Long userId;
        @Size(min=3)
        private String password;
        @Size(min=3)
        private String newPassword;
        //用户登录名
        private String userName;
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getNewPassword() {
            return newPassword;
        }
        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
    }
}
