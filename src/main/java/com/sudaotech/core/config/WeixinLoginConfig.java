package com.sudaotech.core.config;

import java.util.Map;


public class WeixinLoginConfig {
    private static final WeixinLoginConfig instance = ConfigLoader.loadYamlAs("weixinlogin.yaml", WeixinLoginConfig.class);
    public static WeixinLoginConfig getInstance() {
        return instance;
    }
    
    
	public static String APPID = "appid";
	public static String SECRET = "secret";
	
    private Map<String, String> appinfo;
    
	public Map<String, String> getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(Map<String, String> appinfo) {
		this.appinfo = appinfo;
	}

	public String getAppid() {
		return this.getAppinfo().get(APPID);
	}
	
	public String getSecret() {
		return this.getAppinfo().get(SECRET);
	}
}
