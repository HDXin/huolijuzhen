package com.sudaotech.huolijuzhen.equipment.web.app.tenement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService.EquipmentType;

/**
 * 设备类型
 * @author admin
 *
 */
@Path("/app/tenement/equipmentType")
public class AppTenementEquipmentTypeResource extends BaseResource {

    @Inject
    private EquipmentTypeService equipmentTypeService;
    
    
    /**
     * 按条件查询设备类型
     * @param query
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find() {
    	
		try{

			Session session = getSessionQuietly();
			if(session == null){
				return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
			}
			
			Long parkId = session.getPlatformId();
			List<EquipmentType> list = equipmentTypeService.findAll(parkId);
			
			Map<String, Object> dataMap = new HashedMap<String, Object>();
			//2.封装活动信息
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
     * 封装列表信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packListInfo(EquipmentType item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();

    	infoMap.put("id", item.getId());
    	infoMap.put("name", notNull(item.getName()));
    	infoMap.put("code", notNull(item.getCode()));
    	infoMap.put("enableStatus", notNull(item.getEnableStatus()));
    	return infoMap;
    }
    
    /**
     * 判断是否为空，为空返回空串
     * @param obj
     * @return
     */
    private Object notNull(Object obj){
    	if(obj == null){
    		return "";
    	}else{
    		return obj;
    	}
    }
}
