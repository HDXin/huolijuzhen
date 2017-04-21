package com.sudaotech.core.config;

import java.util.Map;


public class PayConfig {
    private static final PayConfig instance = ConfigLoader.loadYamlAs("pay.yaml", PayConfig.class);
    public static PayConfig getInstance() {
        return instance;
    }
    
	// Alipay
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String ALI_PARTNER = "partner";
	// 商户的私钥
	public static String ALI_PRIVATE_KEY = "privatekey";
	// 支付宝的公钥，无需修改该值
	public static final String ALI_ALI_PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	// 签名方式 不需修改
	public static final String ALI_SIGN_TYPE = "RSA";
	// 支付宝消息验证地址
	private static final String ALI_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	public static final String ALI_ORDERQUERY_URL = "https://mapi.alipay.com/gateway.do?";
	
	// Weixin apy
	public static String WX_APPID = "appid";
	public static String WX_APP_SECRET = "appsecret";
	public static String WX_APP_KEY = "appkey";
	public static String WX_MERCHANTID = "merchantid";
	public static String WX_NOTIFY_URL = "notifyurl";
	//微信消息验证地址
	public static final String WX_PREPAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public static final String WX_ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	
    private Map<String, String> alipay;
    private Map<String, String> weixinpay;

	public Map<String, String> getAlipay() {
		return alipay;
	}

	public void setAlipay(Map<String, String> alipay) {
		this.alipay = alipay;
	}

	public Map<String, String> getWeixinpay() {
		return weixinpay;
	}

	public void setWeixinpay(Map<String, String> weixinpay) {
		this.weixinpay = weixinpay;
	}

	public String getAlipayPartner() {
		return this.getAlipay().get(ALI_PARTNER);
	}
	
	public String getAlipayPrivateKey() {
		return this.getAlipay().get(ALI_PRIVATE_KEY);
	}
	
	public String getAlipayAliPublicKey() {
		return ALI_ALI_PUBLIC_KEY;
	}
	
	public String getAlipaySignType() {
		return ALI_SIGN_TYPE;
	}
	
	public String getAlipayVerifyURL() {
		return ALI_VERIFY_URL;
	}
	
	public String getAlipayQrderQueryURL() {
		return ALI_ORDERQUERY_URL;
	}

	public String getWXAppid() {
		return this.getWeixinpay().get(WX_APPID);
	}
	
	public String getWXAppKey() {
		return this.getWeixinpay().get(WX_APP_KEY);
	}
	
	public String getWXAppSecret() {
		return this.getWeixinpay().get(WX_APP_SECRET);
	}
	
	public String getWXMerchantid() {
		return this.getWeixinpay().get(WX_MERCHANTID);
	}
	
	public String getWXNotifyURL() {
		return this.getWeixinpay().get(WX_NOTIFY_URL);
	}
	
	public String getWXPrepayURL() {
		return WX_PREPAY_URL;
	}
	
	public String getWXOrderQueryURL() {
		return WX_ORDERQUERY_URL;
	}
}
