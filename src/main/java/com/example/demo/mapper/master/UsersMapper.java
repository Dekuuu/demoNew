package com.example.demo.mapper.master;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;

public interface UsersMapper extends BaseMapper<User> {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);
}
