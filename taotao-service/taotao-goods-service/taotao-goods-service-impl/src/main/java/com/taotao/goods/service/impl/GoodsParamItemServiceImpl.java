package com.taotao.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.goods.mapper.GoodsParamItemMapper;
import com.taotao.goods.pojo.GoodsParamItem;
import com.taotao.goods.service.GoodsParamItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class GoodsParamItemServiceImpl implements GoodsParamItemService{
    @Autowired
    GoodsParamItemMapper goodsParamItemMapper;

    @Override
    public PageInfo<GoodsParamItem> selectPageInfo(GoodsParamItem goodsParamItem) {
        return null;
    }

    @Override
    public List<GoodsParamItem> selectList(GoodsParamItem goodsParamItem) {
        return null;
    }

    @Override
    public void insert(GoodsParamItem goodsParamItem) {

    }

    @Override
    public void update(GoodsParamItem goodsParamItem) {

    }
}
