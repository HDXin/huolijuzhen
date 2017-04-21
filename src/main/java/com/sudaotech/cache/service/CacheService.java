package com.sudaotech.cache.service;

import com.sudaotech.core.Cachable;

public interface CacheService {
    public <T> T cache(Cachable<T> cache);
    public <T> T clear(Object key);

    public void clearCache();
}
