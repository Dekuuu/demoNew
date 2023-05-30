package com.example.demo.config.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.lang.Nullable;
import org.springframework.util.backoff.BackOff;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * kafka 消费端错误异常处理配置，继承SeekToCurrentErrorHandler，增强handle方法，当原队列的topic达到重试上限次数时，commit offset
 */
public class KafkaConsumerErrorHandler extends SeekToCurrentErrorHandler {

    public KafkaConsumerErrorHandler() {
    }

    public KafkaConsumerErrorHandler(@Nullable BiConsumer<ConsumerRecord<?, ?>, Exception> recoverer, BackOff backOff) {
        super(recoverer, backOff);
    }

    @Override
    public void handle(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container){
        super.handle(thrownException,records,consumer,container);
        //           执行父类的handle方法，如果有报错，说明消费重试次数还没达到上限值，此时不用commit 原topic 的offset，直接让错误往外抛出
//        如果没有报错，说明原队列消费成功或者消费次数已达到上限，此时需要commit原队列的topic
        consumer.commitSync();
    }
}
