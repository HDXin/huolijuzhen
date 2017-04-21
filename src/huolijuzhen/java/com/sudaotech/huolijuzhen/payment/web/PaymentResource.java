package com.sudaotech.huolijuzhen.payment.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.PayChannels;
import com.sudaotech.huolijuzhen.enums.PayWay;
import com.sudaotech.huolijuzhen.enums.SuccessOrFailEnums;
import com.sudaotech.huolijuzhen.enums.TransDirectionType;
import com.sudaotech.huolijuzhen.enums.TransactionType;
import com.sudaotech.huolijuzhen.payment.alipay.util.AlipayNotify;
import com.sudaotech.huolijuzhen.payment.domain.PaymentConstants;
import com.sudaotech.huolijuzhen.payment.util.GsonUtils;
import com.sudaotech.huolijuzhen.payment.weixin.vo.NotificationResult;
import com.sudaotech.huolijuzhen.payment.weixin.vo.NotificationVo;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;
import com.sudaotech.huolijuzhen.transaction.service.TransactionRecordService;
import com.sudaotech.huolijuzhen.transaction.service.TransactionRecordService.TransactionRecord;
import com.sudaotech.huolijuzhen.util.Arith;

@Path("/pay")
public class PaymentResource extends BaseResource {
	
	@Inject
	ApplyOrderService applyOrderService;
	
	@Inject
	TransactionRecordService transactionRecordService;
	
	
    @SuppressWarnings("unchecked")
	@POST
    @Path("/payNotify")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public String paynotify(String body,@Context HttpServletRequest request){
    	
    	//----------交易业务类别
    	String subject = null;
    	
    	//----------订单号
    	String orderNo = null;
    	
    	//----------交易金额
    	Double amount = null;
    	
    	//----------交易方式
    	String channel = null;
    	
    	try {
    		
    		logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<来自支付中间件的回调：{}",body);
    		
        	Map<String ,Object> rtns=(Map<String,Object>)GsonUtils.GSON_NO_NULL.fromJson(body, Map.class);
        	if(PaymentConstants.Notify.CHARGE_SUCCESSFUL.equals(rtns.get("type"))){
        		Object order = ((Map<String,Object>) rtns.get("data")).get("object");
        		orderNo = (String) ((Map<String,Object>) order).get("orderNo");
        		subject=(String) ((Map<String,Object>) order).get("subject");
        		amount=(Double) ((Map<String,Object>)  order).get("amount");
        		channel=(String) ((Map<String,Object>) order).get("channel");
        		
        	}
        	if(StringUtils.isBlank(orderNo)){
        		logger.error("[[[[[[调结果没有找到订单号:{}]]]]]]",body);
        		return PaymentConstants.Notify.PAYMENT_FAIL;
        	}
			
    	
    	//处理业务逻辑
		ApplyOrder ao =applyOrderService.findByApplyOrderNo(orderNo);
		if(ao !=null && ao.getApplyOrderStatus() != ApplyOrderStatus.FINISH){
			Long id=ao.getId();
			ao=new ApplyOrder();
			ao.setId(id);
			if(channel.equals(PayChannels.ALIPAY.name().toLowerCase())){
				ao.setPayWay(PayWay.ALIPAY);
			}
			if(channel.equals(PayChannels.WX.name().toLowerCase())){
				ao.setPayWay(PayWay.WECHATPAY);
			}
			
			ao.setApplyOrderStatus(ApplyOrderStatus.ORDERWAITEXECUTOR);
			applyOrderService.update(ao);
			
			TransactionRecord tr=new TransactionRecord();
			tr.setTransactionTime(new Date());
			tr.setTransactionAmount(new BigDecimal(amount));                           //交易金额
			tr.setPayChannel(PayChannels.codeOf(channel.toUpperCase()));               //交易方式：
			tr.setTransactionDirection(TransDirectionType.UN_CHECK);                   //交易方向：支出
			tr.setTransactionType(TransactionType.APPLYORDER_PAY);                     //交易类型：服务订单
			tr.setTransactionStatus(SuccessOrFailEnums.SUCCESS);                       //交易状态：成功
			//tr.setBuyerEmail(buyer_email);
			//tr.setBuyerId(buyer_id);
			//tr.setTradeNo(trade_no);                                                 //第三方支付交易号
			tr.setOrderNo(orderNo);                                                    //业务订单号
			tr.setBizId(ao.getId().toString());                                        //业务订单
			
			transactionRecordService.create(tr);
		}
		
    	} catch (Exception e) {
			logger.error("[[[[[[回调异常:{}]]]]]]",e);
			return PaymentConstants.Notify.PAYMENT_FAIL;
		}
		return PaymentConstants.Notify.PAYMENT_SUCCESS;
    	
    }
    
