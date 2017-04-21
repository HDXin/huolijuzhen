package com.sudaotech.cache.service;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sudaotech.core.Cachable;
import com.sudaotech.core.service.BaseServiceImpl;

public class CacheServiceGuavaImpl extends BaseServiceImpl implements CacheService {
    private final Cache<Object, Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    @Override
    public void clearCache() {
        this.cache.invalidateAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T cache(final Cachable<T> cachable) {
        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                T value = cachable.getValue();
                logger.debug("Set-Cache: {}={}", cachable.getKey(), value);
                return value;
            }
        };

        try {
            return (T) this.cache.get(cachable.getKey(), callable);
        } catch (Exception e) {
            this.logger.error("Cache Exception: {}", e.getMessage(), e);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T clear(Object key) {
        Object object = this.cache.getIfPresent(key);
        this.cache.invalidate(key);
        return (T) object;
    }
}
