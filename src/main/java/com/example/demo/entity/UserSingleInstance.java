package com.example.demo.entity;

import lombok.Data;
/**
 * 单例,懒汉式
 *
 */
@Data
public class UserSingleInstance {
    private String userName;
    private String userPassword;
    private int age;
    public static UserSingleInstance user = null;

    private UserSingleInstance(){

    }

    public static UserSingleInstance getInstance(){
        if(user == null){
            synchronized (UserSingleInstance.class){
                if(user == null){
                    user = new UserSingleInstance();
                }
            }
        }
        return user;
    }
}
