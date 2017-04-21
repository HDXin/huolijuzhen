package com.sudaotech.shipping.web;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.shipping.kuaidu100.NoticeRequest;
import com.sudaotech.shipping.kuaidu100.NoticeResponse;
import com.sudaotech.shipping.kuaidu100.NoticeResult;
import com.sudaotech.shipping.service.Shipping;
import com.sudaotech.shipping.service.ShippingService;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.HttpUtils;
import com.sudaotech.util.JsonUtil;

@Path("/kuaidi100")
public class ShippingKuaidi100Resource extends BaseResource {

	@Inject
	private ShippingService shippingService;
	
    @POST
    @Path("/notify")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaTypeExt.TEXT_HTML)
    public String Kuaidi100Callback(String body) {
    	logger.debug("Kuaidu100 notify callback: Received {}", body);
		NoticeResponse resp = new NoticeResponse();
		try {
			Map<String,String> params = HttpUtils.parseQueryParams(body);
			String json = params.get("param");
			NoticeRequest info = JsonUtil.fromJson(json, NoticeRequest.class);
			logger.debug("Kuaidu100 notify callback: get notice {}", info);
			// 处理快递结果
			saveShippingInfo(info.getLastResult());

			// 返回结果
			resp.setResult(true);
			resp.setReturnCode("200");
			resp.setMessage("成功");
		} catch (Exception e) {
			logger.error("Kuaidu100 notify callback: failed to handle result", e);
			resp.setResult(false);
			resp.setReturnCode("500");
			resp.setMessage("保存失败");
		}
		logger.debug("Kuaidu100 notify callback: return result {}", resp);
    	return JsonUtil.toJsonQuietly(resp);
    }
    
    private void saveShippingInfo(NoticeResult vo) {
    	// 查找以前的记录
    	String shippingNum = vo.getNu();
    	Shipping shipping = this.shippingService.getShippingByNum(shippingNum, null);
    	logger.debug("Kuaidu100 notify callback: Get shipping by number {}, result {}", shippingNum, shipping);
    	if (shipping == null) {
    		// 如果没有就添加
    		shipping = new Shipping();
    		shipping.setShippingNo(shippingNum);
    		shipping.setState(vo.getState());
    		shipping.setJson(JsonUtil.toJsonQuietly(vo));
    		
    		this.shippingService.createShipping(shipping, getSession());
    		logger.debug("Kuaidu100 notify callback: Created shipping by number {}, result {}", shippingNum, shipping);
    	} else {
    		// 如果有就修改保存
    		shipping.setState(vo.getState());
    		shipping.setJson(JsonUtil.toJsonQuietly(vo));
    		
    		this.shippingService.updateShipping(shipping, getSession());
    		logger.debug("Kuaidu100 notify callback: Updated shipping by number {}, result {}", shippingNum, shipping);
    	}
    	
    }
    
    @POST
    @Path("/poll")
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> postOrder(Shipping shipping) {
    	logger.debug("Kuaidu100 post order ... {}", shipping);
    	
    	boolean success = this.shippingService.postOrderOnKuaide100(shipping);

    	if (success) {
    		logger.debug("Kuaidu100 post order: OK {}", shipping);
    		return ResultSupport.ok();
    	} else {
    		logger.debug("Kuaidu100 post order: Failed {}", shipping);
    		return ResultSupport.serverError();
    	}
    	
    }
    
    
    @POST
    @Path("/patchshipping")
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> create(Shipping vo) {
    	logger.debug("Patch shipping... {}", vo);
    	Session session = getSession();
    	if (session.getUserId() == 0 || vo == null ||
    			vo.getShippingCompanyId() == null ||
    			vo.getShippingNo() == null ||
    			vo.getShippingFrom() == null ||
    			vo.getShippingTo() == null) {
    		return new Result<String>(ResultCode.BAD_REQUEST);
    	}
    	
    	this.shippingService.createShipping(vo, session, true);
    	logger.debug("Patch shipping... {}", vo);
    	
    	return ResultSupport.ok();
    }
    
    @GET
    @Path("/{number}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<ShippingInfoVo> getSaleOrderShippingInfo(@PathParam("number") String number) {
        logger.debug("Getting SaleOrder ShippingInfo by number: {}", number);
        Session session = getSession();
        if (session.getUserId() == 0) {
        	return new Result<ShippingInfoVo>(ResultCode.BAD_REQUEST);
        }
        
        //number = "880145356025117466";
        Shipping shipping = this.shippingService.getShippingByNum(number, session);
        
        ShippingInfoVo shippingVo = null;
        if (shipping.getJson() != null) {
        	shippingVo = JsonUtil.fromJsonQuietly(shipping.getJson(), ShippingInfoVo.class);
        	BeanUtils.copyProperties(shipping, shippingVo);
        } else {
        	shippingVo = BeanUtils.copyProperties(shipping, ShippingInfoVo.class);
        }
        
    	logger.debug("Getting SaleOrder ShippingInfo {} OK, {}", number, shippingVo);
    	
        return new Result<ShippingInfoVo>(ResultCode.OK, shippingVo);
    }
    
//    private Shipping getTestShipping() {
//    	Shipping shipping  = new Shipping();
//    	shipping.setShippingCompanyId("yuantong");
//    	shipping.setShippingNo("880145356025117466");
//    	shipping.setShippingFrom("广东省深圳市");
//    	shipping.setShippingTo("广东省广州市");
//    	return shipping;
//    }
}
