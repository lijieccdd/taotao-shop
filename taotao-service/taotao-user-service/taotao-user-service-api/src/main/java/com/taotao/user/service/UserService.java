package com.taotao.user.service;

import com.taotao.user.pojo.User;

/**
 * Created by dell on 2018/1/30.
 */
public interface UserService {
    User selectByPrimaryKey(Long id);
}