    @SuppressWarnings("unchecked")
  	@POST
    @Path("/weixinPayNotify")
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.TEXT_XML)
    @Transactional
    public NotificationResult weixinPayNotify(NotificationVo notification) {  
    	
    	logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<来自微信的回调：");
    	NotificationResult result = new NotificationResult();
    	
    	try {
          
            //处理业务开始  
	        if("SUCCESS".equals(notification.getResult_code())){  
	            String mch_id = notification.getMch_id();
	            String is_subscribe = notification.getIs_subscribe();
	            String openid = notification.getOpenid();
	            String out_trade_no = notification.getOut_trade_no();
	            String total_fee = notification.getTotal_fee();
	            String transaction_id=notification.getTransaction_id();
				//业务处理
				ApplyOrder ao =applyOrderService.findByApplyOrderNo(out_trade_no);
				if(ao !=null && ao.getApplyOrderStatus() != ApplyOrderStatus.FINISH){
					ao.setApplyOrderNo(out_trade_no);
					ao.setPayWay(PayWay.WECHATPAY);
					ao.setApplyOrderStatus(ApplyOrderStatus.ORDERWAITEXECUTOR);
					applyOrderService.update(ao);
					
					TransactionRecord tr=new TransactionRecord();
					tr.setTransactionTime(new Date());
					tr.setTransactionAmount(new BigDecimal(total_fee));                        //交易金额
					tr.setPayChannel(PayChannels.WX);                                          //交易方式：微信
					tr.setTransactionDirection(TransDirectionType.UN_CHECK);                   //交易方向：支出
					tr.setTransactionType(TransactionType.APPLYORDER_PAY);                     //交易类型：服务订单
					tr.setTransactionStatus(SuccessOrFailEnums.SUCCESS);                       //交易状态：成功
					//tr.setBuyerEmail(buyer_email);                                           //第三方支付账号
					tr.setBuyerId(openid);
					tr.setTradeNo(transaction_id);                                             //第三方支付交易号
					tr.setOrderNo(out_trade_no);                                               //业务订单号
					tr.setBizId(ao.getId().toString());                                        //业务订单
					
					transactionRecordService.create(tr);
				}
				
				logger.info("[[[[[[支付成功]]]]]]"); 
	            //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.  
	    		result.setReturn_code("SUCCESS");
	    		result.setReturn_msg("OK");
	    		
	         }else{  
	                logger.info("[[[[[[支付失败,错误信息：{}]]]]]]",notification.getErr_code());  
	            	result.setReturn_code("FAIL");
	        		result.setReturn_msg("支付失败");
	         }  
		
		} catch (Exception e) {
			
			logger.info("[[[[[[支付失败,异常信息：{}]]]]]]",e);  
          	result.setReturn_code("FAIL");
      		result.setReturn_msg("支付失败");
		}
            
        return result;
          
    }  
    
     @SuppressWarnings("unchecked")
     @POST
     @Path("/aliPayNotify")
     @Produces(MediaType.TEXT_PLAIN)
     @Transactional
     public String aliPayNotify(@Context HttpServletRequest request){ 
    	 
    	logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<来自支付宝的回调：");
		
        try {
	    	
	    	//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
				params.put(name, valueStr);
			}
			
			logger.info("[[[[[[支付宝回调参数：{}]]]]]]",params.toString());
	
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号
			String trade_no     = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			//买家支付宝账号
			String buyer_email  = new String(request.getParameter("buyer_email").getBytes("ISO-8859-1"),"UTF-8");
		    //买家支付账户号
			String buyer_id     = new String(request.getParameter("buyer_id").getBytes("ISO-8859-1"),"UTF-8");	
			//交易金额
			String total_fel    = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
			
			String msg="";
			if(AlipayNotify.verify(params)){//验证成功
				
				if(trade_status.equals("TRADE_FINISHED")){
					//判断该笔订单是否在商户网站中已经做过处理
				    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
					//注意：
					//该种交易状态只在两种情况下出现
					//1、开通了普通即时到账，买家付款成功后。
					//2、开通了高级即时到账，从该笔交易成功时间算起，过了签约时的可退款时限（如：三个月以内可退款、一年以内可退款等）后。
					msg=PaymentConstants.Notify.PAYMENT_SUCCESS;;	
					//请不要修改或删除
				} else if (trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
				    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
					//注意：
					//该种交易状态只在一种情况下出现——开通了高级即时到账，买家付款成功后。
					msg=PaymentConstants.Notify.PAYMENT_SUCCESS;;	
				}
				
			}
			
			if(msg.equals(PaymentConstants.Notify.PAYMENT_SUCCESS)){
				
				//业务处理
				ApplyOrder ao =applyOrderService.findByApplyOrderNo(out_trade_no);
				if(ao !=null && ao.getApplyOrderStatus() != ApplyOrderStatus.FINISH){
					ao.setApplyOrderNo(out_trade_no);
					ao.setPayWay(PayWay.ALIPAY);
					ao.setApplyOrderStatus(ApplyOrderStatus.ORDERWAITEXECUTOR);
					applyOrderService.update(ao);
					
					TransactionRecord tr=new TransactionRecord();
					tr.setTransactionTime(new Date());
					tr.setTransactionAmount(new BigDecimal(Arith.mul(total_fel,"100")));                        //交易金额
					tr.setPayChannel(PayChannels.ALIPAY);                                      //交易方式：支付宝
					tr.setTransactionDirection(TransDirectionType.UN_CHECK);                   //交易方向：支出
					tr.setTransactionType(TransactionType.APPLYORDER_PAY);                     //交易类型：服务订单
					tr.setTransactionStatus(SuccessOrFailEnums.SUCCESS);                       //交易状态：成功
					tr.setBuyerEmail(buyer_email);                                             //第三方支付账号
					tr.setBuyerId(buyer_id);
					tr.setTradeNo(trade_no);                                                   //第三方支付交易号
					tr.setOrderNo(out_trade_no);                                               //业务订单号
					tr.setBizId(ao.getId().toString());                                        //业务订单
					
					transactionRecordService.create(tr);
				}
				
				return PaymentConstants.Notify.PAYMENT_SUCCESS;
			}
		
		} catch (Exception e) {
			
			logger.error("支付回调异常：{}",e);
			return PaymentConstants.Notify.PAYMENT_FAIL;
		}	
			
		return PaymentConstants.Notify.PAYMENT_FAIL;
		
     }  
		
}
