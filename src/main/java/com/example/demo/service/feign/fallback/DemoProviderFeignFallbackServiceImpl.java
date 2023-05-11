package com.example.demo.service.feign.fallback;

import com.example.demo.service.feign.DemoProviderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoProviderFeignFallbackServiceImpl implements DemoProviderFeignService {
    @Override
    public String getMyName() {
        log.info("call demo-provider getMyName fall");
        return null;
    }
}
