package com.example.demo.utils;

import com.example.demo.entity.CronConfig;
import com.example.demo.testservice.TestService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * 定时任务工具类
 */
//@Configuration
//@Log4j2
//public class CronUtil implements SchedulingConfigurer {
//    @Autowired
//    private TestService testServiceImpl;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(
////                定时任务执行的内容，无论任务是否开启都需每隔一段时间执行
//                () -> {
//                    ifOpen();
//                },
//                triggerContext -> {
//                    String time = null;
//                    //                    数据库中获取定时任务的执行时间
//                    time = testServiceImpl.queryCronTimeByKey("test1");
////                    时间校验
//                    if (time == null || "".equals(time)) {
//                        log.info("定时时间格式有误!");
//                    }
//                    return new CronTrigger(time).nextExecutionTime(triggerContext);
//                });
//    }
//
//    public void ifOpen() {
//        String switchResult = testServiceImpl.querySwitchByKey("test1");
//        if ("on".equals(switchResult)) {
////            定时任务处于开启状态
//            log.info("执行定时任务");
//        } else {
////            定时任务处于关闭的状态
//            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>定时任务已经关闭!");
//        }
//    }
//}
