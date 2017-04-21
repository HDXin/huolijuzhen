package com.sudaotech.huolijuzhen.policy.web.admin.platform;

import java.util.ArrayList;
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
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.policy.service.PolicyService;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.Policy;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.Query;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/policy")
public class AdminPlatformPolicyResource extends BusinessBaseResource {

    @Inject
    private PolicyService policyService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String,Long>> create(@Valid final Policy obj) {
    	try{
    		//1.获取表单信息
    		Policy temp = extractValidInfo(obj);
    		
	        //2.维护其它信息
	        temp.setOperator(getSessionQuietly().getUserId());
	        temp.setCreateSide(CreateSide.PLATFORM);
	        Long id = policyService.create(temp);
	        Map<String,Long> map = MapHelper.put("id", id).getMap();
	
	        Result<Map<String,Long>> result = new Result<Map<String,Long>>(ResultCode.OK);
	        result.setLocation(String.format("/policy/%s", id));
	        result.setData(map);
        return result;
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑政策（更新指定字段）
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
            @Valid final Policy obj) {
    	try{
    		Policy temp = extractValidInfo(obj);
    		temp.setId(id);
	        temp.setOperator(getSessionQuietly().getUserId());
	        policyService.update(temp);
	        return ResultSupport.ok();
    	}catch(Exception e){
    		e.printStackTrace();
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
            Policy obj = new Policy();
            
            obj.setId(id);
            obj.setStatus(Status.DELETED);
            policyService.update(obj);
            
            return ResultSupport.ok();
    	}catch(Exception e){
			logger.error("平台删除政策 error:",e);
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
        	if (CollectionUtils.isNotEmpty(ids)) {
        		Policy temp = null;
    			for (Long id : ids) {
    				temp = new Policy();
    				
    				temp.setId(id);
    				temp.setOperator(getSessionQuietly().getUserId());
    				temp.setStatus(Status.DELETED);
    				
    				policyService.update(temp);
    			}
        	}
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("批量刪除政策 error:",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按 ID 查詢
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
    		Policy obj = policyService.getById(id);
    		Map<String, Object> dataMap = new HashedMap<String, Object>();
    		if(obj != null){
    	        dataMap = packItemInfo(obj);    			
    		}
    		
    		return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
   	}
    
    /**
     * 审批政策（只更新有关审批的三个字段信息）
     * @param id
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            @Valid final Policy temp) {
    	try{
	    	Policy obj = new Policy();
	        obj.setId(id);
	        obj.setOperator(getSessionQuietly().getUserId());
	        
	        if(temp.getApprovalStatus() == ApprovalStatus.ALREADYPASS || temp.getApprovalStatus() == ApprovalStatus.NOPASS){
	        	obj.setApprovalStatus(temp.getApprovalStatus());
	        	obj.setApprovalBy(getSessionQuietly().getUserId());
		        obj.setApprovalTime(new Date());
		        obj.setApprovalText(temp.getApprovalText());
	        }else{
	        	return new Result<String>(ResultCode.APPROVAL_CODE_INVALID);
	        }
	        policyService.update(obj);
	        return ResultSupport.ok();
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 按条件查询
     * @param query
     * @return
     */
    @GET
    @Path("/find")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
    		@QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("title") String title) {
    	
    	Page<Policy> page = null;
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pages);
    		query.setStartDate(startDate);
    		query.setEndDate(endDate);
    		query.setTitle(title);
    		
    		//1.
    		page = policyService.findByCondition(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Policy> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Policy pc:list){
        			item = packListInfo(pc);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		//日期字符串转换日期格式异常
    		return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    	}
    }
    
    /**
     * 按条件查询
     * @param query
     * @return
     */
    @POST
    @Path("/findByCondition")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> findByCondition(
            @Valid final Query query) {
    	
    	Page<Policy> page = null;
    	try{
    		//1.
    		page = policyService.findByCondition(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Policy> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Policy pc:list){
        			item = packListInfo(pc);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		//日期字符串转换日期格式异常
    		return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Policy extractValidInfo(Policy temp){
    	Policy obj = new Policy();

    	obj.setTitle(temp.getTitle());
    	obj.setPolUri(temp.getPolUri());
    	obj.setPublicGrade(temp.getPublicGrade());
    	obj.setProId(temp.getProId());
    	obj.setCityId(temp.getCityId());
    	obj.setCounId(temp.getCounId());
    	obj.setLocationId(temp.getLocationId());

    	if(temp.getApprovalStatus().equals(ApprovalStatus.WAITSUBMIT) || temp.getApprovalStatus().equals(ApprovalStatus.WAITAPPROVAL)){
    		obj.setApprovalStatus(temp.getApprovalStatus());
    	}else{
    		obj.setApprovalStatus(ApprovalStatus.WAITSUBMIT);
    	}
    	 
    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Policy item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Policy item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("title", notNull(item.getTitle()));
    	infoMap.put("polUri", notNull(item.getPolUri()));
    	
    	infoMap.put("approvalStatus", notNull(item.getApprovalStatus()));
    	
    	Long createBy = item.getCreateBy();
    	infoMap.put("createBy", "");
    	if(createBy != null){
    		AdminUser adminUser = adminUserService.getById(createBy);
    		if(adminUser != null){
    	    	infoMap.put("createBy", adminUser.getName());
    		}
    	}
    	infoMap.put("createTime", item.getCreateTime());
    	CreateSide createSide = item.getCreateSide();
    	infoMap.put("createSide", notNull(createSide));
		if(CreateSide.PARK.equals(createSide)){
			infoMap.put("parkId", notNull(item.getCreateSideId()));
		}

		PublicGrade publicGrade = item.getPublicGrade();
    	infoMap.put("publicGrade", notNull(publicGrade));
		if(PublicGrade.ADMINISTRACTIVE.equals(publicGrade)){
			infoMap.put("proId", notNull(item.getProId()));
			infoMap.put("cityId", notNull(item.getCityId()));
			infoMap.put("counId", notNull(item.getCounId()));
			infoMap.put("loactionId", notNull(item.getLocationId()));
		}
		
    	return infoMap;
    }
}
