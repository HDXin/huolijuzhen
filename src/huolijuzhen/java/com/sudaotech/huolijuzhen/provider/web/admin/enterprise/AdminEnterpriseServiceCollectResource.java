package com.sudaotech.huolijuzhen.provider.web.admin.enterprise;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService.OrderTemplate;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService.CollectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService.Query;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService.ServiceCollect;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/admin/enterprise/serviceCollect")
public class AdminEnterpriseServiceCollectResource extends BusinessBaseResource {

    @Inject
    private ServiceCollectService serviceCollectService;
    
    @Inject
    private ServiceProjectService serviceProjectService;
    
    @Inject
    private OrderTemplateService orderTemplateService;    
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private AreaService areaService;
    
    @Inject
    private ProviderService providerService;
    /**
     * 收藏服务项目
     * @param obj
     * @return
     */
    @POST
    @Path("/collect/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> create(@Valid final CollectService collectService) {
    	try{
            // 
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		Long userId = session.getUserId();
    		collectService.setCollectBy(userId);
    		Page<ServiceCollect> page = serviceCollectService.findByServiceCollect(collectService);
            List<ServiceCollect> items = page.getItems();

            ServiceCollect obj = new ServiceCollect();
            obj.setStatus(Status.NORMAL);
            if(CollectionUtils.isNotEmpty(items)){
            	ServiceCollect temp = items.get(0);
            	obj.setId(temp.getId());
            	serviceCollectService.update(obj);
            }else{
                obj.setServiceProId(collectService.getServiceProId());
                obj.setParkId(collectService.getParkId());
            	obj.setCollectBy(userId);
            	obj.setOperator(userId);
            	serviceCollectService.create(obj);
            }
            
            //2.更新服务项目收藏数
            updateServiceProject(obj);
            
            return new Result<String>(ResultCode.OK);
    	}catch(Exception e){
    		logger.error("企业用户收藏服务项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 取消收藏服务项目
     * @param obj
     * @return
     */
    @PUT
    @Path("/uncollect/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> uncollect(@Valid final CollectService collectService) {
    	try{
            // 
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<String>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		Long serviceCollectId = collectService.getServiceCollectId();
    		//1.1 两种方式删除( ID 删除 )
    		ServiceCollect obj = new ServiceCollect();
    		if(serviceCollectId != null){
    			obj.setId(serviceCollectId);
    			obj.setStatus(Status.DELETED);
    			
    			serviceCollectService.update(obj);
    		}
    		//1.2 两种方式删除
    		else{
        		Long userId = session.getUserId();
        		collectService.setCollectBy(userId);
        		Page<ServiceCollect> page = serviceCollectService.findByServiceCollect(collectService);
                List<ServiceCollect> items = page.getItems();
                
                obj.setStatus(Status.DELETED);
                if(CollectionUtils.isNotEmpty(items)){
                	ServiceCollect temp = items.get(0);
                	obj.setId(temp.getId());
                	serviceCollectService.update(obj);
                }else{
                    obj.setServiceProId(collectService.getServiceProId());
                    obj.setParkId(collectService.getParkId());
                    obj.setCollectBy(userId);
                	obj.setOperator(userId);
                	serviceCollectService.create(obj);
                }
    		}
            
            //2.更新服务项目收藏数
            updateServiceProject(obj);
            
            return new Result<String>(ResultCode.OK);
    	}catch(Exception e){
    		logger.error("企业用户取消收藏服务项目 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 我的收藏列表
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("parkId") Long parkId
            ) {
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    		}
    		Long userId = session.getUserId();
    		
    		Query query = new Query();
    		query.setOffset(offset);
    		query.setLimit(limit);
    		query.setPage(pageNum);
    		query.setCollectBy(userId);
    		query.setParkId(parkId);
    		
    		Page<ServiceCollect> page = serviceCollectService.find(query);
    		Map<String, Object> dataMap = new HashedMap<String, Object>();
    		dataMap.put("offset", page.getOffset());
        	dataMap.put("limit", page.getLimit());
        	dataMap.put("total", page.getTotal());
        	dataMap.put("sortField", page.getSortField());
        	dataMap.put("sortOrder", page.getSortOrder());
    		
    		
    		List<ServiceCollect> items = page.getItems();
    		if(CollectionUtils.isNotEmpty(items)){
    			List<Map<String,Object>> serviceProjects = new ArrayList<Map<String,Object>>();
    			for(ServiceCollect item:items){
    				Long serviceProId = item.getServiceProId();
        			ServiceProject tempServiceProject = serviceProjectService.getById(serviceProId);
        			Map<String, Object> itemMap = packListItem(tempServiceProject);
        			itemMap.put("serviceCollectId", item.getId());
        			
        			serviceProjects.add(itemMap);
    			}
        		dataMap.put("items", serviceProjects);    			
    		}else{
    			dataMap.put("items", new ArrayList<Map<String, Object>>());
    		}
            return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    		
    	}catch(Exception e){
    		logger.error("企业查询收藏的服务项目列表 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    private Map<String, Object> packListItem(ServiceProject item){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	Map<String, Object> itemMap = new HashMap<String, Object>();
    	
    	itemMap.put("id", item.getId());
		itemMap.put("mainTitle", notNull(item.getMainTitle()));
		itemMap.put("subTitle", notNull(item.getSubTitle()));
		itemMap.put("approvalStatus", notNull(item.getApprovalStatus()));
		itemMap.put("createTime", sdf.format(item.getCreateTime()));
			
		//主图
    	List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.SERVICE_MAIN,item.getId());
    	itemMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		itemMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}
		
		//价格
		Boolean supportOrder = item.getSupportOrder();
		itemMap.put("supportOrder", supportOrder);
		if(supportOrder){
			Long orderViewId = item.getOrderViewId();
			OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
			if(orderTemplate.getPriceOne() != null){
				itemMap.put("price", orderTemplate.getPriceOne().toString());
			}else{
				itemMap.put("price", "");
			}
		}else{
			itemMap.put("price", "");
		}
		
		//地址
		ServiceGrade serviceGrade = item.getServiceGrade();
    	if(ServiceGrade.PLATFORMSELF.equals(serviceGrade)){
    		itemMap.put("addr", "平台自营项目");
    	}else if(ServiceGrade.PARKSELF.equals(serviceGrade)){
    		Long parkAddrId = item.getParkId();
    		ParkInfo parkInfo = parkInfoService.getById(parkAddrId);
    		Long proId = parkInfo.getProvinceId();
    		Area province = areaService.getByAreaId(Integer.parseInt(proId.toString()));
    		
    		Long cityId = parkInfo.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
    		
    		itemMap.put("addr", province + "." + city);
    	}else if(ServiceGrade.PARKSERVICE.equals(serviceGrade) || ServiceGrade.PLATFORMSERVICE.equals(serviceGrade)){

    		Long providerId = item.getServiceGradeId();
    		Provider provider = providerService.getById(providerId);
    		
    		Long proId = provider.getProId();
    		Area province = areaService.getByAreaId(Integer.parseInt(proId.toString()));
    		
    		Long cityId = provider.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
    		
    		itemMap.put("addr", province + "." + city);
    	}

    	return itemMap;
    }
    
    /**
     * 更新服务项目
     * @param serviceCollect
     */
    private void updateServiceProject(ServiceCollect serviceCollect){
    	Integer collectNum = serviceCollectService.findCollectNum(serviceCollect.getServiceProId());
    	
    	ServiceProject serviceProject = new ServiceProject();
    	serviceProject.setId(serviceCollect.getServiceProId());
    	serviceProject.setCollectNum(collectNum);
    	
    	serviceProject.setOperator(getSessionQuietly().getUserId());
    	serviceProjectService.update(serviceProject);
    }
}
