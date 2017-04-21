package com.sudaotech.huolijuzhen.task.web.app.tenement;

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
import com.sudaotech.huolijuzhen.task.service.DescribleService;
import com.sudaotech.huolijuzhen.task.service.DescribleService.Describle;

@Path("/app/tenement/describle")
public class AppTenmentDescribleResource extends BaseResource {

    @Inject
    private DescribleService describleService;
    
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
    		if(parkId == null){
    			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
    		}
    		
    		List<Describle> list = describleService.findAll(parkId);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
        	
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
