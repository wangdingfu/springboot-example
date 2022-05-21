package com.fuge.example.annotation;

import com.fuge.example.constants.ExampleConstants;
import com.fuge.example.enumtype.ExampleEnum;
import com.fuge.example.pojo.vo.ExampleDetailVO;

import java.lang.annotation.*;
import java.math.BigDecimal;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExampleAnnotation {
    int big() default 0;



    String string() default "";

    ExampleEnum value() default ExampleEnum.EXAMPLE;


    Class<?> clazz();
}
