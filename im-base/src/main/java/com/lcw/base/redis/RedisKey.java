package com.lcw.base.redis;


import com.lcw.base.utils.StringUtils;

public class RedisKey {

    private static final String REDIS_PREFIX = "";
    private static final String REDIS_SEPARATOR = "_";
    public static final String LOGIN_USER = "LOGIN_USER";
    public static final String LOGIN_STATE = "LOGIN_STATE";
    public static final String LOGIN_FAIL_COUNT = "LOGIN_FAIL_COUNT";
    public static final String LOCK = "LOCK";
    public static final String IM_MINE = "IM_MINE";
    public static final String IM_FRIENDS = "IM_FRIENDS";
    public static final String IM_GROUPS = "IM_GROUPS";

    private static String key(String redisPrefix, String type, String businessId) {
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotEmpty(redisPrefix)) {
            sb.append(redisPrefix).append(REDIS_SEPARATOR);
        }
        sb.append(type);
        if (StringUtils.isNotEmpty(businessId)) {
            sb.append(REDIS_SEPARATOR).append(businessId);
        }
        return sb.toString();
    }

    public static String key(String type, String businessId) {
        return key(REDIS_PREFIX, type, businessId);
    }

    public static String key(String type) {
        return key(REDIS_PREFIX, type, null);
    }

    public static String keyOfLoginUser(String key) {
        return key(LOGIN_USER, key);
    }

    public static String keyOfLoginState(String key) {
        return key(LOGIN_STATE, key);
    }

    public static String keyOfLoginFailCount(String key) {
        return key(LOGIN_FAIL_COUNT, key);
    }

    public static String keyOfLock(String key) {
        return key(LOCK, key);
    }

    public static String keyOfImMine(String key) {
        return key(IM_MINE, key);
    }

    public static String keyOfImFriends(String key) {
        return key(IM_FRIENDS, key);
    }

    public static String keyOfImGroups(String key) {
        return key(IM_GROUPS, key);
    }

}
