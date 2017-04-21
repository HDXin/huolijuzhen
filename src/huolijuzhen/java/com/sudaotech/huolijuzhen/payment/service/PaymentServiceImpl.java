package com.sudaotech.huolijuzhen.payment.service;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.google.gson.Gson;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.huolijuzhen.payment.alipay.conf.AlipayConfig;
import com.sudaotech.huolijuzhen.payment.alipay.util.AlipaySubmit;
import com.sudaotech.huolijuzhen.payment.domain.PaymentConstants;
import com.sudaotech.huolijuzhen.payment.domain.TradeREQ;
import com.sudaotech.huolijuzhen.payment.domain.TradeRESP;
import com.sudaotech.huolijuzhen.payment.util.PaymentHttpUtil;
import com.sudaotech.huolijuzhen.payment.weixin.conf.WeixinPayConfig;
import com.sudaotech.huolijuzhen.payment.weixin.util.PayCommonUtil;
import com.sudaotech.huolijuzhen.payment.weixin.util.WeiXinUtil;
import com.sudaotech.huolijuzhen.payment.weixin.util.XMLUtil;
import com.sudaotech.huolijuzhen.payment.weixin.vo.RefundResult;
import com.sudaotech.util.XmlUtil;

/**
 * 
 * @Describe: 统一支付管理
 *
 * @Author: chenjs
 *
 * @Company: kuaicto
 * 
 * @Project: huolijuzhen
 *
 * @Package: com.sudaotech.huolijuzhen.payment.service
 *
 * @Date: 2016年12月18日 下午2:49:02
 *
 */
