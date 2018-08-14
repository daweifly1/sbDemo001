package com.devi.cache.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hzchendawei on 2017/9/8.
 */
//@Repeatable
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GuavaLocalCache {

    //最大數量
    int maxSize() default 1000;

    //过期时间（秒）
    int expireTime() default 20;

    int refreshTime() default 5;

    String group() default "default";

    String preFix() default "guava";

    /**
     * 是否缓存空
     *
     * @return
     */
    boolean nullAble() default true;

    /**
     * 缓存key具体参数，支持SPEL表达式； 完整缓存key为  preFix +  keyExt
     *
     * @return
     */
    String keyExt() default "";
}
