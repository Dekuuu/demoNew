package com.example.demo.entity.bo;

import com.example.demo.entity.User;
import lombok.Data;

@Data
public class UserBo {

    private Long id;
    private String userName;
    private String userPassword;
    private int age;

    public User toEntity(){
        User user = new User();
        user.setAge(this.age);
        user.setId(this.getId());
        user.setUserName(this.userName);
        user.setUserPassword(this.userPassword);
        return user;
    }
}
