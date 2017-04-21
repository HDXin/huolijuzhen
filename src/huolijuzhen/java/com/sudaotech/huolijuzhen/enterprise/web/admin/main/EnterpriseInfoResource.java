package com.sudaotech.huolijuzhen.enterprise.web.admin.main;

import java.util.Arrays;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AccountService.Account;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierService.EnterpriseDossier;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.sms.service.PhoneCodeService;
import com.sudaotech.user.UserType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

/**
 * 
 * @Describe:       企业信息
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.enterprise.web.admin.park
 *
 * @Date:           2016年11月26日 下午3:47:47
 *
 */
@Path("/admin/main/enterpriseInfo")
public class EnterpriseInfoResource extends BaseResource {

    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private AccountService accountService;
    
    @Inject
    private EnterpriseDossierService enterpriseDossierService;
    
    @Inject
    private GenCodeService genCodeService; 
    
    @Inject
    private PhoneCodeService phoneCodeService;
    
    
    /**
     * 活力矩阵官方首页 企业入驻
     * @param obj
     * @return
     */
    
    @POST
    @Path("/register")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, String>> register(@Valid final EnterpriseInfo obj) {
    	
    	try{
        	String adminAccount=genCodeService.nextCodeByType(Constants.Enterprise.ADMIN_USER_PREFIX);
        	
        	//验证验证码
            if(obj.getPhone() == null || obj.getPhoneCode() == null){
            	return new Result<Map<String,String>>(ResultCode.BAD_REQUEST);
            }  
            
        	if(!phoneCodeService.checkPhoneCode(obj.getPhone(), obj.getPhoneCode())){
        		return new Result<Map<String,String>>(ResultCode.PHONECODE_IS_ERROR);
        	}
        	
            //创建企业主信息
            obj.setAdminAccount(adminAccount);
        	obj.setCreateSource(CreateSource.PLATFORM);
            
            
            Long id = enterpriseInfoService.create(obj);
            
            //创建企业档案信息
            if(CollectionUtils.isNotEmpty(obj.getEnterpriseDossiers())){
            	for (EnterpriseDossier dossier : obj.getEnterpriseDossiers()) {
            		dossier.setEnterpriseId(id);
            		enterpriseDossierService.create(dossier);
    			}
            }
            
            //创建企业管理员用户
            AdminUser au=new AdminUser();
            au.setCellphone(obj.getPhone());
            au.setUsername(adminAccount);
            au.setName(obj.getName());
            au.setPassword(Constants.Enterprise.ADMIN_USER_PWD);
            au.setTel(obj.getPhone());
            au.setPlatformSource(PlatformSource.ENTERPRISE);
            au.setPlatformSourceId(id);
            //默认管理员用户
            au.setUserType(UserType.ADMIN_USER);
            
    	    Long newUserId = adminUserService.create(au);
    	   
    	    //赋值管理员角色
    	    Account account = new Account();
    	    account.setUserId(newUserId);
    	    account.setRoleIds(Arrays.asList(Constants.Enterprise.ADMIN_ROLE_ID));
    	    accountService.createAccount(account);
            
            Map<String, String> map = MapHelper.put("adminAccount", adminAccount).getMap();
            Result<Map<String, String>> result = new Result<Map<String, String>>(ResultCode.OK);
            result.setData(map);
            
            return result;
    		
    	}catch(Exception e){
    		logger.error("企业入驻 error:{}",e);
    		return new Result<Map<String,String>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    /**
     * 查询编码是否可用
     * @param code
     * @return
     */
    @GET
    @Path("/availability/{code}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Boolean> getExistentCode(@NotNull @PathParam("code") final String code) {
    	
        EnterpriseInfo obj = enterpriseInfoService.findByCode(code);
        
        return new Result<Boolean>(ResultCode.OK,obj == null ? true : false);
    }
    
}
