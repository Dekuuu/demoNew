package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "users")
public class User {
    private String userName;
    private String userPassword;
    private int age;

    /**
     * 对象被GC时，会调用finalized方法
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("user recycle due to GC");
    }


}
