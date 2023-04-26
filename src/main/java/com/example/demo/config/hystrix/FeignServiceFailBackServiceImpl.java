package com.example.demo.config.hystrix;

import com.example.demo.entity.User;
import com.example.demo.entity.request.UserReq;
import com.example.demo.config.feign.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

// hystrix与feign整合，异常处理类实现feign接口中的各个方法，同时feign接口中要定义fallback的类
@Slf4j
@Component
public class FeignServiceFailBackServiceImpl implements FeignService {
    @Override
    public User test1(UserReq userReq) {
        log.info("test1接口调用失败");
        return null;
    }

    @Override
    public User test2(String id) {
        return null;
    }
}
