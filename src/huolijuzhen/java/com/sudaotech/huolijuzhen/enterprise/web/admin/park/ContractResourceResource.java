package com.sudaotech.huolijuzhen.enterprise.web.admin.park;

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
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService.ContractResource;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService.ParkQuery;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/contractResource")
public class ContractResourceResource extends BaseResource {

    @Inject
    private ContractResourceService contractResourceService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ContractResource obj) {
    	
    	try{
            // create
            obj.setOperator(getSessionQuietly().getUserId());
            Long id = contractResourceService.create(obj);
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/contractResource/%s", id));
            result.setData(map);

            return result;
    	}catch(Exception e){
    		logger.error("园区关联合同资源 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ContractResource obj) {
    	try {
            obj.setId(id);
            obj.setOperator(getSessionQuietly().getUserId());
            contractResourceService.update(obj);
            return ResultSupport.ok();
		} catch (Exception e) {
			logger.error("园区编辑合同资源关联 error:{}",e);
			return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	
    	try{
            ContractResource obj = new ContractResource();
            obj.setStatus(Status.DELETED);
            return update(id, obj);
    	}catch(Exception e){
    		logger.error("园区删除合同资源关联信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
    	try{
        	if (!CollectionUtils.isEmpty(ids)) {
    			for (Long id : ids) {
    				delete(id);
    			}
        	}
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("园区批量删除合同资源关联 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<ContractResource> get(@NotNull @PathParam("id") final Long id) {
    	try{
        	ContractResource obj = contractResourceService.getById(id);
            
            return new Result<ContractResource>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    	}catch(Exception e){
    		logger.error("园区获取合同资源详情 error:{}",e);
    		return new Result<ContractResourceService.ContractResource>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ContractResource>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("contractId") Long contractId,
            @QueryParam("resourceId") Long resourceId) {
    	
    	try{
        	ParkQuery query = new ParkQuery();
    		
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pageNum);
    		query.setConstractId(contractId);
    		query.setResourceId(resourceId);
    		
    		Page<ContractResource> page = contractResourceService.parkFind(query);
    		
            return new Result<Page<ContractResource>>(ResultCode.OK, page);
    		
    	}catch(Exception e){
    		logger.error("园区关联合同资源 error：{}",e);
    		return new Result<Page<ContractResource>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
}
