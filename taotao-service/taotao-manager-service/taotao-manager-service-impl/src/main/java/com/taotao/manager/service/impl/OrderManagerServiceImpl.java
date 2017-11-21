package com.taotao.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.taotao.manager.pojo.Order;
import com.taotao.manager.service.OrderManagerService;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderManagerServiceImpl implements OrderManagerService {
    @Override
    public Order findOrderById() {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUserId("2017");
        order.setCreateTime(new Date());
        return order;
    }
}
