package com.sudaotech.cache.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.sudaotech.core.Cachable;
import com.sudaotech.core.service.BaseServiceImpl;

public class CacheServiceImpl extends BaseServiceImpl implements CacheService {

    private static final Map<Object, Object> map = new HashMap<Object, Object>();
    private static final ReentrantLock lock = new ReentrantLock();
    @Override
    public void clearCache() {
        lock.lock();
        try {
            map.clear();
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T cache(Cachable<T> cache) {
        Object key = cache.getKey();
        if (!map.containsKey(key)) {
            lock.lock();
            try {
                if (!map.containsKey(key)) {
                    Object value = cache.getValue();
                    map.put(key, value);
                    logger.debug("Cache: {}={}", key, value);
                }
            } finally {
                lock.unlock();
            }
        }
        
        return (T)map.get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T clear(Object key) {
        lock.lock();
        try {
            return (T)map.remove(key);
        } finally {
            lock.unlock();
        }
    }
}
