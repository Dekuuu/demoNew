package com.example.demo.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * 线程池配置
 */
@Configuration
@EnableAsync
@Log4j2
public class ExecutorConfig {
    /**
     * 核心线程数量
     */
    public static final int CORE_POOL_SIZE = 5;

    /**
     * 最大线程数量
     */
//    private final int MAX_POOL_SIZE = 10;
    public static final int MAX_POOL_SIZE = 6;

    /**
     * 超过核心线程数量的线程的最大空闲时间
     */
    public static final int KEEP_ALIVE_TIME = 2;

    /**
     * 等待队列，有无界队列LinkedBlockingDeque和有界队列ArrayBlockingDeque
     */
    private BlockingDeque<Runnable> workingQueue = new LinkedBlockingDeque<>(2);

    @Bean
    @Primary
    public ThreadPoolExecutor asyncServiceExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                workingQueue,
                new ThreadPoolExecutor.DiscardOldestPolicy());
        return threadPoolExecutor;
    }
}
