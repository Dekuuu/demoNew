package com.example.demo.testservice.impl;

import com.example.demo.entity.observer.ObserverObject;
import com.example.demo.entity.observer.ObserverReader;
import com.example.demo.testservice.ObserverService;
import org.springframework.stereotype.Service;

@Service
public class ObserverServiceImpl implements ObserverService {


    @Override
    public void test() {
        ObserverObject object = new ObserverObject();
        object.setName("目标对象");

        ObserverReader read1 = new ObserverReader("观察者1");
        ObserverReader read2 = new ObserverReader("观察者2");
        object.addObserver(read1);
        object.addObserver(read2);

        object.print();
    }
}
