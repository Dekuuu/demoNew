package com.example.demo.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BeanCopyUtils {

    public static <S, T> List<T> copyListProperties(List<S> sources , Supplier<T> target){
        List<T> targets = new ArrayList<>(sources.size());
        for(S source : sources){
            T  temp = target.get();
            BeanUtils.copyProperties(source,temp);
            targets.add(temp);
        }
        return targets;
    }
}
