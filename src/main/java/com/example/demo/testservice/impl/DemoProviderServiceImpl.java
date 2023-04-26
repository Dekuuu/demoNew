package com.example.demo.testservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.AppConstants;
import com.example.demo.testservice.DemoProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoProviderServiceImpl implements DemoProviderService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getMyName() throws Exception{
        StringBuilder sb = new StringBuilder().append(AppConstants.DEMO_PROVIDER);
        sb.append("/test/getMyName");
        String template = restTemplate.getForObject(sb.toString(), String.class);
        JSONObject jsonObject = JSONObject.parseObject(template);
        if ((Integer)jsonObject.get("status") == 200){
            String data = (String) jsonObject.get("data");
            return data;
        }else {
            throw new Exception("sth error");
        }
    }
}
