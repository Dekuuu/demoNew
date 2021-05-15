package com.example.demo.testservice.impl;

import com.example.demo.testservice.KafkaProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduceServiceImpl implements KafkaProduceService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send() {
        for(int i = 0; i< 10;i++){
            kafkaTemplate.send("demo1",i + "","message_"+i);
        }

        for(int i = 9; i >= 0;i--){
            kafkaTemplate.send("demo1",i + "","message_"+ i + "later");
        }
    }
}
