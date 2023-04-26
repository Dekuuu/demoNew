package com.example.demo.config.feign;


import com.example.demo.entity.User;
import com.example.demo.entity.request.UserReq;
import com.example.demo.config.hystrix.FeignServiceFailBackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "demo-service-new",fallback = FeignServiceFailBackServiceImpl.class)
@Service
public interface FeignService {

//    微服务接口定义，采用类接收参数，保证可扩展性
//    openFign get请求会自动转为post请求，解决方案：对参数添加@SpringQueryMap注解
//    @SpringQueryMap ：
    @RequestMapping(value = "/testController/test",method = RequestMethod.GET)
    public User test1(@SpringQueryMap UserReq userReq);

    @RequestMapping(value = "/testController/testId",method = RequestMethod.GET)
    public User test2(String id);
}
