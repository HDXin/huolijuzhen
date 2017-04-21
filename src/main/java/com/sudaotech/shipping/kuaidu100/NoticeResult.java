package com.sudaotech.shipping.kuaidu100;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 快递100通知回调VO
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoticeResult {
	//kuaidi100: 轮询状态:polling:轮询中，shutdown:结束，abort:中止，updateall：重新推送。
	// 其中当message为“3天查无结果”或“60天无变化时”，status= abort 
	private String status = "0";
	private String message = "";
	//kuaidi100: 快递单当前签收状态，包括0在途中、1已揽收、2疑难、3已签收、4退签、5同城派送中、6退回、7转单，
	private String state = "0";
	private String nu = "";
	private String com = "";
	private String ischeck = "0";
	private String condition = "";
	private List<ResultItem> data = new ArrayList<ResultItem>();
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ResultItem {
		private String context;
		private String time;
		private String ftime;

		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getFtime() {
			return ftime;
		}
		public void setFtime(String ftime) {
			this.ftime = ftime;
		}
		
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		
		@Override
		public String toString() {
			return "ContextItem [context=" + context + ", time=" + time
					+ ", ftime=" + ftime + "]";
		}
	}
	
	public String getNu() {
		return nu;
	}
	public void setNu(String no) {
		this.nu = no;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ResultItem> getData() {
		return data;
	}
	public void setData(List<ResultItem> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "NoticeResult [state=" + state + ", status=" + status
				+ ", message=" + message + ", data=" + data + "]";
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
}
