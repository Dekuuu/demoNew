package com.example.demo.controller;

import com.example.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/account")
@Api(tags = "用户认证")
public class LoginController {
    @Resource
    private TestService testService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(String userName,String pwd){
        return testService.createJWT(userName,pwd);
    }

    @ApiOperation(value = "验证token")
    @RequestMapping(value = "check",method = RequestMethod.GET)
    public String check(String token){
        Map<String, String> parseJWT = testService.parseJWT(token);

        return "success";
    }
}
