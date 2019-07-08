package org.apframework.jsr.pluggable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/7/8 14:46
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface ApTimer {
    // Statement index of Start and End for measurement.
    int[] value() default {
            /* inclusive */ 0,
            /* inclusive */ Integer.MAX_VALUE
    };
}
