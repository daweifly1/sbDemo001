package com.devi.tool.netease;

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
@Target(ElementType.FIELD)
public @interface CollumComment {

    String value() default "";

    int length() default 255;

    boolean nullAble() default true;
}
