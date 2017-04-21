package com.sudaotech.huolijuzhen.sys.common.web;

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
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService.OrderTemplate;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.provider.service.ServiceCollectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;

@Path("/detail/serviceProject")
public class DetailServiceProjectResource extends BusinessBaseResource {

    @Inject
    private ServiceProjectService serviceProjectService;
    
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
	        
	        return new Result<Map<String,Object>>(ResultCode.OK, dataMap);
    	}catch(Exception e){
    		logger.error("平台按 ID 获取服务项目详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
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
    		itemMap.put("addr", "平台自营");
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
    	List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.SERVICE_MAIN, item.getId());
    	itemMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		itemMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}

    	//轮播图
    	List<ImageInfo> listImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.SERVICE_LIST, item.getId());
    	itemMap.put("listImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(listImageInfos)){
    		itemMap.put("listImage", imageInfoListToMap(listImageInfos));
    	}   	
    	
    	//是否支持申请单
    	Boolean supportApply = item.getSupportApply();
    	Long applyViewId = item.getApplyViewId();
    	itemMap.put("supportApply", notNull(supportApply));
    	itemMap.put("applyTemplateId", notNull(applyViewId));
    	
    	//是否支持订单
    	Boolean supportOrder = item.getSupportOrder();
    	Long orderViewId = item.getOrderViewId();
    	itemMap.put("supportOrder", notNull(supportOrder));
    	itemMap.put("orderTemplateId", notNull(orderViewId));
    	if(supportOrder){
    		OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
    		if(orderTemplate == null){
    			itemMap.put("priceList", new ArrayList<Map<String, Object>>());
    			itemMap.put("discountList", new ArrayList<Map<String, Object>>());
    		}else{
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
    	}else{
    		itemMap.put("priceList", "");
			itemMap.put("discountList", "");
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