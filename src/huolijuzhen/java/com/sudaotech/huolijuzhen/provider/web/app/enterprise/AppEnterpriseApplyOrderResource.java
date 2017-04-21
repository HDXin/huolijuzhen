package com.sudaotech.huolijuzhen.provider.web.app.enterprise;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.enums.LabelType;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.payment.domain.PaymentConstants;
import com.sudaotech.huolijuzhen.payment.domain.TradeREQ;
import com.sudaotech.huolijuzhen.payment.domain.TradeRESP;
import com.sudaotech.huolijuzhen.payment.service.PaymentService;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService.ApplyLabel;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.FindCondition;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService.OrderTemplate;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService;
import com.sudaotech.huolijuzhen.provider.service.ServiceCommentService.ServiceComment;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.huolijuzhen.util.Arith;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;

@Path("/app/enterprise/applyOrder")
public class AppEnterpriseApplyOrderResource extends BusinessBaseResource {

    @Inject
    private ApplyOrderService applyOrderService;
    
    @Inject
    private ServiceProjectService serviceProjectService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private ProviderService providerService;
    
    @Inject
    private AreaService areaService;
    
    @Inject
    private OrderTemplateService orderTemplateService;
    
    @Inject
    private ServiceCommentService serviceCommentService;
    
    @Inject
    private PaymentService paymentService; 
    
    @Inject
    private ApplyLabelService applyLabelService;
    
    /**
     * 提交申请单
     * @param id
     * @param approvalItem
     * @return
     */
    @POST
    @Path("/apply/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> apply(@Valid final ApplyOrder applyOrder) {
    	
    	try{
    		
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String, Object>>(ResultCode.SESSION_IS_NULL);
    		}
    		//服务项目 ID 不能为空
    		Long serviceProId = applyOrder.getServiceProId();
    		if(serviceProId == null){
    			return new Result<Map<String,Object>>(ResultCode.ITEM_ID_IS_NULL);
    		}
    		//服务项目不能为空
    		ServiceProject serviceProject = serviceProjectService.getById(serviceProId);
    		if(serviceProject == null){
    			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND_ITEM);
    		}
    		//申请单与版本对应
    		applyOrder.setServiceProRelease(serviceProject.getReleases());

    		
    		Long userId = session.getUserId();
    		AdminUser user = adminUserService.getById(userId);
    		
    		Long enterpriseId = user.getPlatformSourceId();
    		EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(enterpriseId);
    		
    		applyOrder.setEnterpriseId(enterpriseId);
    		applyOrder.setEnterpriseName(enterpriseInfo.getName());

    		applyOrder.setApplyOrderStatus(ApplyOrderStatus.APPLYWAITEXECUTOR);
    		applyOrder.setApplyOrderType(ApplyOrderType.APPLY);
    		
    		applyOrder.setOperator(userId);
    		applyOrder.setApplyOrderNo(createApplyOrderNo("02"));
    		
    		//1.保存申请单详情
    		Long id = applyOrderService.create(applyOrder);
    		List<ApplyLabel> applyLabelItemList = applyOrder.getApplyLabelItems();
    		if(CollectionUtils.isNotEmpty(applyLabelItemList)){
    			ApplyLabel temp = null;
    			for(ApplyLabel applyLabel:applyLabelItemList){
    				temp = new ApplyLabel();
    				
    				temp.setApplyOrderId(id);
    				temp.setLabelHint(applyLabel.getLabelHint());
    				temp.setLabelNo(applyLabel.getLabelNo());
    				LabelType labelType = applyLabel.getLabelType();
    				temp.setLabelType(labelType);
    				temp.setName(applyLabel.getName());
    				String value = applyLabel.getValue();
    				if(LabelType.FILE.equals(labelType) && StringUtils.isNotBlank(value)){
        				temp.setValue(HuolijuzhenConfig.getInstance().getImagePre() + value);
    				}else{
    					temp.setValue(value);
    				}
    				temp.setOperator(userId);
    				applyLabelService.create(temp);
    			}
    		}
    		
    		//2.更新服务项目申请单订单数
    		updateServiceProject(applyOrder);
    		
