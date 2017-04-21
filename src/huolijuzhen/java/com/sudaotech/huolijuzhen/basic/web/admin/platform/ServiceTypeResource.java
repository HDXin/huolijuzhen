package com.sudaotech.huolijuzhen.basic.web.admin.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.Query;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.RecommendParams;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.ServiceType;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/serviceType")
public class ServiceTypeResource extends BusinessBaseResource {

    @Inject
    private ServiceTypeService serviceTypeService;
    
    /**
     * 新增服务类型
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ServiceType obj) {
    	
    	try{
    		//1.获取表单数据
    		ServiceType temp = extractValidInfo(obj);

    		//2.维护其它数据
            temp.setOperator(getSessionQuietly().getUserId());
            temp.setIsReco(false);
            Long id = serviceTypeService.create(temp);
            
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/serviceType/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑服务类型
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
            @Valid final ServiceType obj) {
    	try{
    		ServiceType temp = extractValidInfo(obj);

    		temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            serviceTypeService.update(obj);
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
        ServiceType obj = new ServiceType();
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
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            ServiceType obj = serviceTypeService.getById(id);

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
     * 根据条件获取服务类型列表（支持分页）
     * @param query
     * @return
     */
    @GET
    @Path("/find")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages,
            @QueryParam("name") String name,
            @QueryParam("serverGrade") String serverGrade) {
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pages);
    		query.setName(name);
    		query.setServerGrade(serverGrade);
    		
    		//1.按条件查询服务信息
    		Page<ServiceType> page = serviceTypeService.findByCondition(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<ServiceType> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(ServiceType st:list){
        			item = packListInfo(st);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
    		return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
		
    }
    /**
     * 启用
     * @param id
     * @return
     */
    @PUT
    @Path("/start/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> start(@NotNull @PathParam("id") final Long id) {
    	try{
        	ServiceType obj = new ServiceType();
            obj.setId(id);
            obj.setOperator(getSessionQuietly().getUserId());
            
            obj.setEnableStatus(EnableStatus.ENABLE);
            obj.setEnableBy(getSessionQuietly().getUserId());
            obj.setEnableTime(new Date());
            serviceTypeService.update(obj);
            return ResultSupport.ok();
    	
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 禁用
     * @param id
     * @return
     */
    @PUT
    @Path("/forbidden/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> forbidden(@NotNull @PathParam("id") final Long id) {
    	try{
        	ServiceType obj = new ServiceType();
            obj.setId(id);
            obj.setOperator(getSessionQuietly().getUserId());
            
            obj.setEnableStatus(EnableStatus.DISABLE);
            obj.setDisableBy(getSessionQuietly().getUserId());
            obj.setDisableTime(new Date());
            serviceTypeService.update(obj);
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 推荐
     * @param id
     * @return
     */
    @PUT
    @Path("/recommend")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> recommend(@Valid final RecommendParams recommendParams) {
    	try{
    		
    		//1.将原推荐的服务类型设置为未推荐
    		Long targetId = recommendParams.getTargetId();
    		if(targetId != null){
    			ServiceType obj = new ServiceType();
    			
    			obj.setId(targetId);
    			obj.setIsReco(false);
    			obj.setOperator(getSessionQuietly().getUserId());
    			obj.setUnRecoBy(getSessionQuietly().getUserId());
    			obj.setUnRecoTime(new Date());
    			
    			serviceTypeService.update(obj);
    		}
    		
    		//2.讲选中的服务类型设置为推荐类型
    		Long recoId = recommendParams.getRecoId();
    		String recoLogo = recommendParams.getRecoLogo();
    		if(recoId != null){
    			ServiceType obj = new ServiceType();
    			
    			obj.setId(recoId);
    			obj.setIsReco(true);
    			obj.setRecoBy(getSessionQuietly().getUserId());
    			obj.setRecoTime(new Date());
    			obj.setRecoLogo(recoLogo);
    			obj.setOperator(getSessionQuietly().getUserId());
    			
    			serviceTypeService.update(obj);
    		}
	        return ResultSupport.ok();
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 获取推荐所有的服务类型
     * @param id
     * @return
     */
    @GET
    @Path("/getRecommend")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<List<Map<String,Object>>> getRecommend() {
    	try{
    		Query query = new Query();
    		query.setIsReco(true);
    		Page<ServiceType> page = serviceTypeService.findByCondition(query);
    		
    		List<ServiceType> itemList = page.getItems();
    		if(CollectionUtils.isEmpty(itemList)){
    			return new Result<List<Map<String,Object>>>(ResultCode.NOT_FOUND);
    		}
    		
    		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
    		Map<String, Object> dataMap = null;
			for(ServiceType item:itemList){
				dataMap = new HashMap<String, Object>();
				
				dataMap.put("id", item.getId());
				dataMap.put("recoLogo", notNull(item.getRecoLogo()));
				dataMap.put("name", notNull(item.getName()));
				
				dataList.add(dataMap);
			}
    		
	        return new Result<List<Map<String,Object>>>(ResultCode.OK,dataList);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<List<Map<String, Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private ServiceType extractValidInfo(ServiceType temp){
    	ServiceType obj = new ServiceType();

    	obj.setName(temp.getName());
    	obj.setTypeLogo(temp.getTypeLogo());
    	obj.setServerGrade(temp.getServerGrade());
    	obj.setRecoLogo(temp.getRecoLogo());
    	obj.setDescrible(temp.getDescrible());
    	    	
    	obj.setEnableStatus(temp.getEnableStatus());
    	if(temp.getEnableStatus().equals(EnableStatus.ENABLE)){
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    	}else{
    		obj.setDisableBy(getSessionQuietly().getUserId());
    		obj.setDisableTime(new Date());
    	}
    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(ServiceType item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(ServiceType item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("name", notNull(item.getName()));
    	infoMap.put("describle", notNull(item.getDescrible()));
    	infoMap.put("serverGrade", notNull(item.getServerGrade()));
    	infoMap.put("enableStatus", notNull(item.getEnableStatus()));
    	infoMap.put("isReco", notNull(item.getIsReco()));
    	String typeLogo = item.getTypeLogo();
		infoMap.put("typeLogo", "");
    	if(StringUtils.isNotEmpty(typeLogo)){
        	infoMap.put("typeLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + typeLogo);
    	}
    	String recoLogo = item.getRecoLogo();
    	infoMap.put("recoLogo", "");
    	if(StringUtils.isNotBlank(recoLogo)){
        	infoMap.put("recoLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + recoLogo);    		
    	}
    	
    	return infoMap;
    }
}
