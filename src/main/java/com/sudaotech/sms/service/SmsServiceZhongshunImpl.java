package com.sudaotech.sms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.Session;

/**
 * 中舜（志晴）短信接口V1.2
 * http://www.10086zs.com/
 */
public class SmsServiceZhongshunImpl extends AbstractSmsServiceImpl implements SmsService {
	
	private final String username;
	private final String password;
	private final String serviceURL;
	
	@Inject
	public SmsServiceZhongshunImpl(
	        @Named("sms.zhongshun.username") String username,
	        @Named("sms.zhongshun.password") String password,
	        @Named("sms.zhongshun.serviceURL") String serviceUrl) {
                this.username = username;
                this.password = password;
                this.serviceURL = serviceUrl;
	}
	
	protected boolean doSendSms(Sms shortMessage, Session session) {
		String retFlag = doSendSms(shortMessage);
		
		//返回1 发送成功
		if ("0".equals(retFlag)) {
			return true;
		}
		
		return false;
	}

	private String doSendSms(Sms shortMessage) {
		String res = "";
		try {
			
			String commString = "mobile=";
			
			//定时发送
			if (!StringUtils.isEmpty(shortMessage.getSendTimeOut())) {
				commString +=  shortMessage.getPhoneNum() + "&content="+shortMessage.getContent() + "&dstime=" + shortMessage.getSendTimeOut();
			}
			else {
				commString +=  shortMessage.getPhoneNum() + "&content="+shortMessage.getContent();
			}
			
			this.logger.debug("SMS Request: {}", commString); // don't log credentials
			
			commString = "Sn="+username+"&Pwd="+password+"&" + commString;
			res = connectURL(commString,serviceURL);
	        
	        this.logger.debug("SMS Reply: {}", res);
		} catch (Exception e) {
		    this.logger.error("Sending SMS exception: {}", e.getMessage(), e);
			return "-10000";
		}
		
		//设置返回值  解析返回值
		String resultok = "";
		//正则表达式
		Pattern pattern = Pattern.compile("<int xmlns=\"http://tempuri.org/\">(.*)</int>");
		Matcher matcher = pattern.matcher(res);
		while (matcher.find()) {
			resultok = matcher.group(1);
		}
		return resultok;
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
