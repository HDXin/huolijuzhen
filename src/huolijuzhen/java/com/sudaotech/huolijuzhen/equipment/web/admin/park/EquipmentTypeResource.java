package com.sudaotech.huolijuzhen.equipment.web.admin.park;

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
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService.EquipmentType;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService.Query;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

/**
 * 设备类型
 * @author admin
 *
 */
@Path("/admin/park/equipmentType")
public class EquipmentTypeResource extends BusinessBaseResource {

    /**
     * 新增设备类型
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EquipmentType obj) {
    	try{
	        EquipmentType temp = extractValidInfo(obj);
	        
	        temp.setOperator(getSessionQuietly().getUserId());
	      //TODO 设置所属 园区
	        Long parkId = getSessionQuietly().getPlatformId();
	        temp.setParkId(parkId);
	        
	        Long id = equipmentTypeService.create(temp);
	        Map<String, Long> map = MapHelper.put("id", id).getMap();
	
	        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
	        result.setLocation(String.format("/equipmentType/%s", id));
	        result.setData(map);
        return result;
    	}catch(Exception e){
    		logger.error("添加设备类型 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑设备类型信息
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
            @Valid final EquipmentType obj) {
    	try{

    		EquipmentType temp = extractValidInfo(obj);
    		
    		temp.setId(id);
	        temp.setOperator(getSessionQuietly().getUserId());
	        equipmentTypeService.update(temp);
        return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("编辑设备信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 启用设备类型
     * @param id
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

    		EquipmentType temp = new EquipmentType();
    		
    		temp.setId(id);
	        temp.setOperator(getSessionQuietly().getUserId());
	        temp.setEnableStatus(EnableStatus.ENABLE);
	        temp.setEnableBy(getSessionQuietly().getUserId());
	        temp.setEnableTime(new Date());
	        equipmentTypeService.update(temp);
        return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("编辑设备信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 禁用设备类型
     * @param id
     * @return
     */
    @PUT
    @Path("/disable/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> disable(
            @NotNull @PathParam("id") final Long id) {
    	try{
    		Map<String, Object> dataMap = new HashedMap<String, Object>();
    		//1.判断是否可以被禁用
    		if(sessionIsNull()){
    			return new Result<Map<String, Object>>(ResultCode.SESSION_IS_NULL);
    		}
    		Session session = getSessionQuietly();
    		Long parkId = session.getPlatformId();
    		int count = equipmentPreserveService.findCountByEquTypeId(parkId, id);
    		if(count > 0){
    			dataMap.put("isDisable", false);
    			return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    		}
   			dataMap.put("isDisable", true);
  
   			//2.进行禁用操作
    		EquipmentType temp = new EquipmentType();
    		temp.setId(id);
	        temp.setOperator(getSessionQuietly().getUserId());
	        temp.setEnableStatus(EnableStatus.DISABLE);
	        temp.setDisableBy(getSessionQuietly().getUserId());
	        temp.setDisableTime(new Date());
	        equipmentTypeService.update(temp);
        return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("编辑设备信息 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按指定的 ID 删除设备类型
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
            EquipmentType obj = new EquipmentType();
            obj.setId(id);
            obj.setOperator(getSessionQuietly().getUserId());
            obj.setStatus(Status.DELETED);
            obj.setDeleteBy(getSessionQuietly().getUserId());
            obj.setDeleteTime(new Date());
            equipmentTypeService.update(obj);
            return ResultSupport.ok();
    		
    	}catch(Exception e){
    		logger.error("按指定 ID 删除设备类型 error：{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 按指定的 ID 批量删除设备类型
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
          
    		if (!CollectionUtils.isEmpty(ids)) {
    			  EquipmentType obj = null;    				
    			  for (Long id : ids) {
					  obj = new EquipmentType();
					  obj.setId(id);
					  obj.setOperator(getSessionQuietly().getUserId());
 		              obj.setStatus(Status.DELETED);
 		              obj.setDeleteBy(getSessionQuietly().getUserId());
 		              obj.setDeleteTime(new Date());
		              equipmentTypeService.update(obj);
    			}
        	}
            return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("按指定 ID 批量删除设备类型 error：{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    	
    	
    }

    /**
     * 按 ID 获取指定的设备类型
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            EquipmentType obj = equipmentTypeService.getById(id);
            Map<String, Object> dataMap = new HashedMap<String, Object>();
            if(obj != null){
            	dataMap = packItemInfo(obj);
            }else {
				return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
			}
            
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("按 ID 获取指定的设备类型 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 按条件查询设备类型
     * @param query
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("enableStatus") String enableStatus,
            @QueryParam("nameOrCode") String nameOrCode) {
    	
    	
		Page<EquipmentType> page = null; 
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setEnableStatus(enableStatus);
			query.setNameOrCode(nameOrCode);
			
			Long parkId = getSessionQuietly().getPlatformId();
			query.setParkId(parkId);
			
			page = equipmentTypeService.find(query);
			//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
        	
        	List<EquipmentType> list = page.getItems();
        	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        	Map<String, Object> item = new HashedMap<String, Object>();
        	if(CollectionUtils.isNotEmpty(list)){
        		for(EquipmentType equType:list){
        			item = packListInfo(equType);
        			items.add(item);
        		}
        	}
        	dataMap.put("items", items);
        	return new Result<Map<String,Object>>(ResultCode.OK,dataMap);

		}catch(Exception e){
			logger.error("按条件查询设备信息 error:{}",e);
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private EquipmentType extractValidInfo(EquipmentType temp){
    	EquipmentType obj = new EquipmentType();
    	
    	obj.setName(temp.getName());
    	obj.setCode(temp.getCode());
    	
    	EnableStatus enableStatus = temp.getEnableStatus();
    	if(EnableStatus.ENABLE.equals(enableStatus)){
    		obj.setEnableBy(getSessionQuietly().getUserId());
    		obj.setEnableTime(new Date());
    	}else{
    		obj.setDisableBy(getSessionQuietly().getUserId());
    		obj.setDisableTime(new Date());
    	}
    	obj.setEnableStatus(enableStatus);

    	return obj;
    }
    /**
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(EquipmentType item){
    	Map<String, Object> infoMap = packItemInfo(item);
    	return infoMap;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(EquipmentType item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();

    	infoMap.put("id", item.getId());
    	infoMap.put("name", notNull(item.getName()));
    	infoMap.put("code", notNull(item.getCode()));
    	infoMap.put("enableStatus", notNull(item.getEnableStatus()));
    	
    	Long parkId = getSessionQuietly().getPlatformId();
    	int count = equipmentPreserveService.findCountByEquTypeId(parkId, item.getId());
    	if(count > 0){
    		infoMap.put("isDisable", false);
    	}else{
    		infoMap.put("isDisable", true);
    	}
    	
    	return infoMap;
    }
}
