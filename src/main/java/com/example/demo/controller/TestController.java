package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserSingleInstance;
import com.example.demo.service.TestService;
import com.example.demo.entity.User;
import com.example.demo.service.ThreadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/testController/")
@Api(value = "测试接口",tags = {"test-services"})
@CrossOrigin(origins = "*", maxAge = 3600)              //支持跨域，origins为可访问的地址，maxAge:准备响应前的 缓存持续的 最大时间
public class TestController {
    @Autowired
    private TestService testServiceImpl;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Resource
    private ThreadService threadService;

    @ApiOperation(value = "测试方法二")
    @PostMapping(value = "test2")
    public User test2(@RequestBody User user){
        return user;
    }

    @ApiOperation(value = "测试方法三，模拟多个请求")
    @GetMapping(value = "testKafka")
    public String test4(){
        int id = RandomUtils.nextInt();
        kafkaTemplate.send("demo1",id + "");      //发送消息到指定的topic
        return "success";
    }

    @ApiOperation(value = "测试方法三，模拟多个请求")
    @GetMapping(value = "testKafka2")
    public String test5(String id){
        kafkaTemplate.send("demo2",id);      //发送消息到指定的topic
        return "success";
    }

    @ApiOperation(value = "测试连接数据库")
    @GetMapping(value = "testmysql")
    public String test6(){
        User user = new User();
        user.setUserName("ttt");
        user.setUserPassword("mkkk");
        user.setUserName("tt");
        testServiceImpl.insertUser(user);
        return "success";
    }

    @ApiOperation(value = "线程测试")
    @GetMapping(value = "thread")
    public String thread(){
        threadService.MultiThread();
        return "";
    }

    @ApiOperation(value = "获取单例")
    @GetMapping(value = "getSingle")
    public String getSingle(){
        UserSingleInstance userSingleInstance = UserSingleInstance.getInstance();
        return "";
    }

    @ApiOperation(value = "测试redis")
    @GetMapping(value = "redis")
    public String redisTest() throws Exception{
        return testServiceImpl.redisTest();
    }

    @ApiOperation(value = "测试版本升级")
    @GetMapping(value = "testUpgrade")
    public String testUpgrade(){
        return "upgrade";
    }

    @ApiOperation(value = "测试查询")
    @GetMapping(value = "testQuery")
    public String testQuery(){
        List<User> users = testServiceImpl.queryUsers();
        for(User user : users){
            System.out.println(user.getUserName());
        }
        return "success";
    }
}
