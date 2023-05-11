package com.example.demo.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *接受消息队列信息
 */
@Component
public class KafkaConsumer {
//    @Autowired
//    private TestService testServiceImpl;

    @KafkaListener(topics = "demo1")
    public void listen(ConsumerRecord<?,?> record){
        System.out.println("接收到topic："+record.topic()+
                " partrition"+record.partition() +
                " offset："+record.offset()+" value："+record.value());
    }

//    @KafkaListener(topics = "demo2")
//    public void listen2(ConsumerRecord<?,?> record){
//        //offset从0开始数，可以起到一个限流的效果
//        testServiceImpl.testKafka(record.offset());
//    }
}
