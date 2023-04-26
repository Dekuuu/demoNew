package com.example.demo.annotation.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自定义切面
 */
@Aspect
@Component
@Log4j2
public class DemoAspect {

    //定义切面，对应的controller下的方法且该方法有TestAnnotation注释标识，才能触发到该方法
    @Pointcut("execution(public * com.example.demo.controller.TestController.*(..)) && @annotation(com.example.demo.annotation.TestAnnotation)" )
    public void addAdvice(){};

    @Before("addAdvice()")
    public void before(){
        log.info("执行before消息");
    }

    @After("addAdvice()")
    public void after(){
        log.info("执行after后的消息");
    }
}
