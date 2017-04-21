package com.sudaotech.redis.service;

import com.sudaotech.core.Storable;
import com.sudaotech.util.JsonUtil;

public class RedisValue {
    private Class<?> type;
    private String json;
    
    public RedisValue() {
    }
    public RedisValue(Storable storable) {
        this(storable.getClass(), JsonUtil.toJson(storable));
    }
    public RedisValue(Class<?> type, String json) {
        super();
        this.type = type;
        this.json = json;
    }
    public Class<?> getType() {
        return type;
    }
    public void setType(Class<?> type) {
        this.type = type;
    }
    public String getJson() {
        return json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
