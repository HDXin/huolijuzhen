package com.sudaotech.huolijuzhen.sys.common.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/base/serviceScenario")
public class BaseServiceScenarioResource extends BusinessBaseResource {

    @Inject
    private ServiceScenarioService serviceScenarioService;
    
    /**
     * 获取所有的未被删除的服务场景
     * @param query
     * @return
     */
    @GET
    @Path("/findAll")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> findAll(@QueryParam("type") String type) {
		try{
			
			//1.按条件获取服务场景信息
			List<ServiceScenario> list = serviceScenarioService.findAll(type);
			//2.封装活动信息
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
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
     * 获取所有已启用的服务场景
     * @param query
     * @return
     */
    @GET
    @Path("/findValid")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> findValid(@QueryParam("type") String type) {
		try{
			
			//1.按条件获取服务场景信息
			List<ServiceScenario> list = serviceScenarioService.findValid(type);
			//2.封装活动信息
	    	Map<String, Object> dataMap = new HashedMap<String, Object>();
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
    	String scaneLogo = item.getScaneLogo();
    	infoMap.put("scaneLogo", "");
		if(StringUtils.isNotBlank(scaneLogo)){
			infoMap.put("scaneLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + item.getScaneLogo());
		}
		String recoLogo = item.getRecoLogo();
		infoMap.put("recoLogo", "");
		if(StringUtils.isNotBlank(recoLogo)){
			infoMap.put("recoLogo", HuolijuzhenConfig.getInstance().getDomainUrl() + item.getRecoLogo());
		}
    	
    	return infoMap;
    }
}

