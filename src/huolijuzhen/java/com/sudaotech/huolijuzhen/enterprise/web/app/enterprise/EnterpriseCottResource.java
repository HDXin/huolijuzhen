package com.sudaotech.huolijuzhen.enterprise.web.app.enterprise;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService.EnterpriseCorrBusiness;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;

/**
 * 
 * @Describe:       企业园区关联关系
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.enterprise.web.admin.park
 *
 * @Date:           2016年11月26日 下午3:47:23
 *
 */

@Path("/app/enterprise/ec")
public class EnterpriseCottResource extends BaseResource {

    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private EnterpriseCorrBusinessService EnterpriseCorrBusinessService;
    
    
    /**
     * 描述：园区向企业管理员发出业务关联邀请，企业管理员点击确认关联
     * @param id
     * @param obj
     * @return
     */
	@PUT
    @Path("/cott/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> cott(@NotNull @PathParam("id") final Long id) {
		
		   Long userId = getSessionQuietly().getUserId();
		   if(userId ==null || userId ==0){
			   
			   return new Result<String>(ResultCode.SESSION_IS_NULL);
		   }
		   EnterpriseCott ec = enterpriseCottService.getById(id);
		   
		   if(ec == null){
			   return new Result<String>(ResultCode.NOT_FOUND);
		   }
		   //校验关联关系不为 已入驻 状态
		   if(ec.getCorrStatus() == CorrStatus.ALREADY_SETTLED){
			   return new  Result<String>(ResultCode.CORR_STATUS_UPDATE_ERROR);
		   }
		   //校验关联类型为 业务类型
		   if(ec.getCorrType() != CorrType.BUSINESS_RELATED){
			   return new  Result<String>(ResultCode.CORR_TYPE_UPDATE_ERROR);
		   }
		   
    	   EnterpriseCott ecott =new EnterpriseCott();
    	   ecott.setCorrStatus(CorrStatus.ALREADY_SETTLED);
    	   ecott.setOperator(userId);
    	   ecott.setId(ec.getId());
    	   
           //业务关联
    	   enterpriseCottService.update(ecott);
    	   
    	   //查询业务关联信息
    	   EnterpriseCorrBusiness ebc=new EnterpriseCorrBusiness();
    	   ebc.setEnterpriseCottId(id);
    	   List<EnterpriseCorrBusiness> ebcs=EnterpriseCorrBusinessService.findByObj(ebc);
    	   
    	   if(CollectionUtils.isNotEmpty(ebcs)){
    		   EnterpriseCorrBusiness obj=ebcs.get(0);
    		   obj.setCottStatus(2);
    		   obj.setCottTime(new Date());
    		   obj.setCottUser(userId);
    		   EnterpriseCorrBusinessService.update(obj);
    	   }
         
    	   return ResultSupport.ok();
    }
   
}
