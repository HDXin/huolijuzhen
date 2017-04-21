package com.sudaotech.huolijuzhen.payment.domain;

public class PaymentConstants {

	/**
	 * 支付方式
	 * 
	 * @Date:           2016年12月15日 下午6:37:56
	 *
	 */
	public static class Channel {
		
	/**
	 * 微信JSAPI	
	 */
    public final static String WX_PUB = "wx_pub";
    
    /**
     * 微信APP
     */
    public final static String WX= "wx";
    
    /**
     * 支付宝APP
     */
    public final static String ALIPAY = "alipay";
     
    
	}
	
	/**
	 * 回调信息相关 常量
	 * 
	 * @Date:           2016年12月15日 下午6:37:56
	 *
	 */
	public static class Notify{
		
		public final static String CHARGE_SUCCESSFUL ="charge.succeeded";
		
		/**
		 * 回调失败
		 */
		public final static String PAYMENT_FAIL="fail";
		
		/**
		 * 回调成功
		 */
		public final static String PAYMENT_SUCCESS="success";
		
	}
	
	/**
	 * 退款相关 常量
	 * 
	 * @Date:           2016年12月15日 下午6:37:56
	 *
	 */
	public static class Refund{
		
		
		/**
		 * 退款失败
		 */
		public final static String REFUND_FAIL="fail";
		
		/**
		 * 退款成功
		 */
		public final static String REFUND_SUCCESS="success";
		
		
	}
	
}
