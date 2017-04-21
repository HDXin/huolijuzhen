package com.sudaotech.account.web.admin;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.inject.Inject;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.CellphoneParams;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.StringUtil;

/**
 * @desc 企业用户变更手机号
 * @author fuqq
 * @date 2016-12-20
 */
@Path("/{platformSource}/admin/cellphone")
public class AdminCellphoneResource extends BaseResource {
    
    @Inject
    private PhoneCodeService phoneCodeService;
    @Inject
    private AdminUserService adminUserService;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PUT
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> updateCellphone(
    		@Valid CellphoneParam param, 
    		@NotNull @PathParam("platformSource") String platformSource) {
    	//权限校验
    	logger.debug("Cheking Auth");
    	ResultCode code = checkAuth(platformSource.toUpperCase());
    	if(!ResultCode.OK.equals(code)){
    		logger.error("error auth check, platformSource = {}",platformSource.toUpperCase());
            return new Result<String>(code);
    	}
    	
    	//参数校验
    	CellphoneParams cellphoneParamsCode = verify(param);
    	if(!CellphoneParams.OK.equals(cellphoneParamsCode)){
    		logger.error("error params check, newCellphone={}, oldCellphone={}, phoneCode={}",
    				param.getNewCellphone(),param.getOldCellphone(),param.getOldCellphone());
            return new Result(String.valueOf(cellphoneParamsCode.code()),cellphoneParamsCode.text());
    	}
    	
    	//校验旧手机号与库中是否一致
    	Long userId = getSession().getUserId();
    	AdminUser user = adminUserService.getById(userId);
    	if(user == null)			//用户不存在
    		return new Result<String>(ResultCode.NOT_FOUND);
    	else if(!param.getOldCellphone().equals(user.getCellphone())){
    		logger.debug("旧手机号与用户对应手机号不一致");
    		return new Result<String>(ResultCode.ADMIN_USER_CELLPHONE_ERROR_OLDCELLPHONE);
    	}
    	
    	//验证码校验
        logger.debug("Checking phoneCode");
        if (!phoneCodeService.checkPhoneCode(param.getOldCellphone(), param.getPhoneCode())) {
            logger.error("Updating cellphone failed. Invalid phoneCode. param: {}", param);
            return new Result<String>(ResultCode.PHONE_CODE_ERROR);
        }
        
        //新手机号存在性校验
        AdminUser adminUser = this.adminUserService.getByCellphoneAndPlatformSource(param.getNewCellphone(),PlatformSource.valueOf(platformSource.toUpperCase()));
        if (adminUser != null) {
            if (adminUser.getUserId().equals(userId)) {
                return ResultSupport.ok(); // no need to update
            }
            return new Result<String>(ResultCode.USER_CELLPHONE_DUPLICATED);
        }
        
        //update
        AdminUser obj = new AdminUser();
        obj.setUserId(userId);
        obj.setCellphone(param.getNewCellphone());
        this.adminUserService.update(obj);
            
        return new Result<String>(ResultCode.OK);
    }
    
    /**
     * 权限校验
     * */
    public ResultCode checkAuth(String platformSource){
    	//从请求路径中的平台来源进行校验
    	if(!PlatformSource.ENTERPRISE.name().equals(platformSource.toUpperCase())) 
    		return ResultCode.ADMIN_USER_CELLPHONE_ERROR_PLATFORM_SOURCE;
    	Long userId = getSession().getUserId();
    	AdminUser adminUser = adminUserService.getById(userId);
    	if(adminUser == null)			//用户不存在
    		return ResultCode.NOT_FOUND;
    	else if(!PlatformSource.ENTERPRISE.equals(adminUser.getPlatformSource()))		//登录用户非企业用户
    		return ResultCode.ADMIN_USER_CELLPHONE_ERROR_PLATFORM_SOURCE;
    	return ResultCode.OK;
    }
    
    /**
     * 参数校验
     * */
    public CellphoneParams verify(CellphoneParam param){
    	String newCellPhone = param.getNewCellphone();
    	String oldCellPhone = param.getOldCellphone();
    	String phoneCode = param.getPhoneCode();
    	if(StringUtil.isEmpty(newCellPhone)){
    		logger.debug(CellphoneParams.NEW_CELLPHONE_IS_NULL.text());
    		return CellphoneParams.NEW_CELLPHONE_IS_NULL;
    	}else if(!StringUtil.isNumberFormat(newCellPhone)){		//判断是否全为数字
    		logger.debug(CellphoneParams.NEW_CELLPHONE_ERROR_FORMAT.text());
    		return CellphoneParams.NEW_CELLPHONE_ERROR_FORMAT;
    	}else if(!StringUtil.isRightDigit(11, newCellPhone)){		//判断手机号位数是否为11位
    		logger.debug(CellphoneParams.NEW_CELLPHONE_ERROR_NUMBER.text());
    		return CellphoneParams.NEW_CELLPHONE_ERROR_NUMBER;
    	}else if(StringUtil.isEmpty(oldCellPhone)){
    		logger.debug(CellphoneParams.OLD_CELLPHONE_IS_NULL.text());
    		return CellphoneParams.OLD_CELLPHONE_IS_NULL;
    	}else if(!StringUtil.isNumberFormat(oldCellPhone)){		//判断是否全为数字
    		logger.debug(CellphoneParams.OLD_CELLPHONE_ERROR_FORMAT.text());
    		return CellphoneParams.OLD_CELLPHONE_ERROR_FORMAT;
    	}else if(!StringUtil.isRightDigit(11, oldCellPhone)){		//判断手机号位数是否为11位
    		logger.debug(CellphoneParams.OLD_CELLPHONE_ERROR_NUMBER.text());
    		return CellphoneParams.OLD_CELLPHONE_ERROR_NUMBER;
    	}else if(StringUtil.isEmpty(phoneCode)){
    		logger.debug(CellphoneParams.VERIFY_CODE_IS_NULL.text());
    		return CellphoneParams.VERIFY_CODE_IS_NULL;
    	}else if(!StringUtil.isNumberFormat(newCellPhone)){		//判断是否全为数字
    		logger.debug(CellphoneParams.VERIFY_CODE_ERROR_FORMAT.text());
    		return CellphoneParams.VERIFY_CODE_ERROR_FORMAT;
    	}else if(newCellPhone.equals(oldCellPhone)){
    		logger.debug(CellphoneParams.SAME_PHONE.text());
    		return CellphoneParams.SAME_PHONE;
    	}
    	return CellphoneParams.OK;
    }
    
    public static class CellphoneParam {
    	//新手机号
        @NotNull(message="newCellphone required")
        private String newCellphone;
        //旧手机号
        @NotNull(message="oldCellphone required")
        private String oldCellphone;
        @NotNull(message="phoneCode required")
        private String phoneCode;
		public String getNewCellphone() {
			return newCellphone;
		}
		public void setNewCellphone(String newCellphone) {
			this.newCellphone = newCellphone;
		}
		public String getOldCellphone() {
			return oldCellphone;
		}
		public void setOldCellphone(String oldCellphone) {
			this.oldCellphone = oldCellphone;
		}
		public String getPhoneCode() {
			return phoneCode;
		}
		public void setPhoneCode(String phoneCode) {
			this.phoneCode = phoneCode;
		}
		@Override
		public String toString() {
			return "CellphoneParam [newCellphone=" + newCellphone
					+ ", oldCellphone=" + oldCellphone + ", phoneCode="
					+ phoneCode + "]";
		}
    }
    
}
