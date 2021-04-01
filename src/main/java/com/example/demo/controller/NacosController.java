package com.example.demo.controller;

import com.example.demo.annotation.TestAnnotation;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/nacos/")
@Api(value = "测试接口",tags = {"test-services"})
@CrossOrigin(origins = "*", maxAge = 3600)              //支持跨域，origins为可访问的地址，maxAge:准备响应前的 缓存持续的 最大时间
@RefreshScope
public class NacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${myName:空}")
    private String name;

    @Value("${mysql.ip:空}")
    private String ip;

    @ApiOperation(value = "测试方法一")
    @GetMapping(value = "test")
    @TestAnnotation(name = "注解方法")
    public User test1(String id){
        String url = "http://demo-service-new/testController/test";
        return restTemplate.getForObject(url,User.class);
    }

    @ApiOperation(value = "获取配置")
    @GetMapping(value = "getConfig")
    public String getConfig(){
        return name;
    }

    @ApiOperation(value = "获取ip")
    @GetMapping(value = "getIp")
    public String getIp(){
        return ip;
    }
}
