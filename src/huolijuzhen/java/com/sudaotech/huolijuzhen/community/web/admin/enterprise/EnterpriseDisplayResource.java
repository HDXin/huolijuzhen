package com.sudaotech.huolijuzhen.community.web.admin.enterprise;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/admin/enterprise/enterpriseDisplay")
public class EnterpriseDisplayResource extends BaseResource {
    @Inject
    private EnterpriseDisplayService enterpriseDisplayService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private AdminUserService adminUserService;
    
    /**
     * 新增企业风采信息
     * */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EnterpriseDisplay obj) {
    	Result<Map<String, Long>> result = null;
    	// 获取企业id
    	Long enterpriseId = getSession().getPlatformId();
    	// 获取企业用户id
        obj.setOperator(getSession().getUserId());
        //查询该企业的创建来源平台 1-该企业由平台创建 2-该企业由园区创建 0-未知来源
        EnterpriseInfo enterpriseInfo = null; 
        if(enterpriseId != null){
        	obj.setEnterpriseId(enterpriseId);
        	enterpriseInfo = enterpriseInfoService.getById(enterpriseId);
        	if(enterpriseInfo==null){
        		result = new Result<Map<String, Long>>(ResultCode.ENTERPRISE_DISPLAY_NOT_FOUND_ENTERPRISEINFO);
            	return result;
        	}
        }else{
        	result = new Result<Map<String, Long>>(ResultCode.ENTERPRISE_DISPLAY_ENTERPRISEID_IS_NULL);
        	return result;
        }
        //获取创建来源平台
        CreateSource createSource = enterpriseInfo.getCreateSource();
        //平台-1， 园区-2
        if(createSource!=null){
        	if(CreateSource.PLATFORM.equals(createSource)){
            	obj.setPublishLevel(1);
            }else if(CreateSource.PARK.equals(createSource)){
            	obj.setPublishLevel(2);
            }else{
            	//未知来源
            	obj.setPublishLevel(0);
            }
        }else{
        	//未知来源
        	obj.setPublishLevel(0);
        }
        //默认待审核状态
        obj.setApprovalStatus(ApprovalStatus.WAITAPPROVAL);
        Long id = enterpriseDisplayService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/admin/enterprise/enterpriseDisplay/%s", id));
        result.setData(map);
        return result;
    }
    
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
            if(ApprovalStatus.ALREADYPASS.equals(approvalStatus) || approvalStatus.NOPASS.equals(approvalStatus)){
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
    @Path("/list/{parkId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @NotNull @PathParam("parkId") final Long parkId,
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
		
		Map<String, Object> map = enterpriseDisplayService.findWithinParkId(query, parkId, ReqSourceType.ADMIN_ENTERPRISE, extendsEntity);
        return new Result<Map<String, Object>>(ResultCode.OK, map);
    }
    
    /**
     * 查询当前企业用户在当前园区下的所有风采记录
     * */
    @GET
    @Path("/byparkid/{parkId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findGroupByParkId(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("startTime") String startTime,
            @QueryParam("endTime") String endTime,
            @QueryParam("publishLevel") Integer publishLevel,
            @QueryParam("approvalStatus") Integer approvalStatus,
            @NotNull @PathParam("parkId") final Long parkId
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		EnterpriseDisplayExtends extendsEntity = new EnterpriseDisplayExtends();
		extendsEntity.setStartTime(startTime);
		extendsEntity.setEndTime(endTime);
		extendsEntity.setPublishLevel(publishLevel);
		extendsEntity.setApprovalStatus(approvalStatus);
		extendsEntity.setEnterpriseId(getSession().getPlatformId());
		
		Map<String, Object> map = enterpriseDisplayService.findByParkIdAndEnterpriseId(query, parkId, extendsEntity);
        return new Result<Map<String, Object>>(ResultCode.OK, map);
    }
    
    /**
     * 业端首页企业风采列表
     *（平台+当前园区的已审批的企业风采： 
     * CASE 1：当前企业未关联园区，那么只取平台已审批通过的； 
     *  CASE 2 ：当前园区关联园区，那么取平台+当前园区的已审批通过的）
     * */
    @GET
    @Path("/homepage")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findForHomepage(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("startTime") String startTime,
            @QueryParam("endTime") String endTime,
            @QueryParam("enterpriseName") String enterpriseName
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		EnterpriseDisplayExtends extendsEntity = new EnterpriseDisplayExtends();
		extendsEntity.setStartTime(startTime);
		extendsEntity.setEndTime(endTime);
		extendsEntity.setEnterpriseId(getSession().getPlatformId());
		
		Map<String, Object> map = enterpriseDisplayService.findForHomepage(query, extendsEntity);
        return new Result<Map<String, Object>>(ResultCode.OK, map);
    }
    
}