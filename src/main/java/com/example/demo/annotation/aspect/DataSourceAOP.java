package com.example.demo.annotation.aspect;

import com.example.demo.utils.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
* Description: 数据Aop，自动切换数据源<br/>
* @author: wuwenguang<br/>
* @date: 2020/4/1 14:50<br/>
* @param:<br/>
* @return:
*/
@Aspect
@Component
public class DataSourceAOP {
    @Pointcut("!@annotation(com.example.demo.annotation.Master) " +
            "&& (execution(* com.example.demo.testservice..*.query*(..)) " +
            "|| execution(* com.example.demo.testservice..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.demo.annotation.Master) " +
            "|| execution(* com.example.demo.testservice..*.insert*(..)) " +
            "|| execution(* com.example.demo.testservice..*.add*(..)) " +
            "|| execution(* com.example.demo.testservice..*.update*(..)) " +
            "|| execution(* com.example.demo.testservice..*.edit*(..)) " +
            "|| execution(* com.example.demo.testservice..*.delete*(..)) " +
            "|| execution(* com.example.demo.testservice..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
