package com.sudaotech.huolijuzhen.enterprise.web.admin.park;

import java.util.Date;
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
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService.ContractResource;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.Query;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrContractStatus;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import com.sudaotech.util.MapHelper;

/**
 * 
 * @Describe:       合同关联
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.enterprise.web.admin.park
 *
 * @Date:           2016年11月26日 下午3:49:28
 *
 */
@Path("/admin/park/ecc")
public class EnterpriseCorrContractResource extends BaseResource {

    @Inject
    private EnterpriseCorrContractService enterpriseCorrContractService;
    
    @Inject 
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @Inject
    private ContractResourceService contractResourceService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EnterpriseCorrContract obj) {
        // create
        obj.setOperator(getSessionQuietly().getUserId());
        Long id = enterpriseCorrContractService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/enterpriseCorrContract/%s", id));
        result.setData(map);
        return result;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final EnterpriseCorrContract obj) {
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        enterpriseCorrContractService.update(obj);
        return ResultSupport.ok();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        EnterpriseCorrContract obj = new EnterpriseCorrContract();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

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

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<EnterpriseCorrContract> get(@NotNull @PathParam("id") final Long id) {
        EnterpriseCorrContract obj = enterpriseCorrContractService.getById(id);
        
        return new Result<EnterpriseCorrContract>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    /**
     *        通过管理关系查询企业合同关联
     * @param offset
     * @param limit
     * @param pageNum
     * @param cottId
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<EnterpriseCorrContract>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("cottId") Long cottId
            ) {
    	if(cottId ==null){
    		return new Result<Page<EnterpriseCorrContract>>(ResultCode.BAD_REQUEST);
    	}
    	
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setCottId(cottId);
		
		Page<EnterpriseCorrContract> page = enterpriseCorrContractService.find(query);
       
		if(page != null && CollectionUtils.isNotEmpty(page.getItems())){
			//添加合同信息
          for (EnterpriseCorrContract ecc : page.getItems()) {
        	  ecc.setCi( contractInfoService.getById(ecc.getContractId()));
		  }		
			
		}
		return new Result<Page<EnterpriseCorrContract>>(ResultCode.OK, page);
    }
    
    /**
     * 终止
     * @param id
     * @return
     */
    @PUT
    @Path("/stop/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> disable(@NotNull @PathParam("id") final Long id) {
            
    	Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null  || session.getUserId() == 0){
    		return new Result<String>(ResultCode.SESSION_IS_NULL) ;
    	}
    	
        //1.查询关联关系
    	EnterpriseCorrContract epcc=enterpriseCorrContractService.getById(id);
    	if(epcc == null ){
    		return new Result<String>(ResultCode.NOT_FOUND);
    	}
    	if(epcc.getContractStatus() != CorrContractStatus.ONGOING.code()){
    		return new Result<String>(ResultCode.CURRENT_STATE_IS_NOT_TERMINATED);
    	}

    	//2.更新合同状态为已终止
    	Long contractId = epcc.getContractId();
    	if(contractId != null){
    		ContractInfo contractInfo = contractInfoService.getById(contractId);
    		if(contractInfo != null){
    			contractInfo.setContractStatus(ContractStatus.TERMINATED);
    			contractInfo.setOperator(session.getUserId());
    			contractInfoService.update(contractInfo);
    		}
    	}
    	
    	//3.释放物业资源
    	ContractResource contractResource = new ContractResource();
    	contractResource.setContractId(epcc.getContractId());
    	List<ContractResource> contractResources = contractResourceService.findByObj(contractResource);
    	if(CollectionUtils.isNotEmpty(contractResources)){
    		for(ContractResource item:contractResources){
    			item.setStatus(Status.DELETED);
    			item.setUseStatus(UseStatus.NOUSE);
    			item.setOperator(session.getUserId());
    			contractResourceService.update(item);
    			
    			//以往版本资源状态更新
//    			Long resourceInfoId = item.getResourceId();
//    			ResourceInfo resourceInfo = new ResourceInfo();
//    			resourceInfo.setId(resourceInfoId);
//    			resourceInfo.setUseStatus(UseStatus.NOUSE);
//    			resourceInfo.setOperator(session.getUserId());
//    			
//    			resourceInfoService.update(resourceInfo);
    		}
    	}
    	
    	//4.更新关联关系
    	epcc.setOperator(session.getUserId());
    	epcc.setContractStatus(CorrContractStatus.TERMINATED.code());
    	epcc.setTerminate(new Date());
    	epcc.setTerminateUser(session.getUserId());
        enterpriseCorrContractService.update(epcc);
        
    	//5.查询是否 拥有正在进行中的合同
    	EnterpriseCorrContract ecc = new EnterpriseCorrContract();
    	ecc.setEnterpriseCottId(epcc.getEnterpriseCottId());
        ecc.setContractStatus(CorrContractStatus.ONGOING.code());
    	List<EnterpriseCorrContract> eccs=enterpriseCorrContractService.findByObj(ecc);
    	if(CollectionUtils.isEmpty(eccs)){
    	    //更改企业园区关联关系
        	EnterpriseCott ec=new EnterpriseCott();
        	ec.setId(epcc.getEnterpriseCottId());
        	//历史入驻
        	ec.setCorrStatus(CorrStatus.HISTORICAL_SETTLED);
        	enterpriseCottService.update(ec);
    		
    	}
        
        return ResultSupport.ok();
    }

}
