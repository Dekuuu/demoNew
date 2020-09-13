package com.example.demo.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.testservice.TestService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

/**
 *接受消息队列信息
 */
//@Component
public class KafkaConsumer {
    @Autowired
    private TestService testServiceImpl;

    @KafkaListener(topics = "demo1")
    public void listen(ConsumerRecord<?,?> record){
        System.out.println("接收到topic："+record.topic()+" offset："+record.offset()+" value："+record.value());
    }

    @KafkaListener(topics = "demo2")
    public void listen2(ConsumerRecord<?,?> record){
        //offset从0开始数，可以起到一个限流的效果
        testServiceImpl.testKafka(record.offset());
    }

    @KafkaListener(topics = "mysqlSkr")
    public void listen3(ConsumerRecord<?, String> record){
        testServiceImpl.insertUser(JSONObject.parseObject(record.value(),User.class));
    }

    @KafkaListener(topics = "mysqlSkrUpdate")
    public void listen4(ConsumerRecord<?, String> record){
        testServiceImpl.updateUser(JSONObject.parseObject(record.value(),User.class));
    }
}
