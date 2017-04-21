package com.sudaotech.huolijuzhen.payment.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 交易响应信息
 * 
 * @author chenjiashun 2016年9月23日
 */

public class TradeRESP {
	private String id;
	private String object;
	private Long created;
	private Boolean livemode;
	private Boolean paid;
	private Boolean refunded;
	private String channel;
	private String orderNo;
	private String clientIp;
	private Double amount;
	private Integer amountSettle;
	private String currency;
	private String subject;
	private String body;
	private String timePaid;
	private Long timeExpire;
	private String transactionNo;
	private Double amount_refunded;
	private String failureCode;
	private String failureMsg;
	private String metadata;
	private String description;
	private App app;
	private Extra extra;
	private Credential credential;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Boolean getLivemode() {
		return livemode;
	}

	public void setLivemode(Boolean livemode) {
		this.livemode = livemode;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Boolean getRefunded() {
		return refunded;
	}

	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getAmountSettle() {
		return amountSettle;
	}

	public void setAmountSettle(Integer amountSettle) {
		this.amountSettle = amountSettle;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTimePaid() {
		return timePaid;
	}

	public void setTimePaid(String timePaid) {
		this.timePaid = timePaid;
	}

	public Long getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(Long timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Double getAmount_refunded() {
		return amount_refunded;
	}

	public void setAmount_refunded(Double amount_refunded) {
		this.amount_refunded = amount_refunded;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public String getFailureMsg() {
		return failureMsg;
	}

	public void setFailureMsg(String failureMsg) {
		this.failureMsg = failureMsg;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	class App {
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}

	class Extra {
		private String openid;

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

	}

	class Credential {
		private String object;
		private WX wx;
		private Alipay alipay;

		public String getObject() {
			return object;
		}

		public void setObject(String object) {
			this.object = object;
		}

		public WX getWx() {
			return wx;
		}

		public void setWx(WX wx) {
			this.wx = wx;
		}

		public Alipay getAlipay() {
			return alipay;
		}

		public void setAlipay(Alipay alipay) {
			this.alipay = alipay;
		}

		class WX {

			@Expose
			@SerializedName("package")
			private String _package;
			private String sign;
			private String trade_type;
			private String prepayid;
			private String timestamp;
			private String paySign;
			private String appid;
			private String signType;
			private String result_code;
			private String return_msg;
			private String partnerid;
			private String return_code;
			private String noncestr;
			private String check_sign;

			public String get_package() {
				return _package;
			}

			public void set_package(String _package) {
				this._package = _package;
			}

			public String getSign() {
				return sign;
			}

			public void setSign(String sign) {
				this.sign = sign;
			}

			public String getTrade_type() {
				return trade_type;
			}

			public void setTrade_type(String trade_type) {
				this.trade_type = trade_type;
			}

			public String getPrepayid() {
				return prepayid;
			}

			public void setPrepayid(String prepayid) {
				this.prepayid = prepayid;
			}

			public String getTimestamp() {
				return timestamp;
			}

			public void setTimestamp(String timestamp) {
				this.timestamp = timestamp;
			}

			public String getPaySign() {
				return paySign;
			}

			public void setPaySign(String paySign) {
				this.paySign = paySign;
			}

			public String getAppid() {
				return appid;
			}

			public void setAppid(String appid) {
				this.appid = appid;
			}

			public String getSignType() {
				return signType;
			}

			public void setSignType(String signType) {
				this.signType = signType;
			}

			public String getResult_code() {
				return result_code;
			}

			public void setResult_code(String result_code) {
				this.result_code = result_code;
			}

			public String getReturn_msg() {
				return return_msg;
			}

			public void setReturn_msg(String return_msg) {
				this.return_msg = return_msg;
			}

			public String getPartnerid() {
				return partnerid;
			}

			public void setPartnerid(String partnerid) {
				this.partnerid = partnerid;
			}

			public String getReturn_code() {
				return return_code;
			}

			public void setReturn_code(String return_code) {
				this.return_code = return_code;
			}

			public String getNoncestr() {
				return noncestr;
			}

			public void setNoncestr(String noncestr) {
				this.noncestr = noncestr;
			}

			public String getCheck_sign() {
				return check_sign;
			}

			public void setCheck_sign(String check_sign) {
				this.check_sign = check_sign;
			}

		}

		class Alipay {
			private String orderInfo;

			public String getOrderInfo() {
				return orderInfo;
			}

			public void setOrderInfo(String orderInfo) {
				this.orderInfo = orderInfo;
			}

		}

	}

}