public class PaymentServiceImpl extends BaseServiceImpl implements
		PaymentService {

	// 交易接口
	private static final String TRADE_URL = "/payment/api/trade";

	@Override
	public TradeRESP tradeOrder(TradeREQ tradeReq) {
		// 测试时使用
		// tradeReq.setAmount("10");

		String result = PaymentHttpUtil.httpGet(
				TRADE_URL + "?" + tradeReq.toUrl(), null);

		logger.info("[[[[[[交易请求参数{}：返回结果:{}]]]]]]]", tradeReq.toUrl(), result);

		return new Gson().fromJson(result, TradeRESP.class);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public String createDirectPay(TradeREQ tradeReq) throws Exception {
		// 测试时使用
		// tradeReq.setAmount("10");

		String htmlText = null;
		if (tradeReq.getChannel() == PaymentConstants.Channel.ALIPAY) {

			// 收银台页面上，商品展示的超链接，必填
			String show_url = "http://blog.csdn.net/qq_30997391";// 欢迎关注博客
			// AlipayConfig.return_url += "?payCode=" + payCode;
			// 把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", AlipayConfig.Service.ALPAY_WEB);
			sParaTemp.put("partner", AlipayConfig.PARTNER);
			sParaTemp.put("seller_id", AlipayConfig.SELLER_ID);
			sParaTemp.put("_input_charset", AlipayConfig.INPUT_CHARSET);
			sParaTemp.put("payment_type", AlipayConfig.PAYMENT_TYPE);
			sParaTemp.put("notify_url", AlipayConfig.NOTIFY_URL);
			sParaTemp.put("return_url", AlipayConfig.RETURN_URL);
			// 收银台页面上，商品展示的超链接，必填
			sParaTemp.put("show_url", show_url);

			sParaTemp.put("out_trade_no", tradeReq.getOrder_no());
			sParaTemp.put("subject", tradeReq.getSubject());
			// 商品金额
			sParaTemp.put("total_fee", tradeReq.getAmount());
			// sParaTemp.put("app_pay","Y");//启用此参数可唤起钱包APP支付。
			// 商品描述，可空
			sParaTemp.put("body", tradeReq.getBody());
			htmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");

			return htmlText;

		}
		if (tradeReq.getChannel() == PaymentConstants.Channel.WX) {

			// String appsecret = WeixinPayConfig.APP_SECRET; // appsecret

			String currTime = PayCommonUtil.getCurrTime();
			String strTime = currTime.substring(8, currTime.length());
			String strRandom = PayCommonUtil.buildRandom(4) + "";
			String nonce_str = strTime + strRandom;

			// 回调接口
			SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
			packageParams.put("appid", WeixinPayConfig.APP_ID);
			packageParams.put("mch_id", WeixinPayConfig.MCH_ID);
			packageParams.put("spbill_create_ip", WeixinPayConfig.CREATE_IP);
			packageParams.put("notify_url", WeixinPayConfig.NOTIFY_URL);
			packageParams.put("trade_type", WeixinPayConfig.TRADE_TYPE);
			packageParams.put("nonce_str", nonce_str);

			packageParams.put("total_fee", tradeReq.getAmount());
			packageParams.put("out_trade_no", tradeReq.getOrder_no());
			packageParams.put("body", tradeReq.getBody());

			String sign = PayCommonUtil.createSign("UTF-8", packageParams,WeixinPayConfig.API_KEY);
			packageParams.put("sign", sign);
			String reqXml = PayCommonUtil.getRequestXml(packageParams);
			logger.info("预生成交易单{}请求：{}", tradeReq.getOrder_no(), reqXml);
			String resXml = PaymentHttpUtil.postData(WeixinPayConfig.Service.UFDODER_URL, reqXml, null);
			logger.info("预生成交易单{}响应：{}", tradeReq.getOrder_no(), resXml);
			Map map = XMLUtil.doXMLParse(resXml);
			// String return_code = (String) map.get("return_code");
			// String prepay_id = (String) map.get("prepay_id");
			return (String) map.get("code_url");

		}
		return htmlText;
	}

	@Override
	public String refund(TradeREQ tradeReq) throws Exception {

		// 测试时使用
/*		tradeReq.setAmount("10");
		tradeReq.setOrder_no("10");*/
		if (tradeReq.getChannel() == PaymentConstants.Channel.ALIPAY) {

			AlipayClient alipayClient = new DefaultAlipayClient(
					AlipayConfig.ALIPAY_TRADE, AlipayConfig.APP_ID,
					AlipayConfig.PRIVATE_KEY, "json", "GBK",
					AlipayConfig.app_pubic_key);
			AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

			request.setBizContent("{"
					+ "\"out_trade_no\":\"2016122401000002\","
					+ "\"trade_no\":\"2016122421001004420208062992\","
					+ "\"refund_amount\":1.00," + "\"refund_reason\":\"test\","
					+ "\"out_request_no\":\"20161224010\","
					+ "\"operator_id\":\"OP001\","
					+ "\"store_id\":\"NJ_S_001\","
					+ "\"terminal_id\":\"NJ_T_001\"" + "}");
			AlipayTradeRefundResponse response = alipayClient.execute(request);
			
			if (response.isSuccess()) {
				logger.info("支付宝退款成功");
				return PaymentConstants.Refund.REFUND_SUCCESS;
			} 
			logger.info("支付宝退款失败");
		}
		if (tradeReq.getChannel() == PaymentConstants.Channel.WX) {
			
			String result=WeiXinUtil.wxRefund(tradeReq.getOrder_no(),tradeReq.getAmount(),tradeReq.getAmount());
			logger.info("微信退款响应{}",result);
			
			RefundResult rr=XmlUtil.fromXml(result, RefundResult.class);
			 //响应成功
             if(rr.getReturn_code().equalsIgnoreCase(PaymentConstants.Refund.REFUND_SUCCESS)){
            	 //退款成功
            	 if(rr.getResult_code().equalsIgnoreCase(PaymentConstants.Refund.REFUND_SUCCESS)){
            	   logger.info("微信退款成功");
            	   return PaymentConstants.Refund.REFUND_SUCCESS;
            	 }
             }
             logger.info("微信退款失败"); 
		}

		return PaymentConstants.Refund.REFUND_FAIL;
	}
	
}