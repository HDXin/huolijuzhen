package com.sudaotech.huolijuzhen.payment.weixin.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class NotificationResult {

	private String return_code;
	private String return_msg;
	
	public NotificationResult() {
		
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	
	
}
