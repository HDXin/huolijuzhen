package com.sudaotech.huolijuzhen.payment.domain;

/**
 * 交易信息
 * 
 * @author chenjiashun 2016年9月23日
 */

public class TradeREQ {

	/**
	 * 订单号/交易号
	 */
	private String order_no;

	/**
	 * 支付类型： 1.wx_pub 微信JSAPI 2.wx 微信APP 3.alipay 支付宝APP
	 */
	private String channel;
	
	/**
	 * 交易金额
	 */
	private String amount;
	
	/**
	 * 交易主题
	 */
	private String subject;
	
	/**
	 * 交易内容描述
	 */
	private String body;
	
	/**
	 * 交易请求者IP
	 */
	private String clientIp;
	
	/**
	 * 微信openid，JSAPI必填
	 */
	private String openId;

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String toUrl() {
		return "order_no=" + this.order_no + "&amount=" + this.amount
				+ "&channel=" + this.channel + "&subject=" + this.subject
				+ "&body=" + this.body + "&clientIp" + clientIp;
	}

}