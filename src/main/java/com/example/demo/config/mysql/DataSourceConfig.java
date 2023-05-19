//package com.example.demo.config.mysql;
//
//import com.example.demo.Enum.DBTypeEnum;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
//* Description: 数据源配置，配置主数据源和从数据源，返回数据源路由<br/>
//* @author: wuwenguang<br/>
//* @date: 2020/4/1 14:50<br/>
//* @param:<br/>
//* @return:
//*/
//@Configuration
//public class DataSourceConfig {
//    @Bean
//    @ConfigurationProperties("spring.datasource.master")
//    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.slave1")
//    public DataSource slave1DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
//                                          @Qualifier("slave1DataSource") DataSource slave1DataSource) {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
//        targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
//        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
//        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
//        myRoutingDataSource.setTargetDataSources(targetDataSources);
//        return myRoutingDataSource;
//    }
//}
