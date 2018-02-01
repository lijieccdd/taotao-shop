package com.taotao.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.order.mapper.OrderItemMapper;
import com.taotao.order.pojo.OrderItem;
import com.taotao.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 订单项服务实现类
 * Created by dell on 2018/1/30.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public PageInfo<OrderItem> selectPageInfo(OrderItem orderItem) {
        return null;
    }

    @Override
    public List<OrderItem> selectList(OrderItem orderItem) {
        return null;
    }

    @Override
    public void insert(OrderItem orderItem) {

    }

    @Override
    public void update(OrderItem orderItem) {

    }
}
