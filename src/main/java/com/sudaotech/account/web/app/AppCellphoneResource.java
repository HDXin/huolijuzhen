package com.sudaotech.account.web.app;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserService.AppUser;

/**
 * 用户手机号
 */
@Path("/app/cellphone")
public class AppCellphoneResource extends BaseResource {
    
    @Inject
    private AppUserService userService;
    @Inject
    private PhoneCodeService phoneCodeService;
    
    @POST
    @PUT
    @Path("/bind")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> bindCellphone(@Valid BindCellphoneParam param) {
        
        logger.debug("Checking phoneCode");
        if (!phoneCodeService.checkPhoneCode(param.getCellphone(), param.getPhoneCode())) {
            logger.error("Updating cellphone failed. Invalid phoneCode. param: {}", param);
            return new Result<String>(ResultCode.PHONE_CODE_ERROR);
        }
        
        final Long userId = getSession().getUserId();
        AppUser appUser = this.userService.getByCellphone(param.getCellphone());
        if (appUser != null) {
            if (appUser.getUserId().equals(userId)) {
                return ResultSupport.ok(); // no need to update
            }
            return new Result<String>(ResultCode.USER_CELLPHONE_DUPLICATED);
        }
        
        AppUser me = this.userService.getById(userId);
        if (StringUtils.isNotBlank(me.getCellphone())) {
            return new Result<String>(ResultCode.USER_CELLPHONE_BINDED);
        }
        
        AppUser obj = new AppUser();
        obj.setUserId(userId);
        // 暂时屏蔽
//        obj.setUsername(param.getCellphone()); // 第三方登陆绑定手机号时同步更新username
        obj.setCellphone(param.getCellphone());
        obj.setPassword(param.getPassword());
        this.userService.update(obj);
            
        return new Result<String>(ResultCode.OK);
    }
        
    @PUT
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> updateCellphone(@Valid CellphoneParam param) {
        
        logger.debug("Checking phoneCode");
        if (!phoneCodeService.checkPhoneCode(param.getCellphone(), param.getPhoneCode())) {
            logger.error("Updating cellphone failed. Invalid phoneCode. param: {}", param);
            return new Result<String>(ResultCode.PHONE_CODE_ERROR);
        }
        
        Long userId = getSession().getUserId();
        AppUser appUser = this.userService.getByCellphone(param.getCellphone());
        if (appUser != null) {
            if (appUser.getUserId().equals(userId)) {
                return ResultSupport.ok(); // no need to update
            }
            return new Result<String>(ResultCode.USER_CELLPHONE_DUPLICATED);
        }
        
        AppUser obj = new AppUser();
        obj.setUserId(userId);
        obj.setCellphone(param.getCellphone());
        this.userService.update(obj);
            
        return new Result<String>(ResultCode.OK);
    }
    
    @GET
    @Path("/exist")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Boolean> existCellphone(@NotNull @QueryParam("cellphone") String cellphone) {
        AppUser appUser = this.userService.getByCellphone(cellphone);
            
        return new Result<Boolean>(ResultCode.OK, appUser != null);
    }
    
    public static class BindCellphoneParam {
        @NotNull(message="cellphone required")
        private String cellphone;
        @NotNull(message="phoneCode required")
        private String phoneCode;
        @NotNull(message="password required")
        private String password;
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
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("BindCellphoneParam [cellphone=").append(cellphone).append(", phoneCode=").append(phoneCode)
                    .append(", password=").append(password).append("]");
            return builder.toString();
        }
    }
    public static class CellphoneParam {
        @NotNull(message="cellphone required")
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
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("CellphoneParam [cellphone=").append(cellphone).append(", phoneCode=").append(phoneCode)
                    .append("]");
            return builder.toString();
        }
    }
}
