package com.sudaotech.shipping.kuaidu100;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NoticeRequest {

	private String status = "";
	private String billstatus = "";
	private String message = "";
	private NoticeResult lastResult = new NoticeResult();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBillstatus() {
		return billstatus;
	}

	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NoticeResult getLastResult() {
		return lastResult;
	}

	public void setLastResult(NoticeResult lastResult) {
		this.lastResult = lastResult;
	}
}
