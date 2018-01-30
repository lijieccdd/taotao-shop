package com.taotao.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.taotao.user.mapper.UserMapper;
import com.taotao.user.pojo.User;
import com.taotao.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
