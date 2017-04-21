package com.sudaotech.huolijuzhen.payment.weixin.util;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import javax.net.ssl.SSLContext;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.util.PasswordGenerator;
import com.sudaotech.huolijuzhen.payment.weixin.conf.WeixinPayConfig;

public class WeiXinUtil {
	

    @SuppressWarnings("deprecation")
    public static  String wxRefund( String orderId, String total_fee, String refund_fee) throws Exception {
			
		String appId  = WeixinPayConfig.APP_ID ;
		String mch_id = WeixinPayConfig.MCH_ID ;
		String nonce_str = PasswordGenerator.getPassword(10).toUpperCase();
		String out_refund_no = UUID.randomUUID().toString();
		
		String path = WeixinPayConfig.CERT_PATH;
		String refund_account=WeixinPayConfig.Refund.REFUND_ACCOUNT;
		
		/*-----1.退款需要的的package数据-----*/
		TreeMap<String, String> paras = new TreeMap<String, String>();
		paras.put("appid", appId);
		paras.put("mch_id", mch_id);
		paras.put("nonce_str", nonce_str);
		paras.put("op_user_id", mch_id);
		paras.put("out_trade_no", orderId);
		paras.put("out_refund_no", out_refund_no);
		paras.put("total_fee", total_fee);
		paras.put("refund_fee", refund_fee);
		paras.put("refund_account", refund_account);
		
		/*----2.根据package生成签名sign---- */
		String sign = getSign(paras);

		/*----3.拼装需要提交到微信的数据xml---- */
		String xml="<xml>"
				 +"<appid>"+appId+"</appid>"
				 + "<mch_id>"+mch_id+"</mch_id>"
				 + "<nonce_str>"+nonce_str+"</nonce_str>"
				 + "<op_user_id>"+mch_id+"</op_user_id>"
				 + "<out_trade_no>"+orderId+"</out_trade_no>"
				 + "<out_refund_no>"+out_refund_no+"</out_refund_no>"
				 + "<total_fee>"+total_fee+"</total_fee>"
				 + "<refund_fee>"+refund_fee+"</refund_fee>"
				 + "<refund_account>"+refund_account+"</refund_account>"
				 + "<sign>"+sign+"</sign>"
				 +"</xml>";
		
		/*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(path));
		try {
			keyStore.load(instream, mch_id.toCharArray());
		} finally {
			instream.close();
		}

		/*----5.发送数据到微信的退款接口---- */
		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore,mch_id.toCharArray()).build();
		
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		HttpPost httpPost = new HttpPost(WeixinPayConfig.Refund.REFUND_URL);
		httpPost.setHeader("Content-Type", "application/xml");
		httpPost.setEntity(new ByteArrayEntity(xml.getBytes()));
		CloseableHttpResponse response = httpclient.execute(httpPost);
		
		return EntityUtils.toString(response.getEntity(),"UTF-8");

	}

	/**
	 * 生成签名
	 * 
	 * @param paras
	 * @return
	 */
    public static String getSign(TreeMap<String, String> paras) {
		String string1 = originalString(paras);
		String stringSignTemp = string1 + "key=" + WeixinPayConfig.API_KEY;
		String sign = MD5Util.MD5Encode(stringSignTemp, "utf-8").toUpperCase();
		return sign;
	}

	/**
	 * wxpackage组装原始串
	 * 
	 * @param treeMap
	 * @return
	 */
	public static String originalString(TreeMap<String, String> treeMap) {
		Set<Entry<String, String>> entry = treeMap.entrySet();
		StringBuffer sb = new StringBuffer();
		for (Entry<String, String> obj : entry) {
			String k = obj.getKey();
			String v = obj.getValue();
			if (v == null || v.equals(""))
				continue;
			sb.append(k + "=" + v + "&");
		}
		return sb.toString();
	}
}
