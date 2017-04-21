package com.sudaotech.huolijuzhen.payment.weixin.conf;

/**
 * 
 * @Describe:       微信交易相关配置
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.payment.weixin.conf
 *
 * @Date:           2017年1月5日 上午10:19:47
 *
 */

public class WeixinPayConfig {

		// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
		//初始化
		public static final String APP_ID         = "wx1628e13c5bf56c9c";                                   //微信开发平台应用Id
		public static final String APP_SECRET     = "263b0f8699dcc4de9e455753d589e81b";                     //应用对应凭证
		public static final String MCH_ID         = "1414007102";                                           //商业号
		public static final String API_KEY        = "huolijuzhen13917938396huolijuzhe";                     //API key
		public static final String NOTIFY_URL     = "http://huolijuzhen.sudaotech.com/platform/pay/weixinPayNotify";  //回调地址
//		public static final String NOTIFY_URL     = "http://www.huolijuzhen.com/platform/pay/weixinPayNotify";  //回调地址
		public static final String CREATE_IP      = "";
		
		public static final String TRADE_TYPE     = "NATIVE";
		
		//注意PKCS12证书 是从微信商户平台-》账户设置-》 API安全 中下载的
		public static final String CERT_PATH      = "C:/cert/apiclient_cert.p12" ;
//		public static final String CERT_PATH      = "/data/apps/cert/apiclient_cert.p12" ;
		public static class Service{
			
			
			public static final String UFDODER_URL    = "https://api.mch.weixin.qq.com/pay/unifiedorder";       //微信预支付订单生成接口			
			
		
		}
		
		public static class Refund{
			
			public static final String REFUND_URL     = "https://api.mch.weixin.qq.com/secapi/pay/refund";      //退款接口地址	
			
			//退款资金来源
			/*仅针对老资金流商户使用
			REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
			REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款*/
			public static final String REFUND_ACCOUNT="REFUND_SOURCE_RECHARGE_FUNDS";
		}
		
		
	

	    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}
