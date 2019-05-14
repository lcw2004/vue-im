package com.lcw.base.redis;

import com.lcw.base.spring.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    private static RedisUtil redisUtil = null;
    public static RedisUtil getInstance () {
        if (redisUtil == null) {
            redisUtil = SpringContextHolder.getBean(RedisUtil.class);
        }
        return redisUtil;
    }

    public void remove(String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public void removePattern(String pattern) {
        Set<Serializable> keys = this.redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            this.redisTemplate.delete(keys);
        }

    }

    public void remove(String key) {
        if (exists(key)) {
            this.redisTemplate.delete(key);
        }
    }

    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key).booleanValue();
    }

    public <T> T get(String key) {
        T result = null;
        ValueOperations<Serializable, T> operations = this.redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public <T> boolean set(String key, T value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, T> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <T> boolean set(String key, T value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, T> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <T> boolean setSet(String key, Set<T> set) {
        boolean result = false;
        try {
            SetOperations<Serializable, T> operations = this.redisTemplate.opsForSet();
            operations.add(key, (T) set.toArray());
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <T> Set<T> getSet(String key) {
        SetOperations<Serializable, T> operations = this.redisTemplate.opsForSet();
        return operations.members(key);
    }

    public <T> void appendSetValue(String key, T... values) {
        SetOperations<Serializable, T> operations = this.redisTemplate.opsForSet();
        operations.add(key, values);
    }

    public <T> boolean removeSetValue(String key, T... values) {
        boolean result = false;
        try {
            SetOperations<Serializable, T> operations = this.redisTemplate.opsForSet();
            operations.remove(key, values);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void expire(String key, Long expireTime) {
        this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 锁住资源，如果资源已经被锁住了，返回false，如果成功锁住资源，返回true，60秒钟后自动解锁
     * @param key
     * @return
     */
    public boolean lock(String key) {
        return lock(key, 60L);
    }

    /**
     * 锁住资源，如果资源已经被锁住了，返回false，如果成功锁住资源，返回true，指定时间后自动解锁
     * @param key
     * @return
     */
    public boolean lock(String key, long time) {
        String newKey = RedisKey.keyOfLock(key);
        if(exists(newKey)) {
            return false;
        }

        return set(newKey, "1", time);
    }

    /**
     * 重新设置锁的失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean activeLock(String key, long time) {
        return set( RedisKey.keyOfLock(key), "1", time);
    }

    /**
     * 解锁资源
     * @param key
     * @return
     */
    public boolean unlock(String key) {
        remove(RedisKey.keyOfLock(key));
        return true;
    }
}

