package com.devi.test.cache;

/**
 * Created by hzchendawei on 2017/9/6.
 */
public enum Caches {
    ELEMENT_COMMON(8640000, 10, 5);

    public static final int DEFAULT_MAXSIZE = 50000;
    public static final int DEFAULT_TTL = 10;

    private int maxSize = DEFAULT_MAXSIZE;    //最大數量
    private int expireTime = DEFAULT_TTL;        //过期时间（秒）
    private int refreshTime = DEFAULT_TTL >> 1;        //刷新时间（秒）

    Caches(int maxSize, int expireTime, int refreshTime) {
        this.maxSize = maxSize;
        this.expireTime = expireTime;
        this.refreshTime = refreshTime;
    }

    Caches(int maxSize) {
        this.maxSize = maxSize;
    }

    Caches(int maxSize, int expireTime) {
        this.maxSize = maxSize;
        this.expireTime = expireTime;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public int getRefreshTime() {
        return refreshTime;
    }
}
