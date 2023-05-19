//package com.example.demo.config.mysql;
//
//import com.example.demo.utils.DBContextHolder;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import reactor.util.annotation.Nullable;
//
///**
//* Description: 数据源路由<br/>
//* @author: wuwenguang<br/>
//* @date: 2020/4/1 14:49<br/>
//* @param:<br/>
//* @return:
//*/
//public class MyRoutingDataSource extends AbstractRoutingDataSource {
//    @Nullable
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return DBContextHolder.get();
//    }
//}
