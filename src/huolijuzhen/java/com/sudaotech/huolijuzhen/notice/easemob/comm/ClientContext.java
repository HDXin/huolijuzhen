package com.sudaotech.huolijuzhen.notice.easemob.comm;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.sudaotech.core.config.PayConfig;

public class ClientContext {
	
	/*
	 * Configuration Source Type
	 */
	public static final String INIT_FROM_PROPERTIES = "FILE";
	
	public static final String INIT_FROM_CLASS = "CLASS";
	
	
	/*
	 * Implementation List
	 */
	public static final String JERSEY_API = "jersey";
	
	public static final String HTTPCLIENT_API = "httpclient";
	
	/*
	 * APP
	 */
	public static final String PARK_APP="park";
	
	public static final String ENTERPRISE_APP="enterprise";
	
	
	
	private static final Logger log = LoggerFactory.getLogger(ClientContext.class);
	
	private static Map<String, ClientContext> contextMap = new HashMap<String, ClientContext>();
		
	private Boolean initialized = Boolean.FALSE;
	
	private String protocal;
	
	private String host;
	
	private String org;
	
	private String app;
	
	private String clientId;
	
	private String clientSecret;
	
	private String impLib;
	
	private EasemobRestAPIFactory factory;
	
	private TokenGenerator token; // Wrap the token generator
	
	private ClientContext() {};
	
	private  String appExample;
	private  String seriveURL;
	
	public static ClientContext getInstance(String appExample) {
		if( null == contextMap.get(appExample) ) {
			contextMap.put(appExample,new ClientContext());
			contextMap.get(appExample).setAppExample(appExample);
		}
		
		return contextMap.get(appExample);
	}
	
	public ClientContext init() {
		if( contextMap.get(appExample).initialized ) {
			log.warn("Context has been initialized already, skipped!");
			return contextMap.get(appExample);
		}
		
//		if( StringUtils.isBlank(type) ) {
//			log.warn("Context initialization type was set to FILE by default.");
//			type = INIT_FROM_PROPERTIES;
//		}
			initFromPropertiesFile();
//			initFromStaticClass();
		
		if( contextMap.get(appExample).initialized ) {
			contextMap.get(appExample).token = new TokenGenerator(contextMap.get(appExample));
		}
		
		return contextMap.get(appExample);
	}
	
	public EasemobRestAPIFactory getAPIFactory() {
		
		if( !contextMap.get(appExample).isInitialized() ) {
			log.error(MessageTemplate.INVAILID_CONTEXT_MSG);
			throw new RuntimeException(MessageTemplate.INVAILID_CONTEXT_MSG);
		}
		
		return  EasemobRestAPIFactory.getInstance(contextMap.get(appExample));
	}
	
	
	public String getAuthToken() {
		if( null == contextMap.get(appExample).token ) {
			log.error(MessageTemplate.INVAILID_TOKEN_MSG);
			throw new RuntimeException(MessageTemplate.INVAILID_TOKEN_MSG);
		}
		
		return contextMap.get(appExample).token.request(Boolean.FALSE);
	}
	
	private void initFromPropertiesFile() {
		
		
		EasemobConfig easemob=EasemobConfig.getInstance();
		
		contextMap.get(appExample).protocal =easemob.getProtocal();
		contextMap.get(appExample).host =easemob.getHost();
		contextMap.get(appExample).org =easemob.getOrg(); 
		
 		if(appExample.equals(PARK_APP)){
 			
 			contextMap.get(appExample).app =easemob.getPark().get("app"); 
			contextMap.get(appExample).clientId = easemob.getPark().get("clientId"); 
			contextMap.get(appExample).clientSecret =easemob.getPark().get("clientSecret"); 
			contextMap.get(appExample).impLib =easemob.getPark().get("impLib"); 
			contextMap.get(appExample).initialized = Boolean.TRUE;
		}
		
		if(appExample.equals(ENTERPRISE_APP)){
			
			contextMap.get(appExample).app =easemob.getEnterprise().get("app"); 
			contextMap.get(appExample).clientId = easemob.getEnterprise().get("clientId"); 
			contextMap.get(appExample).clientSecret =easemob.getEnterprise().get("clientSecret"); 
			contextMap.get(appExample).impLib =easemob.getEnterprise().get("impLib"); 
			contextMap.get(appExample).initialized = Boolean.TRUE;
		}
		
		contextMap.get(appExample).setSeriveURL(contextMap.get(appExample).getProtocal() + "://" + contextMap.get(appExample).getHost() + "/" + contextMap.get(appExample).getOrg() + "/" + contextMap.get(appExample).getApp());
		
		log.debug("protocal: " + contextMap.get(appExample).protocal);
		log.debug("host: " + contextMap.get(appExample).host);
		log.debug("org: " + contextMap.get(appExample).org);
		log.debug("app: " + contextMap.get(appExample).app);
		log.debug("clientId: " + contextMap.get(appExample).clientId);
		log.debug("clientSecret: " + contextMap.get(appExample).clientSecret);
		log.debug("impLib: " + contextMap.get(appExample).impLib);
	}
		
	private ClientContext initFromStaticClass() {
		
        contextMap.get(appExample).protocal       = "https";
        contextMap.get(appExample).host           = "a1.easemob.com";
        contextMap.get(appExample).org            = "1129161111178164";
        contextMap.get(appExample).app            = "huolijuzhenent";
        contextMap.get(appExample).clientId       = "YXA6yzkV8LLwEea5lb0vDLcnpw";
        contextMap.get(appExample).clientSecret   = "YXA6__g4wdp6uFvMMZn110P1MjQ39Lc";
        contextMap.get(appExample).impLib         = "httpclient";
		
		log.debug("protocal: " + contextMap.get(appExample).protocal);
		log.debug("host: " + contextMap.get(appExample).host);
		log.debug("org: " + contextMap.get(appExample).org);
		log.debug("app: " + contextMap.get(appExample).app);
		log.debug("clientId: " + contextMap.get(appExample).clientId);
		log.debug("clientSecret: " + contextMap.get(appExample).clientSecret);
		log.debug("impLib: " + contextMap.get(appExample).impLib);
		
		contextMap.get(appExample).initialized = Boolean.TRUE;
				
		return null;
	}

	public String getProtocal() {
		return protocal;
	}

	public String getHost() {
		return host;
	}

	public String getOrg() {
		return org;
	}

	public String getApp() {
		return app;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}
	
	public Boolean isInitialized() {
		return initialized;
	}
	
	public String getImpLib() {
		return impLib;
	}
	
	public String getAppExample() {
		return appExample;
	}

	public void setAppExample(String appExample) {
		this.appExample = appExample;
	}

	public String getSeriveURL() {
		return seriveURL;
	}

	public void setSeriveURL(String seriveURL) {
		this.seriveURL = seriveURL;
	}

	public static void main(String[] args) {
		ClientContext.getInstance("").init();
	}

	
}
