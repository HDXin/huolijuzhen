package com.sudaotech.redis.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.Storable;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.util.JsonUtil;

public class RedisStoreServiceImpl extends BaseServiceImpl implements RedisStoreService {

    /**
     * 键分隔符
     */
    public static final String KEY_SEPARATOR = "-";


    @Inject
    private RedisService redisService;

    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void store(Storable store) {
        store(store, store.getClass());
    }

    @Override
    public void store(Storable store, Class<? extends Storable> keyType) {
        String key = buildStorableKey(store, keyType);

        lock.lock();
        try {
            String value = JsonUtil.toJson(new RedisValue(store));
            redisService.set(key, value);

            if (store.getExpires() > 0) {
                redisService.expire(key, store.getExpires());
            }

            logger.debug("Store: {}={}", key, store);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear(Serializable storableId, Class<? extends Storable> keyType) {
        String key = buildStorableKey(storableId, keyType);
        lock.lock();
        try {
            redisService.del(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public <T extends Storable> T get(Serializable storableId, Class<? extends Storable> keyType) {
        List<T> list = this.get(Arrays.asList(storableId), keyType);
        return list.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Storable> List<T> get(List<Serializable> storableIds, Class<? extends Storable> keyType) {
        List<String> keys = buildStorableKeys(storableIds, keyType);
        List<String> values = redisService.get(keys);
        List<T> result = new ArrayList<T>(keys.size());

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = values.get(i);
            
            T obj = null;
            if (!StringUtils.isBlank(value)) {
                RedisValue storableValue = JsonUtil.fromJsonQuietly(value, RedisValue.class);
                if (storableValue != null) {
                    Class<?> type = storableValue.getType();
                    obj = (T)JsonUtil.fromJsonQuietly(storableValue.getJson(), type);
                }
                
                // 数据存在问题，则删除key
                if (obj == null) {
                    redisService.del(key);
                }
            }
            
            result.add(obj);
        }
        
        return result;
    }

    private String buildStorableKey(Storable storable, Class<? extends Storable> keyType) {
        return buildStorableKey(storable.getStorableId(), keyType);
    }

    private List<String> buildStorableKeys(List<Serializable> storableIds, Class<? extends Storable> keyType) {
        List<String> list = new ArrayList<String>(storableIds.size());
        for (Serializable storableId : storableIds) {
            list.add(this.buildStorableKey(storableId, keyType));
        }
        
        return list;
    }

    private String buildStorableKey(Serializable storableId, Class<? extends Storable> keyType) {
        return keyType.getName() + KEY_SEPARATOR + storableId;
    }

}
