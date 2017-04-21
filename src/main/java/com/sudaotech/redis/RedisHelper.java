package com.sudaotech.redis;

import redis.clients.jedis.JedisPoolConfig;

import com.sudaotech.util.BeanUtils;

public class RedisHelper {
    private static JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    static {
        RedisConfig redisConfig = RedisConfig.getInstance();
        BeanUtils.copyProperties(redisConfig, jedisPoolConfig, true);
    }

    public static JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }
}
