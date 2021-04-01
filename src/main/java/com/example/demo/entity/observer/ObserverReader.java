package com.example.demo.entity.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * 功能描述: 观察者模式 观察者<br>
 * @Param:
 * @Return:
 * @Author: wwg
 * @Date: 2021-04-01 18:00
 */
@Data
@AllArgsConstructor
public class ObserverReader implements Observer {
    private String name;
    @Override
    public void update(Observable o, Object arg) {
//        传的参数o进来是 目标对象
        System.out.println("我是观察者" + this.name);
    }
}
