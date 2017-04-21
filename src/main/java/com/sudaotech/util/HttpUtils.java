package com.sudaotech.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	
	/**
	 * Send GET request and return result as value object 
	 * 
	 * @param url the url to GET
	 * @param type the type of value object
	 * @return
	 */
	public static <T> T get(String url, Class<T> type) {
		
		String content = get(url);
		
		// convert json content as plain value object
		T vo = null;
		if (content != null) {
			vo = JsonUtil.fromJson(content, type);
		}
		
		return vo;
	}

	/**
	 * Send POST request and return result as json
	 * 
	 * @param url the url to POST
	 * @param params body parameters
	 * @param type the type of value object
	 * @return
	 */
	public static <T> T post(String url, Map<String, String> params, Class<T> type) {
		String content = post(url, params, false);
		
		// convert json content as plain value object
		T vo = null;
		if (content != null) {
			vo = JsonUtil.fromJson(content, type);
		}
		
		return vo;
	}
	
	public static String post(String url, Map<String, String> params, boolean jsonbody) {
		String content = null;
		try {
			Request req = null;
			if (!jsonbody) {
				List<NameValuePair> paraList = new ArrayList<NameValuePair>();
				
				if (params != null) {
					for (Map.Entry<String, String> entry : params.entrySet()) {
						paraList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
					}
				}
				
				UrlEncodedFormEntity reqEntity = new UrlEncodedFormEntity(paraList, "UTF-8");
				
				req = Request.Post(url).body(reqEntity);
				
			} else {
				req = Request.Post(url).body(new StringEntity(JsonUtil.toJson(params)));
				req.setHeader("Accept", "application/json");
				req.setHeader("Content-type", "application/json");
			}
			Response response = req.connectTimeout(30 * 1000)
					.socketTimeout(30 *1000)
					.execute();
			
			HttpResponse httpResp = response.returnResponse();
			int statusCode = httpResp.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				// content = response.returnContent().asString();
				HttpEntity respEntity = httpResp.getEntity();
                if (respEntity != null) {
                	content = EntityUtils.toString(respEntity, "UTF-8");
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(respEntity.getContent(), "UTF-8"));
//                    String line = null;
//                    StringBuilder strBuilder = new StringBuilder();
//                    while ((line = reader.readLine()) != null) {
//                    	strBuilder.append(line);
//                    }
//                	  content = strBuilder.toString();
                
                }
			} else {
				logger.error("Post failed, response status code: {}, url: {}", statusCode, url);
			}
			
		} catch (Exception e) {
			logger.error("Post failed. url: {}, error: {}", url, e.getMessage(), e);
		}
		
		return content;
	}
	
	public static String get(String url) {
	    logger.info("Start get: {}", url);
	    
		String content = null;
		try {
			Response response = Request.Get(url)
			        .connectTimeout(30 * 1000)
			        .socketTimeout(30 *1000)
			        .execute();
			
			Content returnContent = response.returnContent();
            content = returnContent.asString(Charset.forName("utf-8"));
			
		} catch (ClientProtocolException e) {
			logger.error("get failed. url: {}, error: {}", url, e.getMessage(), e);
		} catch (IOException e) {
			logger.error("get failed. url: {}, error: {}", url, e.getMessage(), e);
		}
		logger.info("End get, replied: {}", content);
		return content;
	}
	
	public static Map<String, String> parseQueryParams(String body) {
		List<NameValuePair> list = URLEncodedUtils.parse(body, Charset.forName("UTF-8"));
		Map<String,String> params = new HashMap<String,String>();
		
		for (NameValuePair pair : list) {
			params.put(pair.getName(), pair.getValue());
		}
		
		return params;
	}
	
	public static void main(String[] args) {
		String param = "discount=0.00&payment_type=1&subject=10209%E8%AE%A2%E5%8D%95&trade_no=2015070700001000650057157010&buyer_email=brianhuang113%40163.com&gmt_create=2015-07-07+16%3A20%3A12&notify_type=trade_status_sync&quantity=1&out_trade_no=10209&seller_id=2088911710013690&notify_time=2015-07-07+16%3A24%3A21&body=%E6%B3%95%E5%9B%BD%E7%BA%AF%E6%89%8B%E5%B7%A5%E6%9C%A8%E7%9B%92%E5%8F%8A%E9%93%9C%E5%88%B6%E4%BB%BF%E7%9C%9F%E6%8C%87%E5%8D%97%E9%92%88+*+1&trade_status=TRADE_SUCCESS&is_total_fee_adjust=N&total_fee=0.01&gmt_payment=2015-07-07+16%3A20%3A13&seller_email=iosapp%40yizi.com.cn&price=0.01&buyer_id=2088412506341653&notify_id=ba1f3c71f6cfb0f7542a711cd8c937175m&use_coupon=N&sign_type=RSA&sign=HtLeo1eAsZA83M8WLS%2FTnBzNNecjgjs1HRQ0yjuvBdIQfLfoUqck%2FxIpw0Rn91Fwo0s46y%2BPQq9o63e%2BrsDgJSC%2BOFkTgrH8HDaoscSLXbkQtiJH0Ajn2P1Y6NkrZJNk8%2FwRQUw9REHmluqSUoYd1SLE1qOYK7HSwazX8JsD9Q0%3D";
		
		System.out.println(parseQueryParams(param));
		
	}
}
