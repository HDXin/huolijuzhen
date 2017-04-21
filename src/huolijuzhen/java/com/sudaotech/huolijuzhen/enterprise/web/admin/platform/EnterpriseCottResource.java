package com.sudaotech.huolijuzhen.enterprise.web.admin.platform;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService.EnterpriseCorrBusiness;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCottInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.Query;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrType;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;

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

@Path("/admin/platform/ec")
public class EnterpriseCottResource extends BaseResource {

    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private EnterpriseCorrContractService enterpriseCorrContractService;
    
    @Inject
    private EnterpriseCorrBusinessService enterpriseCorrBusinessService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @GET
    @Path("/park")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<EnterpriseCott>> getByParkId(@QueryParam("parkId") final Long parkId) {
    	
      List<EnterpriseCott> obj =enterpriseCottService.getEnterPriseCottByParkId(parkId);
        
        return new Result<List<EnterpriseCott>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<EnterpriseCottInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("enterpriseId") Long enterpriseId
    		) {
    	Session session=getSessionQuietly();
    	if(session.getUserId() == null || session.getUserId()==0){
    		return new Result<Page<EnterpriseCottInfo>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(enterpriseId == null ){
    		return new Result<Page<EnterpriseCottInfo>>(ResultCode.BAD_REQUEST);
    	}
    	
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setEnterpriseId(enterpriseId);
		
		Page<EnterpriseCottInfo> page = enterpriseCottService.findByObj(query);
        return new Result<Page<EnterpriseCottInfo>>(ResultCode.OK, page);
    }
    
    
    /**
     *        通过企业Id获取关联信息详情（包括合同关联信息或业务关联信息）
     * @param enterpriseId
     * @return
     */
    @GET
    @Path("/detail/{enterpriseId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<EnterpriseCott>> getDetail(@NotNull @PathParam("enterpriseId") final Long enterpriseId) {
    	
    	Session session = getSessionQuietly();
    	if(session.getUserId() == null || session.getUserId() ==0){
    		return new Result<List<EnterpriseCott>>(ResultCode.SESSION_IS_NULL);
    	}    	
    	List<EnterpriseCott> ecs =null;
    	try {
	    	//获取关联关系
    		 ecs= enterpriseCottService.getEnterPriseCottByEnterpriseId(enterpriseId,null);
	    	
	        if(CollectionUtils.isNotEmpty(ecs)){
	        	
	        	for (EnterpriseCott enterpriseCott : ecs) {
	        		//园区信息
	        		if(enterpriseCott.getParkId() != null && enterpriseCott.getParkId() != 0){
	        			enterpriseCott.setPi(parkInfoService.getById(enterpriseCott.getParkId()));
	        		}
	        		//合同关联
		        	if(enterpriseCott.getCorrType() ==  CorrType.CONTRACT_RELATED){
		        		EnterpriseCorrContract ecc =new EnterpriseCorrContract();
		        		ecc.setEnterpriseCottId(enterpriseCott.getId());
		        		List<EnterpriseCorrContract> eccList=enterpriseCorrContractService.findByObj(ecc);  
		        		
		        		//封装合同基本信息
		        		if(CollectionUtils.isNotEmpty(eccList)){
		        			ContractInfo contractInfo = null;
		        			for(EnterpriseCorrContract item:eccList){
		        				if(item.getContractId() != null){
			        				contractInfo = contractInfoService.getById(item.getContractId());
		        					item.setCi(contractInfo);
		        				}
		        			}
		        		}
		        		enterpriseCott.setCorrContract(eccList);
		        	}
		        	//业务关联
		            if(enterpriseCott.getCorrType() ==  CorrType.BUSINESS_RELATED){
		        		EnterpriseCorrBusiness ebc =new EnterpriseCorrBusiness();
		        		ebc.setEnterpriseCottId(enterpriseCott.getId());
		        		enterpriseCott.setCorrBusiness(enterpriseCorrBusinessService.findByObj(ebc));
		            	
		        	}
				}
	        	
	        }
	    	
		} catch (Exception e) {
				logger.error("通过企业Id查询关联信息详情异常：{}",e.getMessage());
				return new Result<List<EnterpriseCott>>(ResultCode.INTERNAL_SERVER_ERROR,ecs);
		}
        
        return new Result<List<EnterpriseCott>>(ecs == null ? ResultCode.NOT_FOUND : ResultCode.OK, ecs);
        
    }
    
}
