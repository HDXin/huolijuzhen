package com.sudaotech.huolijuzhen.provider.web.admin.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.enums.ChooseStatus;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService.ApplyTemplate;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService.OrderTemplate;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.provider.service.ApplyTemplateService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceParkService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProScaneService.ServiceProScane;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.Query;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.UpdateItemInfo;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/admin/enterprise/serviceProject")
public class AdminEnterpriseServiceProjectResource extends BusinessBaseResource {

    @Inject
    private ServiceProjectService serviceProjectService;
    
    @Inject
    private ServiceParkService serviceParkService;
    
    @Inject
    private OrderTemplateService orderTemplateService;
    
    @Inject
    private ProviderService providerService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private AreaService areaService;
    
    @Inject
    private ServiceCollectService serviceColletService;
    
    @Inject
    private ApplyTemplateService applyTemplateService;
   
    @Inject
    private TemplateLabelService templateLabelService;
   
    /**
     * 审批服务项目
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/approval/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> approval(
            @NotNull @PathParam("id") final Long id,
            @Valid final UpdateItemInfo updateItemInfo) {
    	try{
    		//1.判断参数中 id 是否为空
    		if(id == null){
    			return new Result<String>(ResultCode.PARAM_ERROR);
    		}
    		//2.判断是否有权限操作
    		//TODO
    		
    		//4.进行审批操作
    		ServiceProject obj = new ServiceProject();
    		
    		obj.setId(id);
    		obj.setApprovalBy(getSessionQuietly().getUserId());
    		obj.setApprovalStatus(updateItemInfo.getApprovalStatus());
    		obj.setApprovalText(updateItemInfo.getApprovalText());
    		obj.setApprovalTime(new Date());

    		serviceProjectService.update(obj);
    		return ResultSupport.ok();
    	}catch(Exception e){
    		logger.error("园区审批服务项目信息 error:{}",e);
    		return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 按 ID 获取服务项目详情
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(
    		@NotNull @PathParam("id") final Long id,
    		@QueryParam("parkId") Long parkId) {
    	try{
    		//1.获取服务项目详情
	        ServiceProject obj = serviceProjectService.getById(id);
	        Map<String, Object> dataMap = new HashMap<String, Object>();
	        if(obj == null){
	        	return new Result<Map<String,Object>>(ResultCode.NOT_FOUND);
	        }
	        dataMap = packItemInfo(obj);
	        //是否已经收藏
	    	Session session = getSessionQuietly();
	    	Long serviceCollectId = serviceColletService.isCollect(obj.getId(), session.getUserId(),parkId);
	    	dataMap.put("isCollect", false);
	    	if(serviceCollectId != null){
		    	dataMap.put("isCollect", true);
		    	dataMap.put("serviceCollectId", serviceCollectId);	    		
	    	}
	        
	        //2.更新点击量
	        ServiceProject temp = new ServiceProject();
	        int readNum = obj.getReadNum();
	        temp.setReadNum(readNum++);
	        temp.setId(id);
	        temp.setOperator(getSessionQuietly().getUserId());
	        serviceProjectService.update(temp);
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("平台按 ID 获取服务项目详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 按条件获取服务项目
     * @param offset
     * @param limit
     * @param pageNum
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("serviceTypeId") Long serviceTypeId,
            @QueryParam("serviceScenarioId") Long serviceScenarioId,
            @QueryParam("title") String title,
            @QueryParam("parkId") Long parkId){
    	
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
    		}
    		if(parkId == null){
    			return new Result<Map<String,Object>>(ResultCode.BAD_REQUEST);
    		}
			Query query = new Query();
			query.setOffset(offset);
			query.setLimit(limit);
			query.setPage(pageNum);
			query.setServiceTypeId(serviceTypeId);
			query.setTitle(title);

			//2.获取符合服务场景的所有的服务项目(当条件中包含场景时才作为条件)
			if(serviceScenarioId != null){
				ServiceProScane serviceProScane = new ServiceProScane();
				serviceProScane.setServiceScaneId(serviceScenarioId);
				List<ServiceProScane> serviceProScanes = serviceProScaneService.findByObj(serviceProScane);
				if(CollectionUtils.isEmpty(serviceProScanes)){
					return new Result<Map<String,Object>>(ResultCode.OK,new HashMap<String,Object>());
				}
				List<Long> serviceProIds = new ArrayList<Long>();
				for(ServiceProScane item:serviceProScanes){
					serviceProIds.add(item.getServiceProId());
				}
				query.setServiceProIds(serviceProIds);
			}
			
			Page<ServiceProject> page = null;
			//2.1、现状：未入驻
    		if(parkId == -1){
    			page = serviceProjectService.findParkValidServicePro(query, null, null);
    		}
    		//2.2 、已入驻
    		else{
    			//园区用户
    			Map<String,Object> params = new HashedMap<String, Object>();
    			params.put("status", Status.NORMAL.code());
    			params.put("chooseStatus", ChooseStatus.CHOOSE.code());
    			params.put("parkId", parkId);
    			
    			List<Long> ids = serviceParkService.findAllValidServiceProId(params);
    			page = serviceProjectService.findParkValidServicePro(query, parkId, ids);
    		}
    		Map<String, Object> resultMap = packPageInfo(page,parkId);
	        return new Result<Map<String,Object>>(ResultCode.OK, resultMap);
    	}catch(Exception e){
    		logger.error("平台按条件获取服务项目 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<ServiceProject> page,Long parkId){
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<ServiceProject> list = page.getItems();
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	Map<String, Object> item;
    	if(CollectionUtils.isNotEmpty(list)){
    		for(ServiceProject pc:list){
    			item = packListInfo(pc);
    			
    	        //是否已经收藏
    			Session session = getSessionQuietly();
    	    	Long serviceCollectId = serviceColletService.isCollect(pc.getId(), session.getUserId(),parkId);
    	    	item.put("isCollect", false);
    	    	if(serviceCollectId != null){
    	    		item.put("isCollect", true);
    	    		item.put("serviceCollectId", serviceCollectId);	    		
    	    	}
    			
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
    private Map<String, Object> packListInfo(ServiceProject item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("mainTitle", notNull(item.getMainTitle()));
    	infoMap.put("subTitle", notNull(item.getSubTitle()));
    	infoMap.put("content", notNull(item.getContent()));
    	
    	//主图
    	ImageInfo imageInfo = new ImageInfo();
    	imageInfo.setTargetId(item.getId());
    	imageInfo.setImageType(ImageType.SERVICE_MAIN);
    	imageInfo.setServiceProRelease(item.getReleases());
    	List<ImageInfo> mainImageInfos = imageInfoService.findByObj(imageInfo);
    	infoMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		infoMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}
		
		//价格
		Object supportOrder = item.getSupportOrder();
		infoMap.put("supportOrder", supportOrder);
		if(supportOrder != null && (Boolean)supportOrder){
			Long orderViewId = item.getOrderViewId();
			OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
			if(orderTemplate.getPriceOne() != null){
				infoMap.put("price", orderTemplate.getPriceOne().toString());
			}else{
				infoMap.put("price", "");
			}
		}else{
			infoMap.put("price", "");
		}	
	
		//地址
		ServiceGrade serviceGrade = item.getServiceGrade();
		if(ServiceGrade.PLATFORMSELF.equals(serviceGrade)){
			infoMap.put("addr", "平台自营");
		}else if(ServiceGrade.PARKSELF.equals(serviceGrade)){
			Long parkAddrId = item.getParkId();
			ParkInfo parkInfo = parkInfoService.getById(parkAddrId);
			
			Long cityId = parkInfo.getCityId();
			Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
			Long counId = parkInfo.getRegionId();
			Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
			
			infoMap.put("addr", city.getName() + "." + country.getName());
		}else if(ServiceGrade.PARKSERVICE.equals(serviceGrade) || ServiceGrade.PLATFORMSERVICE.equals(serviceGrade)){
	
			Long providerId = item.getServiceGradeId();
			Provider provider = providerService.getById(providerId);
	
			Long cityId = provider.getCityId();
			Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
	
			Long counId = provider.getCounId();
			Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
			
			infoMap.put("addr", city.getName() + "." + country.getName());
		}
		
    	return infoMap;
    }
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(ServiceProject item){
    	
    	Map<String,Object> itemMap = new HashMap<String, Object>();
    	
    	itemMap.put("id", item.getId());
    	itemMap.put("mainTitle", notNull(item.getMainTitle()));
    	itemMap.put("subTitle", notNull(item.getSubTitle()));
    	itemMap.put("content", notNull(item.getContent()));
    	itemMap.put("detailUrl", HuolijuzhenConfig.getInstance().getDomainHtmlUrl() + "/static/service.html?id=" + item.getId());
    	
    	ServiceGrade serviceGrade = item.getServiceGrade();
    	if(ServiceGrade.PLATFORMSELF.equals(serviceGrade)){
    		itemMap.put("addr", "平台自营项目");
    	}else if(ServiceGrade.PARKSELF.equals(serviceGrade)){
    		Long parkId = item.getParkId();
    		ParkInfo parkInfo = parkInfoService.getById(parkId);
    		
    		Long cityId = parkInfo.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));

    		Long counId = parkInfo.getRegionId();
    		Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		
    		itemMap.put("addr", city.getName() + "." + country.getName());

    	}else if(ServiceGrade.PARKSERVICE.equals(serviceGrade) || ServiceGrade.PLATFORMSERVICE.equals(serviceGrade)){

    		Long providerId = item.getServiceGradeId();
    		Provider provider = providerService.getById(providerId);
    		
    		Long cityId = provider.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
    		
    		Long counId = provider.getCounId();
    		Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		
    		itemMap.put("addr", city.getName() + "." + country.getName());
    	}
    	
    	//主图
    	ImageInfo imageInfo = new ImageInfo();
    	imageInfo.setTargetId(item.getId());
    	imageInfo.setImageType(ImageType.SERVICE_MAIN);
    	imageInfo.setServiceProRelease(item.getReleases());
    	List<ImageInfo> mainImageInfos = imageInfoService.findByObj(imageInfo);
    	itemMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		itemMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}

    	//轮播图
    	imageInfo.setImageType(ImageType.SERVICE_LIST);
    	List<ImageInfo> listImageInfos = imageInfoService.findByObj(imageInfo);
    	itemMap.put("listImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(listImageInfos)){
    		itemMap.put("listImage", imageInfoListToMap(listImageInfos));
    	}    	
    	
    	//是否支持申请单
    	Boolean supportApply = item.getSupportApply();
    	itemMap.put("supportApply", notNull(supportApply));
		itemMap.put("applyTemplateId", item.getApplyViewId());
		itemMap.put("applyTemplate", new HashMap<String, Object>());
		if(supportApply){
    		Long applyTemplateId = item.getApplyViewId();
        	ApplyTemplate obj = applyTemplateService.getById(applyTemplateId);
            if(obj != null){
                Map<String, Object> applyTemplate = new HashMap<String, Object>();
                applyTemplate.put("id", obj.getId());
                
                List<Map<String, Object>> templateLabelList = templateLabelService.findByApplyTemplateId(applyTemplateId);
                applyTemplate.put("templateLabels",templateLabelList);
                
                itemMap.put("applyTemplate", applyTemplate);
            }
    	}
    	//是否支持订单
    	Boolean supportOrder = item.getSupportOrder();
    	Long orderViewId = item.getOrderViewId();
       	itemMap.put("supportOrder", notNull(supportOrder));
    	itemMap.put("orderTemplateId", orderViewId);
		itemMap.put("priceList", new ArrayList<Map<String, Object>>());
		itemMap.put("discountList", new ArrayList<Map<String, Object>>());
    	if(supportOrder){
    		OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
    		if(orderTemplate != null){
    			List<Map<String, Object>> priceList = new ArrayList<Map<String,Object>>();
    			Map<String, Object> priceMap = null;
    			if(StringUtils.isNotBlank(orderTemplate.getPriceTitleOne())){
    				priceMap = new HashMap<String, Object>();
    				priceMap.put("title", notNull(orderTemplate.getPriceTitleOne()));
        			priceMap.put("price", notNull(orderTemplate.getPriceOne()));
        			
        			priceList.add(priceMap);
    			}
    			
    			if(StringUtils.isNotBlank(orderTemplate.getPriceTitleTwo())){
    				priceMap = new HashMap<String, Object>();
    				priceMap.put("title", notNull(orderTemplate.getPriceTitleTwo()));
        			priceMap.put("price", notNull(orderTemplate.getPriceTwo()));

        			priceList.add(priceMap);
    			}

    			if(StringUtils.isNotBlank(orderTemplate.getPriceTitleThree())){
    				priceMap = new HashMap<String, Object>();
    				priceMap.put("title", notNull(orderTemplate.getPriceTitleThree()));
        			priceMap.put("price", notNull(orderTemplate.getPriceThree()));
        				
        			priceList.add(priceMap);
    			}
    			
    			List<Map<String, Object>> discountList = new ArrayList<Map<String,Object>>();
    			Map<String, Object> discountMap = null;
    			
    			if(StringUtils.isNotBlank(orderTemplate.getDiscountTitleOne())){
    				discountMap = new HashedMap<String, Object>();
    				discountMap.put("title", notNull(orderTemplate.getDiscountTitleOne()));
    				discountMap.put("price", notNull(orderTemplate.getDiscountOne()));

        			discountList.add(discountMap);
    			}

    			if(StringUtils.isNotBlank(orderTemplate.getDiscountTitleTwo())){
    				discountMap = new HashedMap<String, Object>();
    				discountMap.put("title", notNull(orderTemplate.getDiscountTitleTwo()));
    				discountMap.put("price", notNull(orderTemplate.getDiscountTwo()));

        			discountList.add(discountMap);
    			}

    			if(StringUtils.isNotBlank(orderTemplate.getDiscountTitleThree())){
    				discountMap = new HashedMap<String, Object>();
    				discountMap.put("title", notNull(orderTemplate.getDiscountTitleThree()));
    				discountMap.put("price", notNull(orderTemplate.getDiscountThree()));

        			discountList.add(discountMap);
    			}
    			itemMap.put("priceList", priceList);
    			itemMap.put("discountList", discountList);
    		}
    	}

    	//订单数
    	itemMap.put("orderNum", item.getApplyOrderNum());
    	//收藏数量
    	itemMap.put("collectNum", item.getCollectNum());
		//评论星级
    	itemMap.put("commentNum", item.getCommentNum());
		//点击量
    	itemMap.put("readNum", item.getReadNum());
    	
    	return itemMap;
    }
}