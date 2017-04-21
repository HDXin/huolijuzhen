package com.sudaotech.huolijuzhen.payment.service;

import com.sudaotech.huolijuzhen.payment.domain.TradeREQ;
import com.sudaotech.huolijuzhen.payment.domain.TradeRESP;


public interface PaymentService {
	
	/**
	 * 描述：支付交易(支付中间件，用于app端跳转到支付宝、微信的客户端)，
	 * @param tradeReq
	 * @return
	 */
	TradeRESP tradeOrder(TradeREQ tradeReq) throws Exception;
	
	
	/**
	 * 描述：网页端立即支付，创建预订单支付信息（支付宝生成form表单自动提交的html，微信生成二维码图片地址）
	 * @param tradeReq
	 * @return
	 */
	String createDirectPay(TradeREQ tradeReq) throws Exception;
	
	
	/**
	 * 描述：退款
	 * @param tradeReq
	 * @return
	 */
	String refund(TradeREQ tradeReq) throws Exception;
	
	
}