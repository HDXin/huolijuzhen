package com.sudaotech.shipping;

import java.util.Map;

import com.sudaotech.core.config.ConfigLoader;

public class ShippingConfig {
    private static final ShippingConfig instance = ConfigLoader.loadYamlAs("shipping.yaml", ShippingConfig.class);
    public static ShippingConfig getInstance() {
        return instance;
    }
    
	public static String SUBSCRIBEURL = "subscribeurl";
	public static String KEY = "key";
	public static String CALLBACKURL = "callbackurl";
	
    private Map<String, String> kuaidi100;
    
    private Map<String, String> kuaidi100com; //comId=>name
    
	public Map<String, String> getKuaidi100() {
		return kuaidi100;
	}

	public void setKuaidi100(Map<String, String> kuaidi100) {
		this.kuaidi100 = kuaidi100;
	}
    
    public String getKuaidi100SubscribeURL() {
    	return getKuaidi100().get(SUBSCRIBEURL);
    }
    
    public String getKuaidi100Key() {
    	return getKuaidi100().get(KEY);
    }
    
    public String getKuaidi100CallbackURL() {
    	return getKuaidi100().get(CALLBACKURL);
    }

	public Map<String, String> getKuaidi100com() {
		return kuaidi100com;
	}

	public void setKuaidi100com(Map<String, String> kuaidi100com) {
		this.kuaidi100com = kuaidi100com;
	}
    
    public String getKuaidi100comName(String comId) {
    	return getKuaidi100com().get(comId);
    }
    
    public String getKuaidi100comId(String comName) {
    	if (comName == null) {
    		return null;
    	}
    	String comId = null;
    	Map<String, String> com = getKuaidi100com();
    	for (String key : com.keySet()) {
    		if (com.get(key).equals(comName)) {
    			comId = key;
    			break;
    		}
    	}
    	return comId;
    }
}
