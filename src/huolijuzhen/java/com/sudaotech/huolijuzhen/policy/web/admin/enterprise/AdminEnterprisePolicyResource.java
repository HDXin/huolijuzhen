package com.sudaotech.huolijuzhen.policy.web.admin.enterprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.policy.service.PolicyService;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.AdminEnterpriseQuery;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.Policy;
import com.sudaotech.huolijuzhen.policy.service.PolicyService.Query;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/admin/enterprise/policy")
public class AdminEnterprisePolicyResource extends BusinessBaseResource {

    @Inject
    private PolicyService policyService;
    
    @Inject
    private ParkInfoService parkInfoService;
    

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
    	        
    	        Policy temp = new Policy();
    	        temp.setId(obj.getId());
    	        temp.setOperator(-1L);
    	        temp.setReadNum(obj.getReadNum() + 1);
    	        policyService.update(temp);
    		}
    		
    		return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
   	}
    
    /**
     * 按 ID 查詢
     * @param id
     * @return
     */
    @GET
    @Path("/count/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> count(@NotNull @PathParam("id") final Long id) {
    	try{
    		Policy obj = policyService.getById(id);
    		if(obj != null){
    	        
    	        Policy temp = new Policy();
    	        temp.setId(obj.getId());
    	        temp.setOperator(-1L);
    	        temp.setReadNum(obj.getReadNum() + 1);
    	        policyService.update(temp);
    		}
    		
    		return new Result<String>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK);
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
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
    		@QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages,
            @QueryParam("parkId") Long parkId) {
    	
    	Page<Policy> page = null;
    	try{
    		AdminEnterpriseQuery query = new AdminEnterpriseQuery();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pages);

    		//1.获取
			ParkInfo parkInfo = null;
			if(parkId != null && parkId != -1){
				parkInfo = parkInfoService.getById(parkId);
			}

			if(parkInfo != null){
				query.setProId(parkInfo.getProvinceId());
				query.setCityId(parkInfo.getCityId());
				query.setCounId(parkInfo.getRegionId());
				query.setLocationId(parkInfo.getPositionId());
				
				page = policyService.findAllByParkId(query);
			}else{
				page = policyService.findAllPlatform(query);
			}
    		
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
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Policy item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	infoMap.put("id", item.getId());
    	infoMap.put("title", notNull(item.getTitle()));
    	infoMap.put("polUri", notNull(item.getPolUri()));
    	infoMap.put("createTime", notNull(item.getCreateTime()));
    	infoMap.put("approvalTime", notNull(item.getApprovalTime()));
    	
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
    	infoMap.put("createBy", notNull(item.getCreateBy()));
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
