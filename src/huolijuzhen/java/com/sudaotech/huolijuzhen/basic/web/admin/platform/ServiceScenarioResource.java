package com.sudaotech.huolijuzhen.basic.web.admin.platform;

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
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.Query;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/serviceScenario")
public class ServiceScenarioResource extends BusinessBaseResource {

    @Inject
    private ServiceScenarioService serviceScenarioService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ServiceScenario obj) {
    	try{
    		ServiceScenario temp = extractValidInfo(obj);
 
    		// create
            temp.setOperator(getSessionQuietly().getUserId());
            Long id = serviceScenarioService.create(temp);
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/serviceScenario/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		e.printStackTrace();
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
            @Valid final ServiceScenario obj) {
    	try{
    		ServiceScenario temp = extractValidInfo(obj);
    		temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            serviceScenarioService.update(temp);
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
        ServiceScenario obj = new ServiceScenario();
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
            ServiceScenario obj = serviceScenarioService.getById(id);
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
    
    @PUT
    @Path("/start/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> satrt(
            @NotNull @PathParam("id") final Long id) {
    	try{
	        ServiceScenario obj = new ServiceScenario();
	    	obj.setId(id);
	        obj.setOperator(getSessionQuietly().getUserId());
	        
	        obj.setEnableBy(getSessionQuietly().getUserId());
	        obj.setEnableTime(new Date());
	        obj.setEnableStatus(EnableStatus.ENABLE);
	        serviceScenarioService.update(obj);
	        return ResultSupport.ok();
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @PUT
    @Path("/forbidden/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> fobidden(
            @NotNull @PathParam("id") final Long id) {
    	
    	try{
	        ServiceScenario obj = new ServiceScenario();
	    	obj.setId(id);
	        obj.setOperator(getSessionQuietly().getUserId());
	        
	        obj.setDisableBy(getSessionQuietly().getUserId());
	        obj.setDisableTime(new Date());
	        obj.setEnableStatus(EnableStatus.DISABLE);
	        serviceScenarioService.update(obj);
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
            @QueryParam("name") String name,
            @QueryParam("serverGrade") String serverGrade
            ) {
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pages);
			query.setName(name);
			query.setServerGrade(serverGrade);
			
			//1.按条件获取服务场景信息
			Page<ServiceScenario> page = serviceScenarioService.findByCondition(query);
			//2.封装活动信息
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
	    	dataMap.put("offset", page.getOffset());
	    	dataMap.put("limit", page.getLimit());
	    	dataMap.put("total", page.getTotal());
	    	dataMap.put("sortField", page.getSortField());
	    	dataMap.put("sortOrder", page.getSortOrder());
	    	
	    	List<ServiceScenario> list = page.getItems();
	    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	    	Map<String, Object> item;
	    	if(CollectionUtils.isNotEmpty(list)){
	    		for(ServiceScenario se:list){
	    			item = packListInfo(se);
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
     * 提取有效信息
     * @param temp
     * @return
     */
    private ServiceScenario extractValidInfo(ServiceScenario temp){
    	ServiceScenario obj = new ServiceScenario();

    	obj.setName(temp.getName());
    	obj.setScaneLogo(temp.getScaneLogo());
    	obj.setRecoLogo(temp.getRecoLogo());
    	obj.setServerGrade(temp.getServerGrade());
    	obj.setDescrible(temp.getDescrible());
     	
    	obj.setEnableStatus(temp.getEnableStatus());
    	if(temp.getEnableStatus() == EnableStatus.ENABLE){
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    	}else if(temp.getEnableStatus() == EnableStatus.DISABLE){
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
    private Map<String, Object> packListInfo(ServiceScenario item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(ServiceScenario item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("name", notNull(item.getName()));
    	infoMap.put("describle", notNull(item.getDescrible()));
    	infoMap.put("serverGrade", notNull(item.getServerGrade()));
    	infoMap.put("enableStatus", notNull(item.getEnableStatus()));
    	String scanLogo = item.getScaneLogo();
    	infoMap.put("scaneLogo", "");
    	if(StringUtils.isNotBlank(scanLogo)){
    		infoMap.put("scaneLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + scanLogo);
    	}
    	String recoLogo = item.getRecoLogo();
    	infoMap.put("recoLogo", "");
    	if(StringUtils.isNotBlank(recoLogo)){
    		infoMap.put("recoLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + recoLogo);
    	}
    	
    	return infoMap;
    }
}

