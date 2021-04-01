package com.example.demo.controller;

import com.example.demo.testservice.ObserverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/observer")
@Api(tags = "观察者")
public class ObserverController {
    @Resource
    private ObserverService observerService;

    @ApiOperation(value = "测试观察者...")
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        observerService.test();
        return "success";
    }
}
