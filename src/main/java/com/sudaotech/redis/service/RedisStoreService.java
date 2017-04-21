package com.sudaotech.redis.service;

import java.io.Serializable;
import java.util.List;

import com.sudaotech.core.Storable;

public interface RedisStoreService {
    void store(Storable store);

    void store(Storable store, Class<? extends Storable> targetClass);

    <T extends Storable> T get(Serializable key, Class<? extends Storable> targetClass);

    <T extends Storable> List<T> get(List<Serializable> keys, Class<? extends Storable> targetClass);

    void clear(Serializable storableId, Class<? extends Storable> targetClass);
}
