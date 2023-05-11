package com.example.demo.service.feign;

import com.example.demo.service.feign.fallback.DemoProviderFeignFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "demo-provider",fallback = DemoProviderFeignFallbackServiceImpl.class)
@Service
public interface DemoProviderFeignService {
    @RequestMapping(value = "/test/getMyName",method = RequestMethod.GET)
    String getMyName();
}
