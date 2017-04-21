package com.sudaotech.huolijuzhen.bill.web.admin.park;

import java.math.BigDecimal;
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
import com.sudaotech.huolijuzhen.bill.service.BillCollectionRecordService;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.BillCostDetail;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.Query;
import com.sudaotech.huolijuzhen.task.service.TaskService;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/billCostDetail")
public class BillCostDetailResource extends BaseResource {

    @Inject
    private BillCostDetailService billCostDetailService;
    
    @Inject
    private BillCollectionRecordService billCollectionRecordService;
    
    @Inject
    private TaskService taskService;
    
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final BillCostDetail obj) {
        // create
        obj.setOperator(getSessionQuietly().getUserId());
        Long id = billCostDetailService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/billCostDetail/%s", id));
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
            @Valid final BillCostDetail obj) {
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        billCostDetailService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	if(id == null){
    		return new Result<String>(ResultCode.ITEM_ID_IS_NULL);
    	}
    	BillCostDetail billCostDetail = billCostDetailService.getById(id);
    	if(billCostDetail == null){
    		return new Result<String>(ResultCode.NOT_FOUND_ITEM);
    	}
        
    	//删除对应的维修费用关联
    	if(billCostDetail.getIsTask() == 1){
    		Task task = new Task();
    		task.setBillId(billCostDetail.getBillId());
    		List<Task> tasks = taskService.findByObj(task);
    		if(CollectionUtils.isNotEmpty(tasks)){
    			for(Task item:tasks){
    				item.setIsChoose(0);
    				item.setBillId(0L);
    				item.setOperator(getSessionQuietly().getUserId());
    				
    				taskService.update(item);
    			}
    		}
    	}

    	BillCostDetail obj = new BillCostDetail();
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
    public Result<BillCostDetail> get(@NotNull @PathParam("id") final Long id) {
        BillCostDetail obj = billCostDetailService.getById(id);
        
        return new Result<BillCostDetail>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<BillCostDetail>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<BillCostDetail> page = billCostDetailService.find(query);
        return new Result<Page<BillCostDetail>>(ResultCode.OK, page);
    }
    
    /**
     * @描述：费用项目费用核销
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @PUT
    @Path("/verify/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> verify(
            @NotNull @PathParam("id") final Long id) {
    	
    	Session session=getSessionQuietly();
    	
    	if(session.getUserId() == null || session.getUserId() == 0){
       		return new Result<String>(ResultCode.SESSION_IS_NULL);
       	}
    	
    	//查询费用明细
    	BillCostDetail bcd=billCostDetailService.getById(id);
    	if(bcd == null){
    		return new Result<String>(ResultCode.NOT_FOUND);
    	}
    	//验证当前核销金额是否已经 全部核销
    	if(bcd.getTotalMoney().compareTo(bcd.getVerifyMoney()==null?new BigDecimal("0"):bcd.getVerifyMoney()) == 0 ||
    			bcd.getTotalMoney().compareTo(bcd.getVerifyMoney()==null?new BigDecimal("0"):bcd.getVerifyMoney())== -1){
    		return new Result<String>(ResultCode.COST_DETAIL_IS_WRITTEN);
    	}
    	
    	//收款总额
    	BigDecimal totalCollection = billCollectionRecordService.getTotalCollectioin(bcd.getBillId());
    	
    	//已核销总额
    	BigDecimal totalApportioin = billCostDetailService.getTotalApportion(bcd.getBillId());
    	
    	totalApportioin=(totalApportioin==null?new BigDecimal("0"):totalApportioin);
    	
    	if(totalApportioin.compareTo(totalCollection) ==0 ||
    			  totalApportioin.compareTo(totalCollection)==1){
    		return new Result<String>(ResultCode.COLLECTION_AMOUNT_IS_INSUFFICIENT);
    	}
    	//待核销金额
    	BigDecimal totalWritten =new BigDecimal(Arith.sub(totalCollection, totalApportioin));
    	
    	BillCostDetail obj  =new BillCostDetail();
    	
    	//待核销总额+已核销的总额 大于等于 当前费用总额，则全部核销
    	if(totalWritten.compareTo(bcd.getTotalMoney()) == 1 ||
           totalWritten.compareTo(bcd.getTotalMoney()) == 0 ){
    	   obj.setVerifyMoney(bcd.getTotalMoney());
    	}else{
    		obj.setVerifyMoney(new BigDecimal(Arith.add(bcd.getVerifyMoney()==null?new BigDecimal("0"):bcd.getVerifyMoney(),totalWritten)));
    	}
        obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        billCostDetailService.update(obj);
        
        return ResultSupport.ok();
        
    }
    
    
}
