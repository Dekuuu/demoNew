package com.example.demo.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * kafka消费者 消费重试策略
 */
@Configuration
@Slf4j
public class KafkaConsumerConfiguration {

    @Bean
    @Primary
    public ErrorHandler kafkaErrorHandler(KafkaTemplate<?, ?> template) {
        log.warn("kafkaErrorHandler begin to Handle");
        // <1> 创建 DeadLetterPublishingRecoverer 对象
        ConsumerRecordRecoverer recoverer = new DeadLetterPublishingRecoverer(template);

//        -todo 如果达到最大次数了，如何将该消息commit，不commit的话，重启后会一直消费该消息
        // <2> 创建 FixedBackOff 对象   设置重试间隔 10秒 次数为 2 次
        // 创建 DeadLetterPublishingRecoverer 对象，它负责实现，在重试到达最大次数时，Consumer 还是消费失败时，该消息就会发送到死信队列。
        // 注意，正常发送 1 次，重试 2 次，等于一共 3 次
        BackOff backOff = new FixedBackOff(10 * 1000L, 2L);
        // <3> 创建 SeekToCurrentErrorHandler 对象
        return new KafkaConsumerErrorHandler(recoverer, backOff);
    }
}
