package com.sudaotech.shipping.web;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sudaotech.shipping.kuaidu100.NoticeResult;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingInfoVo extends NoticeResult{
	private String shippingNo;
    
    private String shippingCompany;
    
	private String shippingCompanyId;

	public String getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}

	public String getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public String getShippingCompanyId() {
		return shippingCompanyId;
	}

	public void setShippingCompanyId(String shippingCompanyId) {
		this.shippingCompanyId = shippingCompanyId;
	}
	
	
}
