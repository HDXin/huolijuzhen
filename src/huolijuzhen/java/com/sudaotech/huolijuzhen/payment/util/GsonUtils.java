/*
 * Copyright 2008-2015 GuanAiHui inc. 
 */
package com.sudaotech.huolijuzhen.payment.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sudaotech.core.web.result.Result;

/**
 * 
 * @Describe:       GsonUtils
 *
 * @Author:			chenjs
 *
 * @Date:           2016年12月16日 下午3:24:33
 *
 */
public class GsonUtils {

	public static final Gson GSON_NO_NULL = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
	
	public static final Gson GSON_EXCLUSION = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
	/**
	 *   排除属性
	 * @param keys
	 * @return
	 */
	public static Gson exclustion(String[] keys){
		
		return new GsonBuilder().setExclusionStrategies(new JsonKit(keys)).create(); 
		
	}
	/** 
	 *Gson序列化对象排除属性 
	 *调用方法： 
	 *String[] keys = { "id" }; 
	 *Gson gson = new GsonBuilder().setExclusionStrategies(new JsonKit(keys)).create(); 
	 */  
	
	public static class JsonKit implements ExclusionStrategy {  
	    String[] keys;  
	  
	    public JsonKit(String[] keys) {  
	        this.keys = keys;  
	    }  
	  
	    @Override  
	    public boolean shouldSkipClass(Class<?> arg0) {  
	        return false;  
	    }  
	  
	    @Override  
	    public boolean shouldSkipField(FieldAttributes arg0) {  
	        for (String key : keys) {  
	            if (key.equals(arg0.getName())) {  
	                return true;  
	            }  
	        }  
	        return false;  
	    }  
	  
	}  
}
