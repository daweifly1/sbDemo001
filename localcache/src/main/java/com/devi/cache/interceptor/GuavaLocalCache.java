package com.devi.cache.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hzchendawei on 2017/9/8.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GuavaLocalCache {

    //最大數量
    int maxSize() default 1000;

    //过期时间（秒）
    int expireTime() default 60;

    int refreshTime() default 30;

    String group() default "default";

    String preFix() default "guava";
}
