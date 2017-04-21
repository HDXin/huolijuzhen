package com.sudaotech.huolijuzhen.task.web.admin.park;

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
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.huolijuzhen.task.service.DescribleService;
import com.sudaotech.huolijuzhen.task.service.DescribleService.Describle;
import com.sudaotech.huolijuzhen.task.service.DescribleService.Query;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/describle")
public class DescribleResource extends BusinessBaseResource {

    @Inject
    private DescribleService describleService;
    
    /**
     * 添加描述
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final Describle obj) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Long>>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		Long parkId = session.getPlatformId();
            // create
    		Describle temp = extractValidInfo(obj);
            temp.setOperator(getSessionQuietly().getUserId());
            temp.setParkId(parkId);
            temp.setEnableStatus(EnableStatus.DISABLE);
            temp.setDisableBy(getSessionQuietly().getUserId());
            temp.setDisableTime(new Date());
            Long id = describleService.create(temp);
            
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/describle/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("添加常用描述，errors:{}", e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 根据 ID 编辑常用描述
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
            @Valid final Describle obj) {
    	
    	try{
            Describle tempDescrible = extractValidInfo(obj);
            tempDescrible.setId(id);
            tempDescrible.setOperator(getSessionQuietly().getUserId());
            describleService.update(tempDescrible);
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("常用描述编辑 errors:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 根据 ID 启用常用描述
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/enable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> enable(
            @NotNull @PathParam("id") final Long id) {
    	
    	try{
            Describle temp = new Describle();
            temp.setId(id);
            
            temp.setEnableStatus(EnableStatus.ENABLE);
            temp.setEnableBy(getSessionQuietly().getUserId());
            temp.setEnableTime(new Date());
            temp.setOperator(getSessionQuietly().getUserId());
            
            describleService.update(temp);
            
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("常用描述编辑 errors:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 根据 ID 禁用常用描述
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/disable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> disable(
            @NotNull @PathParam("id") final Long id) {
    	
    	try{
            Describle temp = new Describle();
            temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            
            temp.setEnableStatus(EnableStatus.DISABLE);
            temp.setDisableBy(getSessionQuietly().getUserId());
            temp.setDisableTime(new Date());
            describleService.update(temp);
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("常用描述编辑 errors:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 根据 ID 删除指定描述
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
    	try{
            Describle obj = new Describle();
            obj.setId(id);
            obj.setStatus(Status.DELETED);
            obj.setDeleteBy(getSessionQuietly().getUserId());
            obj.setDeleteTime(new Date());
            obj.setOperator(getSessionQuietly().getUserId());
            
            describleService.update(obj);
            
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("删除常用描述 error:{}" ,e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 根据 ID 批量删除
     * @param ids
     * @return
     */
    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
    	try{
        	if (CollectionUtils.isNotEmpty(ids)) {
        		Describle item = null;
    			for (Long id : ids) {
    				item = new Describle();
    				item.setId(id);
    				item.setStatus(Status.DELETED);
                    item.setDeleteBy(getSessionQuietly().getUserId());
                    item.setDeleteTime(new Date());
                    item.setOperator(getSessionQuietly().getUserId());
                    
                    describleService.update(item);
    			}
        	}
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("常用描述批量删除 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            Describle obj = describleService.getById(id);
            Map<String, Object> dataMap = new HashedMap<String, Object>();
            if(obj != null){
            	dataMap = packItemInfo(obj);
            }
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("根据 ID 获取常用描述 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
    		@QueryParam("description") String description,
    		@QueryParam("enableStatus") String enableStatus) {
    	try{
    		if(sessionIsNull()){
    			return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		Long parkId = session.getPlatformId();
    		
    		
    		Query query = new Query();
    		query.setDescription(description);
    		query.setEnableStatus(enableStatus);
    		query.setParkId(parkId);

    		Page<Describle> page = describleService.find(query);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<Describle> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item;
        	if(CollectionUtils.isNotEmpty(list)){
        		for(Describle comm:list){
        			item = new HashedMap<String, Object>();
        			item = packListInfo(comm);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
    		return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("按条件查询常用术语 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private Describle extractValidInfo(Describle temp){
    	Describle obj = new Describle();

    	obj.setDesciption(temp.getDesciption());
    	 
    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(Describle item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	infoMap.put("enableStatus", item.getEnableStatus());
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(Describle item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("description", notNull(item.getDesciption()));
    	
    	return infoMap;
    }

}
