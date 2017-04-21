package com.sudaotech.huolijuzhen.notice.easemob.comm;

import java.util.Map;

import com.sudaotech.core.config.ConfigLoader;

public class EasemobConfig {

	private static final EasemobConfig instance = ConfigLoader.loadYamlAs("easemob.yaml", EasemobConfig.class);
	public static EasemobConfig getInstance(){
		return instance;
	}
	
	private String protocal;
	private String host;
	private String org;
	
	private Map<String, String> enterprise;
	
    private Map<String, String> park;
    
	public Map<String, String> getPark() {
		return park;
	}

	public void setPark(Map<String, String> park) {
		this.park = park;
	}

	public Map<String, String> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Map<String, String> enterprise) {
		this.enterprise = enterprise;
	}

	public String getProtocal() {
		return protocal;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}
	
	
}
