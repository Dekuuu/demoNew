package com.example.demo.service.impl;

import com.example.demo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class ThreadServiceImpl implements ThreadService {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public void MultiThread() {
//        执行打印的顺序，1、2、3、4、5、8、9、10、6、7
//        当前执行的线程数少于CORE_POOL_SIZE时，创建新的线程
//        达到CORE_POOL_SIZE后，有新的线程提交，放到等待队列中
//        继续有新的线程提交，且等待队列已经满了，判断当前执行的线程是否小于MAX_POOL_SIZE，小于就创建新的线程执行，等待队列中的还在等
//        大于就根据拒绝策略来返回
            for (int i = 0; i < 10 ; i++){
                threadPoolExecutor.submit(() -> {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000);
                    }catch (InterruptedException e){
                        System.out.println("异常了");
                    }
                });
            }

    }
}
