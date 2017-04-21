package com.sudaotech.core.config;

import java.util.Map;


public class QQLoginConfig {
    private static final QQLoginConfig instance = ConfigLoader.loadYamlAs("qqlogin.yaml", QQLoginConfig.class);;
    public static QQLoginConfig getInstance() {
        return instance;
    }
    
	public static String APPID = "appid";  // APP ID
	public static String SECRET = "secret";  // APP KEY
	public static String REDIRECT_URI = "redirect_uri"; // REDIRECT URI
	
    private Map<String, String> appinfo;
    private Map<String, String> iosinfo;

	public Map<String, String> getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(Map<String, String> appinfo) {
		this.appinfo = appinfo;
	}

	public Map<String, String> getIosinfo() {
        return iosinfo;
    }

    public void setIosinfo(Map<String, String> iosinfo) {
        this.iosinfo = iosinfo;
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
