package com.sudaotech.core.config;

import java.util.Map;


public class WeiboLoginConfig {
    private static final WeiboLoginConfig instance = ConfigLoader.loadYamlAs("weibologin.yaml", WeiboLoginConfig.class);
    public static WeiboLoginConfig getInstance() {
        return instance;
    }

    public static String APPID = "appid";
	public static String SECRET = "secret";
	public static String REDIRECT_URI = "redirect_uri";
	
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
	
	public String getRedirectURI() {
		return this.getAppinfo().get(REDIRECT_URI);
	}
}
