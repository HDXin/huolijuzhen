package com.sudaotech.huolijuzhen.payment.conf;

import com.sudaotech.core.config.ConfigLoader;

public class PaymentConfig {

	private static final PaymentConfig instance = ConfigLoader.loadYamlAs("payment.yaml", PaymentConfig.class);
	public static PaymentConfig getInstance(){
		return instance;
	}

	//domainUrl
	private  String domainUrl;
	
	// token
	private  String token ;
	
	
	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public  String getToken() {
		return token;
	}

	public  void setToken(String token) {
		this.token = token;
	}
	

}
