package com.fuge.example.annotation;

import com.fuge.example.enumtype.ExampleEnum;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExampleAnnotation {

    ExampleEnum value() default ExampleEnum.EXAMPLE;


    Class<?> clazz();
}
