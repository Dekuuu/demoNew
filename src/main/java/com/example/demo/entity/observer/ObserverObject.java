package com.example.demo.entity.observer;

import lombok.Data;

import java.util.Observable;
import java.util.concurrent.CompletableFuture;

/**
 * 功能描述: 观察者模式  目标类
 *
 * 目标类中定义自己的方法<br>
 * @Param:
 * @Return:
 * @Author: wwg
 * @Date: 2021-04-01 17:59
 */
@Data
public class ObserverObject extends Observable {
    private String name;

    public void print(){
        System.out.println("目标类  打印");
//        改变状态，观察者根据状态判断
        this.setChanged();
//        通知所有的观察者，最好异步执行
        CompletableFuture.runAsync(() -> {
            this.notifyObservers();
        });
    }
}
