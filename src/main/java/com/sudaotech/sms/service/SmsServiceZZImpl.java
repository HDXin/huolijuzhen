/**
 * 
 */
package com.sudaotech.sms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.http.client.HttpClient;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.Session;

/**
 * @Describe:       专业的云通讯PaaS平台（http://zz.253.com）
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        vacances
 *
 * @Package:        com.sudaotech.sms.service
 *
 * @Date:           2016年10月21日 下午5:25:06
 *
 */
public class SmsServiceZZImpl extends AbstractSmsServiceImpl  implements SmsService {


	private final String username;
	private final String password;
	private final String serviceURL;
	
	@Inject
	public SmsServiceZZImpl(
	        @Named("sms.zz.username") String username,
	        @Named("sms.zz.password") String password,
	        @Named("sms.zz.serviceURL") String serviceUrl) {
                this.username = username;
                this.password = password;
                this.serviceURL = serviceUrl;
	}
	
	protected boolean doSendSms(Sms shortMessage, Session session) {
		return doSendSms(shortMessage);
	}

	private boolean doSendSms(Sms shortMessage) {
		String res = "";
		try {
		/*	new NameValuePair("account", account),
			new NameValuePair("pswd", pswd), 
			new NameValuePair("mobile", mobile),
			new NameValuePair("needstatus", String.valueOf(needstatus)), 
			new NameValuePair("msg", msg),
			new NameValuePair("extno", extno), 
			
			String url = "http://sapi.253.com/msg/";// 应用地址
			String account = "询问对接人";// 账号
			String pswd = "询问对接人";// 密码
			String mobile = "13800210021,13800138000";// 手机号码，多个号码使用","分割
			String msg = "您好，您的验证码是123456";// 短信内容
			boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
			String extno = null;// 扩展码
*/			
			String commString = "account=" +username;
			commString += "&pswd="+password;
			commString += "&mobile="+shortMessage.getPhoneNum();
			commString += "&needstatus=true";
			commString += "&msg="+shortMessage.getContent();
			commString += "&extno=null";
	
			res = connectURL(commString,serviceURL);
			
	        this.logger.debug("SMS Reply: {}", res);
		} catch (Exception e) {
		    this.logger.error("Sending SMS exception: {}", e.getMessage(), e);
			return false;
		}
		
		//设置返回值  解析返回值
		String[] rows = res.split("\n");
		if (rows.length > 0) {
		    String[] cols = rows[0].split(",");
		    if (cols.length == 2 && "0".equals(cols[1])) {
		        return true;
		    }
		}
		
		return false;
	}
	
	private String connectURL(String commString, String sendsmsaddress) {
		String retString = "";
		URL url = null;
		HttpURLConnection urlConn = null;
		try {
			url = new URL(sendsmsaddress);  //根据数据的发送地址构建URL
			urlConn = (HttpURLConnection) url.openConnection(); //打开链接
			urlConn.setConnectTimeout(30000); //链接超时设置为30秒
			urlConn.setReadTimeout(30000);	//读取超时设置30秒
			urlConn.setRequestMethod("POST");	//链接相应方式为post
			urlConn.setDoOutput(true);
			urlConn.setDoInput(true);
			
			OutputStream out = urlConn.getOutputStream();
			out.write(commString.getBytes("UTF-8"));
			out.flush();
			out.close();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			int ch;
			while ((ch = rd.read()) > -1) {
				sb.append((char) ch);
			}
			
			retString = sb.toString().trim();
			retString = URLDecoder.decode(retString, "UTF-8");
			rd.close();
		} catch (Exception e) {
			retString = "-107";
		} finally {
			if (urlConn != null) {
				urlConn.disconnect();
			}
		}

		return retString;
	}
	
	/*public static String batchSend(String url, String account, String pswd, String mobile, String msg,
			boolean needstatus, String extno) throws Exception {
		HttpClient client = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
		GetMethod method = new GetMethod();
		try {
			URI base = new URI(url, false);
			method.setURI(new URI(base, "HttpBatchSendSM", false));
			method.setQueryString(new NameValuePair[] { 
					new NameValuePair("account", account),
					new NameValuePair("pswd", pswd), 
					new NameValuePair("mobile", mobile),
					new NameValuePair("needstatus", String.valueOf(needstatus)), 
					new NameValuePair("msg", msg),
					new NameValuePair("extno", extno), 
				});
			int result = client.executeMethod(method);
			if (result == HttpStatus.SC_OK) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				return URLDecoder.decode(baos.toString(), "UTF-8");
			} else {
				throw new Exception("HTTP ERROR Status: " + method.getStatusCode() + ":" + method.getStatusText());
			}
		} finally {
			method.releaseConnection();
			}
		}

	}*/

}
