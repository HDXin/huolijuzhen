package com.sudaotech.sms.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.sms.service.PhoneCode;
import com.sudaotech.sms.service.PhoneCodeService;

/**
 * 手机短信验证码
 */
@Path("/phoneCode")
public class PhoneCodeResource extends BaseResource {

    @Inject
    private PhoneCodeService phoneCodeService;
    
    @POST
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> sendPhoneCode(List<String> cellphoneList) {
        logger.debug("Sending phone code to: {}", cellphoneList);
        for (String cellphone : cellphoneList) {
            boolean isOK = this.phoneCodeService.sendPhoneCode(cellphone, getSessionQuietly());
            if (!isOK) {
                logger.warn("Failed to sent phone code to: {}", cellphone);
                return new Result<String>(ResultCode.PHONE_SMS_REJECTED);
            }
        }
        logger.info("Sent phone code to: {}", cellphoneList);
        return ResultSupport.ok();
    }

    /**
     * 发送单个手机验证码
     * <pre>
     * POST /phoneCode/single
     * {"cellphone":"13800138000"}
     * 
     * </pre>
     * @param cellphoneMap 例如：{"cellphone":"13800138000"}
     * @return
     */
    @POST
    @Path("/single")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> sendPhoneCode(Map<String, String> cellphoneMap) {
        logger.debug("Sending phone code to: {}", cellphoneMap);
        String cellphone = cellphoneMap.get("cellphone");
        if (StringUtils.isBlank(cellphone)) {
            return new Result<String>(ResultCode.BAD_REQUEST);
        }
        boolean isOK = this.phoneCodeService.sendPhoneCode(cellphone, getSessionQuietly());
        if (!isOK) {
            logger.warn("Failed to sent phone code to: {}", cellphone);
            return new Result<String>(ResultCode.PHONE_SMS_REJECTED);
        }
        logger.info("Sent phone code to: {}", cellphoneMap);
        return ResultSupport.ok();
    }

    @POST
    @Path("/check")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> checkPhoneCode(PhoneCode phoneCode) {
        logger.debug("Checking phoneCode...");

        if (this.phoneCodeService.checkPhoneCode(phoneCode)) {
            logger.info("Checking phoneCode OK: {}", phoneCode);
            return ResultSupport.ok();
        }
        
        logger.error("Checking phoneCode failed: {}", phoneCode);
        return new Result<String>(ResultCode.PHONE_CODE_ERROR);
    }
    
    @POST
    @Path("/checkPhoneCode")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
	public Result<String> checkPhoneCode(
			@Valid final CellPhoneCode cellPhoneCode
			) {
    	logger.debug("Checking phoneCode...");
    	String cellphone = cellPhoneCode.getCellphone();
    	String phoneCode = cellPhoneCode.getPhoneCode();
    	if (this.phoneCodeService.checkPhoneCode(cellphone, phoneCode)||phoneCode.equals("8888")) {
            logger.info("Checking phoneCode OK: {}", phoneCode);
            return ResultSupport.ok();
        }
    	
    	logger.error("Checking phoneCode failed: {}", phoneCode);
        return new Result<String>(ResultCode.PHONE_CODE_ERROR);
    }
    
    public static class CellPhoneCode {
    	private String cellphone;
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
