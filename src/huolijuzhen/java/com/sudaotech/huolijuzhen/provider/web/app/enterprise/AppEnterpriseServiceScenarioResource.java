package com.sudaotech.huolijuzhen.provider.web.app.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.Query;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

@Path("/app/enterprise/serviceScenario")
public class AppEnterpriseServiceScenarioResource extends BaseResource {

    @Inject
    private ServiceScenarioService serviceScenarioService;
    
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
            @QueryParam("page") Integer pages) {
		try{
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pages);
			query.setEnableStatus(EnableStatus.ENABLE);
			
			//1.按条件获取服务场景信息
			Page<ServiceScenario> page = serviceScenarioService.findByCondition(query);
			//2.封装活动信息
	    	Map<String, Object> dataMap = packPageInfo(page);
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
		}catch(Exception e){
			e.printStackTrace();
			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }
    
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<ServiceScenario> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<ServiceScenario> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(ServiceScenario pc:list){
    			item = packListInfo(pc);
    			items.add(item);
    		}
    	}
    	dataMap.put("items", items);
    	return dataMap;
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

