package com.fuge.example.enumtype;

import java.lang.annotation.*;

/**
 * @author wangdingfu
 * @date 2022-08-06 23:28:50
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PmsKey {

    String value() default "";
}
