package com.example.demo.testservice.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.config.AppConstants;
import com.example.demo.mapper.CronConfigMapper;
import com.example.demo.mapper.TestMapper;
import com.example.demo.testservice.TestService;
import com.example.demo.entity.User;
import com.example.demo.mapper.UsersMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class TestServiceImpl implements TestService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CronConfigMapper cronConfigMapper;
    @Autowired
    private TestMapper testMapper;

//    不建议采取这种方式写定时任务，无法动态修改执行时间、是否执行定时任务
    @Override
//    @Scheduled(cron = "0 30 * * * ?")
    public void testCron() {
        System.out.println("执行......");
    }

//
    @Override
    public void testCronTwo() {

    }

    @Override
    @Async("asyncServiceExecutor")
    public void minionsQue() {
            log.info("start executeAsync");
            log.info("end executeAsync");
    }

    @Override
    public void testKafka(long number) {
        if(number>10){
            System.out.println("安啦安啦");
        }else{
            System.out.println(number);
        }
    }

    @Override
    public void insertUser(User user) {
        usersMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        usersMapper.updateUser(user);
    }

    @Override
    public String querySwitchByKey(String key) {
        return cronConfigMapper.queryCronSwitchByKey(key);
    }

    @Override
    public String queryCronTimeByKey(String key) {
        return cronConfigMapper.queryCronTimeByKey(key);
    }

    @Override
    public List<String> queryTestAll() {
        List<String> list = testMapper.queryAll();
        return list;
    }

    @Override
    public int insertTest() {
        return testMapper.insertTest();
    }

    @Override
    public String createJWT(String userName,String pwd) {
        int mins = 15 * 24 * 60 ;
        long milisSeconds = mins * 60 * 1000;
        JWTCreator.Builder builder = JWT.create();
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userName);
        params.put("password",pwd);
//        过期时间
        builder.withExpiresAt(new Date(milisSeconds + System.currentTimeMillis()));
        for(String key : params.keySet()){
            builder.withClaim(key,params.get(key).toString());
        }
        return builder.sign(Algorithm.HMAC256(AppConstants.RSA_KEY));
    }

    @Override
    public Map<String, String> parseJWT(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(AppConstants.RSA_KEY)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        Map<String,String> params = new HashMap<>();
        params.put("userId",claims.get("userId").asString());
        params.put("password",claims.get("password").asString());
        return params;
    }
}
