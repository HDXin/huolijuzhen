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
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService.ContractBill;
import com.sudaotech.huolijuzhen.enterprise.service.ContractBillService.Query;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/contractBill")
public class ContractBillResource extends BaseResource {

    @Inject
    private ContractBillService contractBillService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ContractBill obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = contractBillService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/contractBill/%s", id));
        result.setData(map);
        return result;
    }
    
    @POST
    @Path("/createBatch")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> createBatch(@Valid final List<ContractBill> contractBills) {
    	
    	//1.根据合同 ID 获取该合同的所有月份账单记录
    	ContractBill contractBill = new ContractBill();
    	contractBill.setContractId(123L);
    	List<ContractBill> contractBillList = contractBillService.findAllPast(contractBill);
    	
    	//2.删除所有以往记录
		if(CollectionUtils.isNotEmpty(contractBillList)){
			for(ContractBill item:contractBillList){
				item.setStatus(Status.DELETED);
				
				item.setOperator(getSessionQuietly().getUserId());
				contractBillService.update(item);
			}
		}
    	
    	//3.插入当前记录
    	if(CollectionUtils.isNotEmpty(contractBills)){
    		for(ContractBill item:contractBills){
    	        item.setOperator(getSession().getUserId());
    	        contractBillService.create(item);
    		}
    	}
    	
        return new Result<String>(ResultCode.OK);
    }


    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ContractBill obj) {
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        contractBillService.update(obj);
        return ResultSupport.ok();
    }
    
    @PUT
    @Path("/updateBatch")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateBatch(@Valid final List<ContractBill> contractBills) {
    	if(CollectionUtils.isNotEmpty(contractBills)){
    		for(ContractBill item:contractBills){
    			item.setOperator(getSessionQuietly().getUserId());
    			contractBillService.update(item);
    		}
    	}
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ContractBill obj = new ContractBill();
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
    public Result<ContractBill> get(@NotNull @PathParam("id") final Long id) {
        ContractBill obj = contractBillService.getById(id);
        
        return new Result<ContractBill>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ContractBill>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<ContractBill> page = contractBillService.find(query);
        return new Result<Page<ContractBill>>(ResultCode.OK, page);
    }
}
