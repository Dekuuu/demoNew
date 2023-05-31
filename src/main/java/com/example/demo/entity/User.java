package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.annotation.EncryptTransaction;
import com.example.demo.annotation.SensitiveData;
import lombok.Data;

@Data
@TableName(value = "users")
@SensitiveData
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    @EncryptTransaction  //标注需要自动加解密
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
