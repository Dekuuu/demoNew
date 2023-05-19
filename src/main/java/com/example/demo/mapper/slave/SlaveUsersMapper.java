package com.example.demo.mapper.slave;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;

import java.util.List;

@DS("slave1")
public interface SlaveUsersMapper extends BaseMapper<User> {
    List<User> queryUsers();
}
