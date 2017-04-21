package com.sudaotech.huolijuzhen.community.web.admin.park;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService.EnterpriseDisplay;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService.EnterpriseDisplayExtends;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService.Query;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;

@Path("/admin/park/enterpriseDisplay")
public class EnterpriseDisplayResource extends BaseResource {

    @Inject
    private EnterpriseDisplayService enterpriseDisplayService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private AdminUserService adminUserService;

    @SuppressWarnings("static-access")
	@PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final EnterpriseDisplay obj) {
    	if(id == null){
    		return new Result<String>(ResultCode.ENTERPRISE_DISPLAY_ID_IS_NULL);
    	}
    	EnterpriseDisplay enterpriseDisplay = enterpriseDisplayService.getById(id);
    	enterpriseDisplay.setId(id);
    	enterpriseDisplay.setOperator(getSession().getUserId());
        ApprovalStatus approvalStatus = obj.getApprovalStatus();
        if(approvalStatus!=null){
            if(ApprovalStatus.ALREADYPASS.equals(approvalStatus) || approvalStatus.NOPASS.equals(approvalStatus) 
            		|| approvalStatus.TERMINATION.equals(approvalStatus)){
            	enterpriseDisplay.setApprovalStatus(approvalStatus);
            }else{
            	return new Result<String>(ResultCode.ENTERPRISE_DISPLAY_BAD_SERVICE);
            }
        }else{
        	return new Result<String>(ResultCode.ENTERPRISE_DISPLAY_APPROVALSTATUS_IS_NULL);
        }
        enterpriseDisplayService.update(enterpriseDisplay);
        
        return ResultSupport.ok();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
        EnterpriseDisplay obj = enterpriseDisplayService.getById(id);
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(obj.getEnterpriseId());
        AdminUser adminUser = adminUserService.getById(obj.getCreateBy());
        if(enterpriseInfo==null){
        	return new Result<Map<String, Object>>(ResultCode.ENTERPRISE_DISPLAY_NOT_FOUND_ENTERPRISEINFO, null);
        }else if(adminUser==null){
        	return new Result<Map<String, Object>>(ResultCode.ENTERPRISE_DISPLAY_ADMIN_USER_IS_NOT_FOUND, null);
        }else{
        	resultMap.put("enterpriseName", enterpriseInfo.getName());
        	resultMap.put("userName", adminUser.getUsername());
        	resultMap.put("enterpriseDisplay", obj);
        }
        return new Result<Map<String, Object>>(ResultCode.OK, resultMap);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("startTime") String startTime,
            @QueryParam("endTime") String endTime,
            @QueryParam("enterpriseName") String enterpriseName,
            @QueryParam("publishLevel") Integer publishLevel,
            @QueryParam("approvalStatus") Integer approvalStatus
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		EnterpriseDisplayExtends extendsEntity = new EnterpriseDisplayExtends();
		extendsEntity.setStartTime(startTime);
		extendsEntity.setEndTime(endTime);
		extendsEntity.setEnterpriseName(enterpriseName);
		extendsEntity.setPublishLevel(publishLevel);
		extendsEntity.setApprovalStatus(approvalStatus);
		
		Long parkId = getSession().getPlatformId();
		Map<String, Object> map = enterpriseDisplayService.findWithinParkId(query, parkId, ReqSourceType.ADMIN_PARK, extendsEntity);
        return new Result<Map<String, Object>>(ResultCode.OK, map);
    }
    
}
