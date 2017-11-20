package com.taotao.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.taotao.manager.service.OrederManagerService;

@Service
public class OrderManagerServiceImpl implements OrederManagerService{
    @Override
    public void findOrderById() {
        System.out.println("111");
    }
}
