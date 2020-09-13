package com.example.demo.testservice;

import com.example.demo.entity.CronConfig;
import com.example.demo.entity.User;

import java.util.List;

/**
 * 测试业务层
 */
public interface TestService {
    /**
     * 测试定时任务
     */
    public void testCron();

    /**
     * 测试定时任务
     */
    public void testCronTwo();

    public void minionsQue();

    public void testKafka(long number);

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

    public String querySwitchByKey(String key);

    public String queryCronTimeByKey(String key);


    public List<String> queryTestAll();

    public int insertTest();
}
