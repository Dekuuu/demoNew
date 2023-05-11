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
            "&& (execution(* com.example.demo.service..*.query*(..)) " +
            "|| execution(* com.example.demo.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.demo.annotation.Master) " +
            "|| execution(* com.example.demo.service..*.insert*(..)) " +
            "|| execution(* com.example.demo.service..*.add*(..)) " +
            "|| execution(* com.example.demo.service..*.update*(..)) " +
            "|| execution(* com.example.demo.service..*.edit*(..)) " +
            "|| execution(* com.example.demo.service..*.delete*(..)) " +
            "|| execution(* com.example.demo.service..*.remove*(..))")
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
