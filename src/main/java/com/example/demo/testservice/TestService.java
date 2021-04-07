package com.example.demo.testservice;

import com.example.demo.entity.CronConfig;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 功能描述: 创建JWT认证<br>
     * @Param: []
     * @Return: java.lang.String
     * @Author: wwg
     * @Date: 2021-04-07 17:19
     */
    String createJWT(String userName,String pwd);

    /**
     * 功能描述: 解析token<br>
     * @Param: [token]
     * @Return: java.util.Map<java.lang.String,java.lang.String>
     * @Author: wwg
     * @Date: 2021-04-07 17:29
     */
    Map<String,String> parseJWT(String token);
}
