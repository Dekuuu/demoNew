package com.example.demo.controller;

import com.example.demo.testservice.KafkaProduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *kafak测试控制层
 */
@RestController
@RequestMapping("/kafka")
@Api(tags = "kafaka控制层")
public class KafkaController {

    @Autowired
    private KafkaProduceService kafkaProduceService;

    @GetMapping(value = "send")
    @ApiOperation(tags = "写数据",value = "写数据")
    public String testSend(){
        kafkaProduceService.send();
        return "success";
    }
}
