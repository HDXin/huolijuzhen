package com.sudaotech.shipping.service;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sudaotech.core.Updatable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipping extends Updatable {
	
	private Integer shippingId;
	
	@NotNull(message="shippingNo is required")
	private String shippingNo;
    
	@NotNull(message="shippingCompany is required")
    private String shippingCompany;
    
	private String shippingCompanyId;
	
	private String state;
	
	private String json;
	
	private String shippingFrom;
		
    private String shippingTo;
	
    private Integer saleOrderId;
    
    private String userName;
    
	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

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

	public Integer getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(Integer saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShippingCompanyId() {
		return shippingCompanyId;
	}

	public void setShippingCompanyId(String shippingCompanyId) {
		this.shippingCompanyId = shippingCompanyId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getShippingFrom() {
		return shippingFrom;
	}

	public void setShippingFrom(String shippingFrom) {
		this.shippingFrom = shippingFrom;
	}

	public String getShippingTo() {
		return shippingTo;
	}

	public void setShippingTo(String shippingTo) {
		this.shippingTo = shippingTo;
	}

	
}
