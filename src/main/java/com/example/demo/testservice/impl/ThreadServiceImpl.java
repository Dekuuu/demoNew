package com.example.demo.testservice.impl;

import com.example.demo.testservice.ThreadService;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class ThreadServiceImpl implements ThreadService {
    /**
     * 核心线程数量
     */
    private final int CORE_POOL_SIZE = 5;

    /**
     * 最大线程数量
     */
//    private final int MAX_POOL_SIZE = 10;
    private final int MAX_POOL_SIZE = 6;

    /**
     * 超过核心线程数量的线程的最大空闲时间
     */
    private final int KEEP_ALIVE_TIME = 2;

    /**
     * 等待队列，有无界队列LinkedBlockingDeque和有界队列ArrayBlockingDeque
     */
    private BlockingDeque<Runnable> workingQueue = new LinkedBlockingDeque<>(2);

    @Override
    public void MultiThread() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                workingQueue);

//        执行打印的顺序，1、2、3、4、5、8、9、10、6、7
//        当前执行的线程数少于CORE_POOL_SIZE时，创建新的线程
//        达到CORE_POOL_SIZE后，有新的线程提交，放到等待队列中
//        继续有新的线程提交，且等待队列已经满了，判断当前执行的线程是否小于MAX_POOL_SIZE，小于就创建新的线程执行，等待队列中的还在等
//        大于就根据拒绝策略来返回
            for (int i = 0; i < 10 ; i++){
                final int index = i + 1;
                threadPoolExecutor.submit(() -> {
                    System.out.println("当前线程" + index);
                    try {
                        Thread.sleep(10000);
                    }catch (InterruptedException e){
                        System.out.println("异常了");
                    }
                });
            }

    }
}
