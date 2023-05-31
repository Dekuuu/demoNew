package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 拥有该标记的类，表示需要加密
 */
@Retention(RetentionPolicy.RUNTIME)         //定义注解的保留策略，注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.TYPE)        //定义注解的作用目标，作用在类上
public @interface SensitiveData {

}
