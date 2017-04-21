package com.sudaotech.huolijuzhen.payment.alipay.conf;

/* *
 * 欢迎关注双面人的网络世界 ：http://blog.csdn.net/qq_30997391
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

		// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
		// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
		public static final String PARTNER = "2088221822410781";
	
		// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
		public static final String SELLER_ID = PARTNER;
	
		// MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
		//public static final String key = "wtktx1d0qlp9nbgggzdqstphmf5r86ni";

		//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
		public static final String PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMa659d1OPnqSlSu"+
										   "iLrWTI09gT+ufPj4RGcXqWqKFPY6Clos+v9FE8Ub+BDjZ3qgJ0Nxc0DJvse3QzTz"+
										   "kmz00b+oe1u/tJByaXWn/xz00MwaovwwRFTyBSkIdBbvCrO37uqR5V6zp2mJF98J"+
										   "dz87YdkPBFQLeQ5HFHlauEuiY7KFAgMBAAECgYEArdTj41WIRyMnbbdVpoi5YXqB"+
										   "SiDo9CbGPp819BlgiJjwYTyjORNFXc8/SBaCd4MLlTTxqaRPGwc05GaCmIf1x3M0"+
										   "LVYSwH8rFLfjmUNh7BbVO8BbLOfGygdVJgYe/O86HrOW3z+R5CD/HzcUYK5/itoN"+
										   "B52jp3QmXKVBZkKsBakCQQDrexWwGKKRWKWVMCWD6i7sygLafDcDsin3D8p92L81"+
										   "KMT9YmHDROFwRV+5NVLoDv4e33TW3MNtim4CFHYmZ1svAkEA2AwEGgXO4POSbL75"+
										   "aRShewthSghmOeciDTTnFVBFvaCHNdUCkp5EGTNiSR+HjIKfhPocJnUh4eZa/3pU"+
										   "/QHQiwJAA+UZSrxdlAHfW0Rcmn35ILmGqo57ang78XY1Zzd6kiqGd5p0+4HcKLs9"+
										   "Bhc3s9brpR8VE6i7IsizYR1tht0WyQJBAK04pSlAMulGIcazMEJCWl7PdwfmyB/w"+
										   "4+p22jjKjcBGr2JIEbIA11TlUA6VCxdru/7gkiV7kNkQ2zEvomjhRZUCQQDZoEBi"+
										   "pPfGP4Y0LjrqGNTHVe0LVk1sfOoRibuzE19Klypc/J0kT4gel8UmqTxyElLFMrsQ"+
										   "gvKNGmh2rkbKLJFL";
		
		// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
		public static final String ALIPAY_PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static final String  NOTIFY_URL= "http://huolijuzhen.sudaotech.com/platform/pay/aliPayNotify";
//		public static final String  NOTIFY_URL= "http://www.huolijuzhen.com/platform/pay/aliPayNotify";

		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问http://baidu.com
		public static final String  RETURN_URL= "";

		// 签名方式
		public static final String  SIGN_TYPE= "RSA";
		
		// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
		public static final String  LOG_PATH= "C:\\";
			
		// 字符编码格式 目前支持 gbk 或 utf-8
		public static final String  INPUT_CHARSET= "utf-8";
			
		// 支付类型 ，无需修改
		public static final String  PAYMENT_TYPE= "1";
			
	    //↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		
		// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
		public static final String  ANTI_PHISHING_KEY= "";
		
		// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
		public static final String  EXTER_INVOKE_IP= "";
			
	    //↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		
		// 调用的接口名，无需修改
	    public static class Service{
	    	
	    	//即时支付 create_direct_pay_by_user 
	    	public static final String ALPAY_WEB="create_direct_pay_by_user";
			
	    	//即时到账批量退款有密接口refund_fastpay_by_platform_pwd
	    	
	    	
			//手机网页端支付alipay.wap.create.direct.pay.by.user
	    	public static final String ALPAY_WAP="alipay.wap.create.direct.pay.by.user";
	    	
	    	
			
		}
   
	    /**
	     * 支付宝交易网关
	     */
	    public static final String  ALIPAY_TRADE="https://openapi.alipay.com/gateway.do";
	  
	    /**
	     * app_id
	     */
	    public static final String  APP_ID="2016112903570178";
	    
	    public static final String app_pubic_key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIJf8uQF6zgjMRUNo511OoEsBG8SbfsLxv2tgybYyRqCq32Ws3lhsHoTSmvvYSS9xYm0bw0Dip150jvuYB4KCQlgnN6PsFy4/dkKMUsrIAwWJ0kYXragSBhcjuOjtmhisNFAsKH2SShExX5+IuiyXtm16zAuGf7Wo/0DJjD0E2tQIDAQAB ";
	    
	    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}