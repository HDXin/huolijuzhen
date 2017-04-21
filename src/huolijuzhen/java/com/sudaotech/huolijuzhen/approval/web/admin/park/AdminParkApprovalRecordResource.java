package com.sudaotech.huolijuzhen.approval.web.admin.park;

import java.util.ArrayList;
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
import org.apache.commons.lang3.StringUtils;
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
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordService.ApprovalRecord;
import com.sudaotech.huolijuzhen.approval.service.ApprovalRecordService.Query;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItem;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/approvalRecord")
public class AdminParkApprovalRecordResource extends BaseResource {

    @Inject
    private ApprovalRecordService approvalRecordService;
    
    @Inject
    private ApprovalTypeService approvalTypeService;
    
    @Inject
    private ApprovalTypeItemService approvalTypeItemService;
    
    @Inject
    private ApprovalProcessService approvalProcessService;
    
    @Inject
    private AdminUserService adminUserService;

    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ApprovalRecord obj) {
        // create
        obj.setOperator(getSession().getUserId());
        Long id = approvalRecordService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/approvalRecord/%s", id));
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
            @Valid final ApprovalRecord obj) {
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        approvalRecordService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ApprovalRecord obj = new ApprovalRecord();
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
    public Result<ApprovalRecord> get(@NotNull @PathParam("id") final Long id) {
        ApprovalRecord obj = approvalRecordService.getById(id);
        
        return new Result<ApprovalRecord>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<ApprovalRecord>> find(
            @NotNull @QueryParam("approvalType") ApprovalType approvalType, 
            @NotNull @QueryParam("targetId") Long targetId
            ) {
		Query query = new Query();
		query.setOffset(0);
		query.setLimit(100);
		query.setPage(1);
		query.setApprovalType(approvalType);
		query.setTargetId(targetId);
		
		Page<ApprovalRecord> page = approvalRecordService.find(query);
		
       	//1.1  获取当前有效的合同审批流程
    	com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType approvalTypeInfo = 
    			approvalTypeService.findValidItem(getSession().getPlatformId(),approvalType);
    	
    	ApprovalProcessQuery approvalProcessQuery= new ApprovalProcessQuery();
    	approvalProcessQuery.setApprovalTypeId(approvalTypeInfo.getId());
    	approvalProcessQuery.setApprovalItemVersion(approvalTypeInfo.getLatestVersion());
    	approvalProcessQuery.setApprovalProcessStatus(ApprovalProcessStatus.APPROVALED);
    	List<ApprovalProcess> approvalProcesseList = approvalProcessService.findByObjQuery(approvalProcessQuery);

    	if(CollectionUtils.isEmpty(approvalProcesseList)){
    		return new Result<List<ApprovalRecord>>(ResultCode.OK, page.getItems());
    	}

    	List<ApprovalRecord> items = page.getItems();
    	if(CollectionUtils.isEmpty(items)){
    		items = new ArrayList<ApprovalRecordService.ApprovalRecord>();
    	}
    	
    	ApprovalRecord approvalRecord = null;
   		ApprovalTypeItem approvalTypeItem = null;
   		for(ApprovalProcess item:approvalProcesseList){
    		approvalRecord = BeanUtils.copyProperties(item, ApprovalRecord.class);
    		approvalTypeItem = approvalTypeItemService.getById(item.getApprovalItemId());
    		approvalRecord.setApprovalItemName(approvalTypeItem == null ? "":StringUtils.isBlank(approvalTypeItem.getName()) ? "":approvalTypeItem.getName());

    		AdminUser adminUser = adminUserService.getById(item.getApprovalId());
    		approvalRecord.setApprovalName(adminUser == null?"":StringUtils.isBlank(adminUser.getUsername())?"":adminUser.getUsername());
    		approvalRecord.setApprovalProcessStatus(item.getApprovalProcessStatus());

    		items.add(approvalRecord);
    	}
    	
		return new Result<List<ApprovalRecord>>(ResultCode.OK, page.getItems());
    }
}
