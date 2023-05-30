package com.example.demo.config.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *接受消息队列信息
 */
@Component
public class KafkaConsumer {
//    @Autowired
//    private TestService testServiceImpl;

    @KafkaListener(topics = "demo1")
    public void listen(List<ConsumerRecord<?,?>> records, Consumer consumer) throws Exception{
        Date date = new Date();
        for(ConsumerRecord<?,?> record : records){
            System.out.println(date  + " 接收到topic： "+record.topic()+
                    " partrition: "+record.partition() +
                    " offset："+record.offset()+" value："+record.value());
//        模拟流程处理，睡个10s
            Thread.sleep(2 * 1000);
        }
//        手动提交offset
        consumer.commitSync();
    }

    @KafkaListener(topics = "demo1" + ".DLT")
    public void listenDeadLetterTopic(ConsumerRecord<?,?> record, Consumer consumer){
        Date date = new Date();
        System.out.println(date + " 接收到死信："+record.topic()+
                " partrition"+record.partition() +
                " offset："+record.offset()+" value："+record.value());
        consumer.commitSync();
    }

//    @KafkaListener(topics = "demo2")
//    public void listen2(ConsumerRecord<?,?> record){
//        //offset从0开始数，可以起到一个限流的效果
//        testServiceImpl.testKafka(record.offset());
//    }
}
