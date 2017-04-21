package com.sudaotech.redis.service;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.Cachable;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.util.JsonUtil;

public class RedisCacheServiceImpl extends BaseServiceImpl implements RedisCacheService {

    private static final String CACHE_PREFIX = "_CACHE::";

    private static final int ONE_HOUR = 60 * 60;

    private static final ReentrantLock lock = new ReentrantLock();
    
    @Inject
    private RedisService redisService;
    
    @Override
    public void clearCache() {
        throw new UnsupportedOperationException("clearCache not supported");
    }

    @Override
    public <T> T cache(Cachable<T> cache) {
        Object key = cache.getKey();
        String cacheKey = buildCacheKey(key);
        
        
        if (!redisService.exists(cacheKey)) {
            lock.lock();
            try {
                if (!redisService.exists(cacheKey)) {
                    Object cacheObj = cache.getValue();
                    if (cacheObj == null) {
                        logger.warn("reject cache null object, key: {}", key);
                        return null;
                    }
                    
                    RedisValue redisValue = new RedisValue();
                    redisValue.setJson(JsonUtil.toJson(cacheObj));
                    redisValue.setType(cacheObj.getClass());
                    
                    String value = JsonUtil.toJson(redisValue);
                    redisService.set(cacheKey, value, ONE_HOUR);
                    logger.debug("Redis-Cache-Set: {}={}", cacheKey, value);
                }
            } finally {
                lock.unlock();
            }
        }
        
        T obj = getCachedObj(cacheKey);
        
        return obj;
    }

    @SuppressWarnings("unchecked")
    private <T> T getCachedObj(String cacheKey) {
        T obj = null;
        String value = redisService.get(cacheKey);
        if (!StringUtils.isBlank(value)) {
            RedisValue redisValue = JsonUtil.fromJsonQuietly(value, RedisValue.class);
            if (redisValue != null) {
                Class<?> type = redisValue.getType();
                obj = (T)JsonUtil.fromJsonQuietly(redisValue.getJson(), type);
            }
            
            // 数据存在问题，则删除key
            if (obj == null) {
                redisService.del(cacheKey);
            }
        }
        return obj;
    }

    private String buildCacheKey(Object key) {
        return CACHE_PREFIX + key;
    }

    @Override
    public <T> T clear(Object key) {
        logger.debug("clear: {}", key);
        lock.lock();
        try {
            String cacheKey = buildCacheKey(key);
            T obj = this.getCachedObj(cacheKey);
            redisService.del(cacheKey);
            return obj;
        } finally {
            lock.unlock();
        }
    }
}
