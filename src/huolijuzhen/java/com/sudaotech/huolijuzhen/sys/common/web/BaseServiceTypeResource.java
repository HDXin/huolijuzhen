package com.sudaotech.huolijuzhen.sys.common.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.Query;
import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.ServiceType;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/base/serviceType")
public class BaseServiceTypeResource extends BusinessBaseResource {

    @Inject
    private ServiceTypeService serviceTypeService;

    /**
     * 获取所有的未被删除的服务类型
     * @param query
     * @return
     */
    @GET
    @Path("/findAll")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findAll(@QueryParam("type") String type) {
    	try{
    		//1.按条件查询服务信息
    		List<ServiceType> list = serviceTypeService.findAll(type);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
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
     * 获取所有的未被删除的服务类型
     * @param query
     * @return
     */
    @GET
    @Path("/findValid")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> findValid(@QueryParam("type") String type) {
    	try{
    		//1.按条件查询服务信息
    		List<ServiceType> list = serviceTypeService.findValid(type);
    		//2.封装活动信息
        	Map<String, Object> dataMap = new HashedMap<String, Object>();
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
				dataMap.put("name", notNull(item.getName()));
				String recoLogo = item.getRecoLogo();
				dataMap.put("recoLogo", "");
				if(StringUtils.isNotBlank(recoLogo)){
					dataMap.put("recoLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + item.getRecoLogo());
				}
				
				dataList.add(dataMap);
			}
    		
	        return new Result<List<Map<String,Object>>>(ResultCode.OK,dataList);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Result<List<Map<String, Object>>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
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
    	String typeLogo = item.getTypeLogo();
    	infoMap.put("typeLogo", "");
		if(StringUtils.isNotBlank(typeLogo)){
			infoMap.put("typeLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + item.getTypeLogo());
		}
		String recoLogo = item.getRecoLogo();
		infoMap.put("recoLogo", "");
		if(StringUtils.isNotBlank(recoLogo)){
			infoMap.put("recoLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + item.getRecoLogo());
		}
    	
    	return infoMap;
    }

}
