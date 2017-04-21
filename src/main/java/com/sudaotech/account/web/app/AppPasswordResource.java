package com.sudaotech.account.web.app;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.user.enums.PasswordStatus;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserService.AppUser;

/**
 * 通过手机号、验证码、用户密码更新
 */
@Path("/app/password")
public class AppPasswordResource extends BaseResource {
    
    @Inject
    private AdminUserService userService;
    @Inject
    private PhoneCodeService phoneCodeService;

    @PUT
    @Path("")
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
}
