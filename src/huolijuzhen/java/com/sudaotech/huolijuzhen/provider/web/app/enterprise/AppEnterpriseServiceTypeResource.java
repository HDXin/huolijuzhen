package com.sudaotech.huolijuzhen.provider.web.app.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/app/enterprise/serviceType")
public class AppEnterpriseServiceTypeResource extends BusinessBaseResource {

    @Inject
    private ServiceTypeService serviceTypeService;

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
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pages) {
    	try{
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pages);
    		query.setEnableStatus(EnableStatus.ENABLE);
    		
    		//1.按条件查询服务信息
    		Page<ServiceType> page = serviceTypeService.findByCondition(query);
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
    private Map<String, Object> packPageInfo(Page<ServiceType> page){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<ServiceType> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(ServiceType pc:list){
    			item = packListInfo(pc);
    			items.add(item);
    		}
    	}
    	dataMap.put("items", items);
    	return dataMap;
    }
    
    /**
     * 获取推荐的所有的服务类型默认是三个
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
				dataMap.put("describle", notNull(item.getDescrible()));
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
