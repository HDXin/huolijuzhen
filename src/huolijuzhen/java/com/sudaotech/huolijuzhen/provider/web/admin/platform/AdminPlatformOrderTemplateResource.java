package com.sudaotech.huolijuzhen.provider.web.admin.platform;

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

import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService;
import com.sudaotech.huolijuzhen.provider.service.OrderTemplateService.OrderTemplate;
import com.sudaotech.util.MapHelper;

@Path("/admin/platform/orderTemplate")
public class AdminPlatformOrderTemplateResource extends BaseResource {

    @Inject
    private OrderTemplateService orderTemplateService;
    
    /**
     * 创建订单模板
     * @param obj
     * @return
     */
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final OrderTemplate obj) {
    	
    	try{
    		//1.提取表单信息
    		OrderTemplate temp = extractValidInfo(obj);
            // create
            temp.setOperator(getSessionQuietly().getUserId());
            Long id = orderTemplateService.create(temp);
            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/orderTemplate/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("平台添加服务项目订单模板 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 编辑订单模板
     * @param id
     * @param obj
     * @return
     */
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final OrderTemplate obj) {
    	try {
    		//1.提取表单信息
    		OrderTemplate temp = extractValidInfo(obj);
    		
            temp.setId(id);
            temp.setOperator(getSessionQuietly().getUserId());
            orderTemplateService.update(temp);
            return ResultSupport.ok();
			
		} catch (Exception e) {
			logger.error("品台编辑服务项目的订单模板 error:{}",e);
			return new Result<String>(ResultCode.INTERNAL_SERVER_ERROR);
		}
    }

    /**
     * 根据 ID 获取服务项的订单模板信息
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String,Object>> get(@NotNull @PathParam("id") final Long id) {
    	try{
            OrderTemplate obj = orderTemplateService.getById(id);
            Map<String, Object> dataMap = null;
            if(obj != null){
            	dataMap = packItemInfo(obj);
            }
            return new Result<Map<String,Object>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK,dataMap);
    	}catch(Exception e){
    		logger.error("平台活动服务项目模板信息",e);
    		return new Result<Map<String,Object>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    /**
     * 提取有效信息
     * @param temp
     * @return
     */
    private OrderTemplate extractValidInfo(OrderTemplate temp){
    	OrderTemplate obj = new OrderTemplate();
    	
	    obj.setSupportAliPay(temp.getSupportAliPay());
	    obj.setSupportWeChatPay(temp.getSupportWeChatPay());
	    
	    obj.setPriceTitleOne(temp.getPriceTitleOne());
	    obj.setPriceOne(temp.getPriceOne());
	    obj.setPriceTitleTwo(temp.getPriceTitleTwo());
	    obj.setPriceTwo(temp.getPriceTwo());
	    obj.setPriceTitleThree(temp.getPriceTitleThree());
	    obj.setPriceThree(temp.getPriceThree());
	    
	    obj.setDiscountTitleOne(temp.getDiscountTitleOne());
	    obj.setDiscountOne(temp.getDiscountOne());
	    obj.setDiscountTitleTwo(temp.getDiscountTitleTwo());
	    obj.setDiscountTwo(temp.getDiscountTwo());
	    obj.setDiscountTitleThree(temp.getDiscountTitleThree());
	    obj.setDiscountThree(temp.getDiscountThree());
    	
    	return obj;
    }
    
    /**
     * 封装元素详情信息到 Map 中
     * @param comm
     * @return
     */
    private Map<String, Object> packItemInfo(OrderTemplate item){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("id", item.getId());
    	infoMap.put("supportAliPay", item.getSupportAliPay());
    	infoMap.put("supportWeChatPay", item.getSupportWeChatPay());
    	
    	infoMap.put("priceTitleOne", notNull(item.getPriceTitleOne()));
    	infoMap.put("pricesOne", notNull(item.getPriceOne()));
    	infoMap.put("priceTitleTwo", notNull(item.getPriceTitleTwo()));
    	infoMap.put("pricesTwo", notNull(item.getPriceTwo()));
    	infoMap.put("priceTitleThree", notNull(item.getPriceTitleThree()));
    	infoMap.put("pricesThree", notNull(item.getPriceThree()));
    	
    	infoMap.put("discountTitleOne", notNull(item.getDiscountTitleOne()));
    	infoMap.put("discountsOne", notNull(item.getDiscountOne()));
    	infoMap.put("discountTitleTwo", notNull(item.getDiscountTitleTwo()));
    	infoMap.put("discountsTwo", notNull(item.getDiscountTwo()));
    	infoMap.put("discountTitleThree", notNull(item.getDiscountTitleThree()));
    	infoMap.put("discountsThree", notNull(item.getDiscountThree()));

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
