package com.sudaotech.huolijuzhen.approval.web.admin.park;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService.ApprovalProcess;
import com.sudaotech.huolijuzhen.approval.service.ApprovalProcessService.ApprovalProcessQuery;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItem;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.Query;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/approvalType")
public class AdminParkApprovalTypeResource extends BaseResource {

    @Inject
    private ApprovalTypeService approvalTypeService;
    
    @Inject
    private ApprovalTypeItemService approvalTypeItemService;
    
    @Inject
    private ApprovalProcessService approvalProcessService;
    
    @Inject
    private ContractInfoService contractInfoService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ApprovalType obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = approvalTypeService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/approvalType/%s", id));
        result.setData(map);
        return result;
    }

    /**
     * 目前流程类型的编辑都定位流程版本的升级，即
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ApprovalType obj) {
    	
    	
    	//1.判断是否存在
    	ApprovalType approvalType = approvalTypeService.getById(id);
    	if(approvalType == null){
    		return new Result<String>(ResultCode.ITEM_ID_IS_INVALID);
    	}
    	
    	//2.获取当前流程被哪些合同使用
    	ApprovalProcessQuery approvalProcessQuery = new ApprovalProcessQuery();
    	approvalProcessQuery.setApprovalTypeId(id);
    	approvalProcessQuery.setApprovalTypeVersion(approvalType.getLatestVersion());
    	List<ApprovalProcess> approvalProcessList = approvalProcessService.findByObjQuery(approvalProcessQuery);
    	Set<Long> contractIds = null;
    	if(CollectionUtils.isNotEmpty(approvalProcessList)){
    		contractIds = new HashSet<Long>();
    		for(ApprovalProcess item:approvalProcessList){
    			contractIds.add(item.getMainId());
    		}
    	}
    	
    	//2.1 更新该版本的审批流程为历史数据
    	int rowNum = approvalProcessService.updateByApprovalTypeIdAndVersion(id,approvalType.getLatestVersion());
    	
    	//3.维护流程节点的上一个版本的节点数据（更改为历史节点）
    	rowNum = approvalTypeItemService.updateByApprovalTypeIdandVersion(obj.getId(),approvalType.getLatestVersion());
    	
    	//4.维护流程类型信息
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        //版本升级
        if(rowNum > 0){
            obj.setLatestVersion(approvalType.getLatestVersion()+1);
        }else{
        	obj.setLatestVersion(approvalType.getLatestVersion());
        }
        approvalTypeService.update(obj);
        
		//4.新增审批流程节点
		List<ApprovalTypeItem> approvalTypeItems = obj.getApprovalTypeItems();
		if(CollectionUtils.isEmpty(approvalTypeItems)){
			return ResultSupport.ok();
		}
		
		for(ApprovalTypeItem item:approvalTypeItems){
			item.setApprovalTypeId(id);
			item.setCurrentVersion(obj.getLatestVersion());
			item.setOperator(getSession().getUserId());
			if(item.getApprovalNo() == null){
				item.setApprovalNo(ApprovalTypeItem.STATIC_APPROVAL_NO);
			}
		
			item.setId(approvalTypeItemService.create(item));
		}

		
		//5.更业务绑定，重写合同、账单的审批流程
		if(CollectionUtils.isEmpty(contractIds)){
			//维护审批流程信息
			return ResultSupport.ok();
		}
		
		//维护审批流程表
		//1.获取流程第一个节点
		Long firstNodeId = getFirstItem(approvalTypeItems);
		ApprovalProcess approvalProcess = null;
		Long approvalProcessId = null;
		for(Long contractId:contractIds){
			for(ApprovalTypeItem item:approvalTypeItems){
				approvalProcess = new ApprovalProcess();

				approvalProcess.setApprovalTypeId(id);
				approvalProcess.setApprovalTypeVersion(obj.getLatestVersion());
				
				approvalProcess.setApprovalItemId(item.getId());
				approvalProcess.setApprovalItemNo(item.getApprovalNo());
				approvalProcess.setApprovalItemVersion(obj.getLatestVersion());

				approvalProcess.setApprovalType(com.sudaotech.huolijuzhen.enums.ApprovalType.CONTRACTAPPROVAL);
				approvalProcess.setMainId(contractId);

				approvalProcess.setApprovalId(item.getApprovalId());

				approvalProcess.setApprovalProcessStatus(ApprovalProcessStatus.WAITAPPROVAL);
				if(item.getId() == firstNodeId){
					approvalProcess.setApprovalProcessStatus(ApprovalProcessStatus.WAITAPPROVAL);
				}
				
				approvalProcess.setOperator(getSession().getUserId());
				approvalProcessId = approvalProcessService.create(approvalProcess);

				//更新合同、账单信息（下一待审批人，审批流程当前节点 ID）
				if(item.getId() != firstNodeId)
					continue;
				
				//合同审批流程
				if(com.sudaotech.huolijuzhen.enums.ApprovalType.CONTRACTAPPROVAL == approvalType.getApprovalType()){
					ContractInfo contractInfo = new ContractInfo();
					contractInfo.setId(contractId);
					contractInfo.setExecutorId(item.getApprovalId());
					contractInfo.setApprovalProcessId(approvalProcessId);
					
					contractInfo.setOperator(getSession().getUserId());

					contractInfoService.update(contractInfo);
				}else if(com.sudaotech.huolijuzhen.enums.ApprovalType.BILLAPPROVAL == approvalType.getApprovalType()){
					//账单审批流程
					
				}else if(com.sudaotech.huolijuzhen.enums.ApprovalType.BILLVERIFY == approvalType.getApprovalType()){
					//账单核销流程
					
				}
			
			}
		}
		
		return ResultSupport.ok();
    }
    
    /**
     * 目前流程类型的编辑都定位流程版本的升级，即
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/{enableStatus}/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> enable(
            @NotNull @PathParam("id") final Long id,
            @PathParam("enableStatus") String enableStatus,
            @Valid final ApprovalType obj) {
 
    	obj.setId(id);
    	obj.setEnableStatus(EnableStatus.valueOf(enableStatus.toUpperCase()));
    	obj.setOperator(getSession().getUserId());

    	approvalTypeService.update(obj);
    	return ResultSupport.ok();
    	
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ApprovalType obj = new ApprovalType();
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
    public Result<ApprovalType> get(@NotNull @PathParam("id") final Long id) {
        ApprovalType obj = approvalTypeService.getById(id);
        
        return new Result<ApprovalType>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ApprovalType>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		query.setParkId(getSession().getPlatformId());
		
		Page<ApprovalType> page = approvalTypeService.find(query);
        return new Result<Page<ApprovalType>>(ResultCode.OK, page);
    }
    
    /**
     * 获取流程里第一个节点
     * @param approvalProcessList
     * @return
     */
    private Long getFirstItem(List<ApprovalTypeItem> approvalTypeItemList){
    	
    	if(CollectionUtils.isEmpty(approvalTypeItemList)){
    		return null;
    	}
    	
    	Map<String, ApprovalTypeItem> itemMap = new HashedMap<String, ApprovalTypeItem>();
    	for(ApprovalTypeItem item:approvalTypeItemList){
    		
    		itemMap.put(item.getApprovalNo() + item.getId().toString(), item);
    	}
    	
    	Set<String> keySet = itemMap.keySet();
    	Iterator<String> keys = keySet.iterator();

    	return itemMap.get(keys.next()).getId();
    }
    
    
    @Test
    public void testGet(){
    	
    	List<ApprovalTypeItem> list = new ArrayList<ApprovalTypeItem>();
    	
    	ApprovalTypeItem item = new ApprovalTypeItem();
    	item.setId(12L);
    	item.setApprovalNo(40);
    	list.add(item);
    	
    	item = new ApprovalTypeItem();
    	item.setId(13L);
    	item.setApprovalNo(30);
    	list.add(item);
    	
    	item = new ApprovalTypeItem();
    	item.setId(14L);
    	item.setApprovalNo(20);
    	list.add(item);
    	
    	item = new ApprovalTypeItem();
    	item.setId(15L);
    	item.setApprovalNo(20);
    	list.add(item);
    	
    	item = new ApprovalTypeItem();
    	item.setId(16L);
    	item.setApprovalNo(10);
    	list.add(item);
    	
    	System.out.println("------------->>>" + getFirstItem(list));
    	
    }
}
