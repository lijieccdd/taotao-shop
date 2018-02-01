package com.taotao.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.order.mapper.OrderShippingMapper;
import com.taotao.order.pojo.OrderShipping;
import com.taotao.order.service.OrderShippingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class OrderShippingServiceImpl implements OrderShippingService{
    @Autowired
    OrderShippingMapper orderShippingMapper;

    @Override
    public PageInfo<OrderShipping> selectPageInfo(OrderShipping orderShipping) {
        return null;
    }

    @Override
    public List<OrderShipping> selectList(OrderShipping orderShipping) {
        return null;
    }

    @Override
    public void insert(OrderShipping orderShipping) {

    }

    @Override
    public void update(OrderShipping orderShipping) {

    }
}
