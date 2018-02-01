package com.taotao.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.goods.mapper.GoodsParamMapper;
import com.taotao.goods.pojo.GoodsParam;
import com.taotao.goods.service.GoodsParamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class GoodsParamServiceImpl implements GoodsParamService{
    @Autowired
    GoodsParamMapper goodsParamMapper;

    @Override
    public PageInfo<GoodsParam> selectPageInfo(GoodsParam goodsParam) {
        return null;
    }

    @Override
    public List<GoodsParam> selectList(GoodsParam goodsParam) {
        return null;
    }

    @Override
    public void insert(GoodsParam goodsParam) {

    }

    @Override
    public void update(GoodsParam goodsParam) {

    }
}