    		Map<String, Object> dataMap = new HashMap<String, Object>();
    		dataMap.put("id", id);
    		dataMap.put("applyOrderNo", applyOrder.getApplyOrderNo());
    		return new Result<Map<String, Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("app 提交申请单 error:{}",e);
    		return new Result<Map<String, Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    	
    }
    
    /**
     * 提交订单
     * @param id
     * @param approvalItem
     * @return
     */
    @POST
    @Path("/order/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> order(@Valid final ApplyOrder applyOrder) {
    	
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String, Object>>(ResultCode.SESSION_IS_NULL);
    		}
    		//服务项目 ID 不能为空
    		Long serviceProId = applyOrder.getServiceProId();
    		if(serviceProId == null){
    			return new Result<Map<String,Object>>(ResultCode.ITEM_ID_IS_NULL);
    		}
    		//服务项目不能为空
    		ServiceProject serviceProject = serviceProjectService.getById(serviceProId);
    		if(serviceProject == null){
    			return new Result<Map<String,Object>>(ResultCode.NOT_FOUND_ITEM);
    		}
    		//申请单与版本对应
    		applyOrder.setServiceProRelease(serviceProject.getReleases());
    	
    		Long userId = session.getUserId();
    		AdminUser user = adminUserService.getById(userId);
    		
    		Long enterpriseId = user.getPlatformSourceId();
    		EnterpriseInfo enterpriseInfo = enterpriseInfoService.getById(enterpriseId);
    		
    		applyOrder.setEnterpriseId(enterpriseId);
    		applyOrder.setEnterpriseName(enterpriseInfo.getName());
    		
    		applyOrder.setApplyOrderStatus(ApplyOrderStatus.WAITPAY);
    		applyOrder.setApplyOrderType(ApplyOrderType.ORDER);
    		
    		applyOrder.setOperator(userId);
    		applyOrder.setApplyOrderNo(createApplyOrderNo("01"));
    		Long id = applyOrderService.create(applyOrder);
    		
    		//2.更新服务项目申请单订单数
    		updateServiceProject(applyOrder);
    		
    		Map<String, Object> dataMap = new HashMap<String, Object>();
    		dataMap.put("id", id);
    		dataMap.put("applyOrderNo", applyOrder.getApplyOrderNo());
    		return new Result<Map<String, Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("app 提交订单 error:{}",e);
    		return new Result<Map<String, Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 取消订单
     * @param id
     * @param approvalItem
     * @return
     */
    @PUT
    @Path("/cancel/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> order(@PathParam("id") Long id) {
    	
    	try{
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String, Object>>(ResultCode.SESSION_IS_NULL);
    		}

    		Long userId = session.getUserId();
    		ApplyOrder applyOrder = new ApplyOrder();
    		
    		applyOrder.setId(id);
    		applyOrder.setApplyOrderStatus(ApplyOrderStatus.CANCEL);
    		applyOrder.setOperator(userId);

    		//1.更新订单状态
    		applyOrderService.update(applyOrder);
    		
    		//2.更新服务项目申请单订单数
    		updateServiceProject(applyOrder);
    		
    		return new Result<Map<String, Object>>(ResultCode.OK);
    	}catch(Exception e){
    		logger.error("app 提交订单 error:{}",e);
    		return new Result<Map<String, Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 获取订单、申请单详情
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{

    		Map<String, Object> dataMap = new HashMap<String, Object>();
            ApplyOrder applyOrder = applyOrderService.getById(id);
            if(applyOrder != null){
                dataMap.putAll(packItemInfo(applyOrder));
            }
            
            return new Result<Map<String, Object>>(ResultCode.OK, dataMap);
    		
    	}catch(Exception e){
    		logger.error("平台根据 ID 获取申请单、订单详情 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     * 更新服务服务项目的申请单订单数
     * @param applyOrder
     */
    private void updateServiceProject(ApplyOrder applyOrder){
    	Integer applyOrderNum = applyOrderService.findApplyOrderCount(applyOrder.getServiceProId());
		ServiceProject serviceProject = new ServiceProject();
		serviceProject.setId(applyOrder.getServiceProId());
		serviceProject.setApplyOrderNum(applyOrderNum);

    	serviceProject.setOperator(getSessionQuietly().getUserId());
		serviceProjectService.update(serviceProject);
    }

    /**
     * 多条件查询
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
            @QueryParam("applyOrderType") String applyOrderTypeStr) {
    	try{
    		
    		FindCondition findCondition = new FindCondition();
    		
    		Session session = getSessionQuietly();
    		if(session == null){
    			return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
    		}
    		
    		Long userId = session.getUserId();
    		AdminUser user = adminUserService.getById(userId);
    		
    		Long enterpriseId = user.getPlatformSourceId();
    		findCondition.setEnterpriseId(enterpriseId);
    		
    		findCondition.setOffset(offset);
    		findCondition.setLimit(limit);
    		findCondition.setPage(pageNum);
    		
    		if(StringUtils.isNotBlank(applyOrderTypeStr)){
        		ApplyOrderType applyOrderType = ApplyOrderType.valueOf(applyOrderTypeStr);
        		findCondition.setApplyOrderType(applyOrderType);
    		}
    		
    		Page<ApplyOrder> page = applyOrderService.findAllOfEnterprise(findCondition);
    		Map<String, Object> dataMap = packPageInfo(page);
            return new Result<Map<String,Object>>(ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("平台按条件查询申请单、订单 error:{}",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /**
     *        获取支付串
     * @param orderId
     *        订单Id
     * @param payWay
     *        支付方式
     * @return
     */
    @GET
    @Path("/tradeOrder")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> tradeOrder(@QueryParam("orderId") Long orderId,
    	                             	          @QueryParam("payWay") PayWay payWay){
    	
	      try{
	    		
	    	  if( orderId ==null || payWay == null ){
	        	  return new Result<Map<String, Object>>(ResultCode.BAD_REQUEST);
	          }
	    	  
	    	  //获取订单信息
	    	  ApplyOrder ao = applyOrderService.getById(orderId) ;
	    	  if(ao == null){
	    		  return new Result<Map<String, Object>>(ResultCode.NOT_FOUND);
	    	  }
	  	      //订单状态校验为 未支付状态
	  	      if(ao.getApplyOrderStatus() != ApplyOrderStatus.WAITPAY){
	  	    	
	  	          return new Result<Map<String, Object>>(ResultCode.APPLYORDER_UPDATE_ERROR);
	  	      }
	    	  
	          TradeREQ req=new TradeREQ();
	          req.setOrder_no(ao.getApplyOrderNo());
	          //交易金额
	          req.setAmount(Arith.round(Arith.mul(ao.getPrice().toString(),"100"),0));  
	          req.setSubject("订单支付付款");
	          req.setBody("订单支付付款");
	          req.setClientIp("");
	          
		  	  if(payWay == PayWay.ALIPAY){  //支付宝支付
		          req.setChannel(PaymentConstants.Channel.ALIPAY);
		  	  }
		      if(payWay == PayWay.WECHATPAY){  //微信支付
		          req.setChannel(PaymentConstants.Channel.WX);
		  	  }
		      
 		      TradeRESP resp=paymentService.tradeOrder(req);
 		      
 		      if(resp !=null ){
 		    	 Result<Map<String, Object>> result = new Result<Map<String, Object>>(ResultCode.OK);
 		         Map<String, Object> map =new HashMap<String, Object>();
 		         map.put("result",resp.getCredential());
 		         result.setData(map);
 		         return result;
			  }
 		      
		    } catch (Exception e) {
			 	logger.error("交易异常{}"+e);
			 	return  new Result<Map<String, Object>>(ResultCode.INTERNAL_SERVER_ERROR);
			}
	      
	      return new Result<Map<String, Object>>(ResultCode.OK,null);
    	
    }
    
    
    /**
     * 分装返回结果
     * @return
     */
    private Map<String, Object> packPageInfo(Page<ApplyOrder> page){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	dataMap.put("offset", page.getOffset());
    	dataMap.put("limit", page.getLimit());
    	dataMap.put("total", page.getTotal());
    	dataMap.put("sortField", page.getSortField());
    	dataMap.put("sortOrder", page.getSortOrder());
    	
    	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
    	
    	List<ApplyOrder> list = page.getItems();
    	if(CollectionUtils.isNotEmpty(list)){
    		Map<String, Object> itemMap = null;
    		for(ApplyOrder item:list){
    			itemMap = new HashMap<String, Object>();
    			
    			itemMap.put("id", item.getId());
    			itemMap.put("createTime", sdf.format(item.getCreateTime()));
    			itemMap.put("applyOrderStatus", notNull(item.getApplyOrderStatus()));
    			itemMap.put("applyOrderStatusMemo", notNull(item.getApplyOrderStatusMemo()));
    			itemMap.put("applyOrderNo", notNull(item.getApplyOrderNo()));
    			itemMap.put("price", item.getPrice());
    			itemMap.putAll(packListInfo(item));
    			
    			items.add(itemMap);
    		}
    	}
    	
    	dataMap.put("items", items);
    	return dataMap;
    }
    
    /**
     * 获取订单信息
     * @param applyOrder
     * @return
     */
    private Map<String,Object> packListInfo(ApplyOrder applyOrder){
    	Map<String, Object> infoMap = new HashMap<String, Object>();
    	
    	infoMap.put("mainTitle", "");
		infoMap.put("subTitle", "");
		infoMap.put("mainImage", new ArrayList<String>());
		infoMap.put("proPrice", 0);
		infoMap.put("addr", "");
		ServiceProject serviceProject = getValidServiceProject(applyOrder);
        if(serviceProject == null){
        	return infoMap;
    	}
		
		infoMap.put("mainTitle", notNull(serviceProject.getMainTitle()));
		infoMap.put("subTitle", notNull(serviceProject.getSubTitle()));
		
		//主图
		List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.SERVICE_MAIN,serviceProject.getId());
		infoMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		infoMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}
    	
    	ServiceGrade serviceGrade = serviceProject.getServiceGrade();
    	if(ServiceGrade.PLATFORMSELF.equals(serviceGrade)){
    		infoMap.put("addr", "平台自营项目");
    	}else if(ServiceGrade.PARKSELF.equals(serviceGrade)){
    		Long parkId = serviceProject.getParkId();
    		ParkInfo parkInfo = parkInfoService.getById(parkId);
    		
    		Long cityId = parkInfo.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));

    		Long counId = parkInfo.getRegionId();
    		Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		
    		infoMap.put("addr", city.getName() + "." + country.getName());

    	}else if(ServiceGrade.PARKSERVICE.equals(serviceGrade) || ServiceGrade.PLATFORMSERVICE.equals(serviceGrade)){

    		Long providerId = serviceProject.getServiceGradeId();
    		Provider provider = providerService.getById(providerId);
    		
    		Long cityId = provider.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
    		
    		Long counId = provider.getCounId();
    		Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		
    		infoMap.put("addr", city.getName() + "." + country.getName());
    	}
    	
    	//是否支持订单
    	Boolean supportOrder = serviceProject.getSupportOrder();
    	infoMap.put("supportOrder", notNull(supportOrder));
		if(!supportOrder){
			return infoMap;
		}
		
		Long orderViewId = serviceProject.getOrderViewId();
    	OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
    	if(orderTemplate == null){
    		return infoMap;
    	}
    	
    	//服务项目价格
    	Double proPrice = orderTemplate.getPriceOne();
    	infoMap.put("proPrice", notNull(proPrice));
    	
    	return infoMap;
    }
    
    
    public Map<String, Object> packItemInfo(ApplyOrder applyOrder){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	ApplyOrderType applyOrderType = applyOrder.getApplyOrderType();
    	dataMap.put("applyOrderType", notNull(applyOrderType));
    	dataMap.put("applyContent", new ArrayList<Map<String, Object>>());
    	if(ApplyOrderType.APPLY.equals(applyOrderType)){
    		List<ApplyLabel> applyLabels = applyLabelService.findAllByApplyOrderId(applyOrder);
    		//更新申请标签的文件路径
    		updateValue(applyLabels);
    		if(CollectionUtils.isNotEmpty(applyLabels)){
    			dataMap.put("applyContent", applyLabels);
    		}
    		
    	}
    	
    	dataMap.put("applyOrderId", applyOrder.getId());
    	dataMap.put("createTime", sdf.format(applyOrder.getCreateTime()));
    	dataMap.put("applyOrderNo", notNull(applyOrder.getApplyOrderNo()));
    	BigDecimal  orderPrice = applyOrder.getPrice();
    	dataMap.put("orderPrice", 0);
    	if(orderPrice != null){
        	dataMap.put("orderPrice", orderPrice);
    	}
    	dataMap.put("orderMemo", notNull(applyOrder.getOrderMemo()));
    	dataMap.put("commentText", "");
		dataMap.put("gradeNum", 0);
    	ApplyOrderStatus applyOrderStatus = applyOrder.getApplyOrderStatus();
    	dataMap.put("applyOrderStatus", notNull(applyOrderStatus));
    	dataMap.put("applyOrderStatusMemo", notNull(applyOrder.getApplyOrderStatusMemo()));
    	
    	if(ApplyOrderStatus.FINISH.equals(applyOrderStatus)){
    		Long commentId = applyOrder.getCommentId();
    		ServiceComment serviceComment = serviceCommentService.getById(commentId);
    		if(serviceComment != null){
        		dataMap.put("commentText", serviceComment.getCommentText());
        		dataMap.put("gradeNum", notNull(serviceComment.getGradeNum()));
    		}
    	}
    	
    	//获取对应版本的服务项目的信息
        dataMap.put("serviceProId", 0);
        dataMap.put("mainTitle", "");
        dataMap.put("mainImagePath", new ArrayList<String>());
        dataMap.put("proPrice", 0);
        dataMap.put("addr", "");
        dataMap.put("supportOrder", false);
        ServiceProject serviceProject = getValidServiceProject(applyOrder);
        if(serviceProject == null){
        	return dataMap;
    	}
        
		dataMap.put("serviceProId", notNull(serviceProject.getId()));
		dataMap.put("mainTitle", notNull(serviceProject.getMainTitle()));

		List<ImageInfo> mainImageInfos = imageInfoService.findAllByImageTypeAndTargetId(ImageType.SERVICE_MAIN,serviceProject.getId());
		dataMap.put("mainImage", new ArrayList<Map<String, Object>>());
    	if(CollectionUtils.isNotEmpty(mainImageInfos)){
    		dataMap.put("mainImage", imageInfoListToMap(mainImageInfos));
    	}
    	
    	ServiceGrade serviceGrade = serviceProject.getServiceGrade();
    	if(ServiceGrade.PLATFORMSELF.equals(serviceGrade)){
    		dataMap.put("addr", "平台自营项目");
    	}else if(ServiceGrade.PARKSELF.equals(serviceGrade)){
    		Long parkId = serviceProject.getParkId();
    		ParkInfo parkInfo = parkInfoService.getById(parkId);
    		
    		Long cityId = parkInfo.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));

    		Long counId = parkInfo.getRegionId();
    		Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		
    		dataMap.put("addr", city.getName() + "." + country.getName());

    	}else if(ServiceGrade.PARKSERVICE.equals(serviceGrade) || ServiceGrade.PLATFORMSERVICE.equals(serviceGrade)){

    		Long providerId = serviceProject.getServiceGradeId();
    		Provider provider = providerService.getById(providerId);
    		
    		Long cityId = provider.getCityId();
    		Area city = areaService.getByAreaId(Integer.parseInt(cityId.toString()));
    		
    		Long counId = provider.getCounId();
    		Area country = areaService.getByAreaId(Integer.parseInt(counId.toString()));
    		
    		dataMap.put("addr", city.getName() + "." + country.getName());
    	}
    	
    	//是否支持订单
    	Boolean supportOrder = serviceProject.getSupportOrder();
    	dataMap.put("supportOrder", notNull(supportOrder));
		if(!supportOrder){
			return dataMap;
		}
		Long orderViewId = serviceProject.getOrderViewId();
    	OrderTemplate orderTemplate = orderTemplateService.getById(orderViewId);
    	if(orderTemplate == null){
    		return dataMap;
    	}
    	
    	//服务项目价格
    	Double proPrice = orderTemplate.getPriceOne();
    	dataMap.put("proPrice", notNull(proPrice));
    	
        return dataMap;
    }
    
}
