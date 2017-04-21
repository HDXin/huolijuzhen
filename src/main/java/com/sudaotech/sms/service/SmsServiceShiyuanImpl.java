package com.sudaotech.sms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.Session;

/**
 * 示远科技（杭州）有限公司
 */
public class SmsServiceShiyuanImpl extends AbstractSmsServiceImpl implements SmsService {
	
	private final String username;
	private final String password;
	private final String serviceURL;
	
	@Inject
	public SmsServiceShiyuanImpl(
	        @Named("sms.shiyuan.username") String username,
	        @Named("sms.shiyuan.password") String password,
	        @Named("sms.shiyuan.serviceURL") String serviceUrl) {
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
			
			String commString = "mobile=" + shortMessage.getPhoneNum();
			
			commString += "&msg="+shortMessage.getContent();
			this.logger.debug("SMS Request: {}", commString); // don't log credentials
			
			commString = "account="+username+"&pswd="+password+"&" + commString + "&needstatus=true&product=";
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
	
}
