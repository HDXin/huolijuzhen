package com.sudaotech.util;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper mapper = ObjectMapperHolder.getObjectMapper();
    private static final ObjectMapper mapperIgnoreNull = ObjectMapperHolder.getObjectMapper();
    
    public static <T> T fromJsonQuietly(String json, Class<T> type) {
        try {
            return fromJson(json, type);
        } catch (Exception e) {
            logger.error("fromJson failed: {}", e.getMessage(), e);
        }
        return null;
    }
        
    public static <T> T fromJson(String json, Class<T> type) {
        if (type == null || json == null) {
            return null;
        }
        try {
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Map<String, String> fromJsonQuietly(String json) {
        try {
        	if (json != null) {
        		return mapper.readValue(json, new TypeReference<HashMap<String,String>>(){});
        	}
        } catch (Exception e) {
        	logger.error("fromJsonQuietly failed: {}", e.getMessage(), e);
        }
    	return null;
    }

    public static String toJsonQuietly(Object obj) {
        try {
            return toJson(obj);
        } catch (Exception e) {
            logger.error("toJson failed: {}", e.getMessage(), e);
        }
        return null;
    }
        
    public static String toJson(Object obj) {
    	if (obj == null) {
    		return null;
    	}
    	try {
    		String json = mapper.writeValueAsString(obj);
    		return json;
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    public static String toJsonIgnoreNull(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
        	mapperIgnoreNull.setSerializationInclusion(Inclusion.NON_NULL);
    		String json = mapperIgnoreNull.writeValueAsString(obj);
    		
            return json;
        } catch (Exception e) {
        	logger.error("toJson failed: {}", e.getMessage(), e);
        }
        return null;
    }
    
    private static class ObjectMapperHolder {
        public static ObjectMapper getObjectMapper() {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.USE_ANNOTATIONS);
            mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.WRAP_EXCEPTIONS);
            
            mapper.disable(org.codehaus.jackson.map.SerializationConfig.Feature.USE_ANNOTATIONS);
            return mapper;
        }
    }
}
