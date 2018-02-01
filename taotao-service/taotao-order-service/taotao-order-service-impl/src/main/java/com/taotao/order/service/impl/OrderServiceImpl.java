package com.taotao.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.order.mapper.OrderMapper;
import com.taotao.order.pojo.Order;
import com.taotao.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo<Order> selectPageInfo(Order order) {
        return null;
    }

    @Override
    public List<Order> selectList(Order order) {
        return null;
    }

    @Override
    public void insert(Order order) {

    }

    @Override
    public void update(Order order) {

    }
}
