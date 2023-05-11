package com.example.demo.service;

/**
 * restTemplate的方式调用微服务，不建议，建议用feign
 */
public interface DemoProviderService {
    String getMyName() throws Exception;
}
