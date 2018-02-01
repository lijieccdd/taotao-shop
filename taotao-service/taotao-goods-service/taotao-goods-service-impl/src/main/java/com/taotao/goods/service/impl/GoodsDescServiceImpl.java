package com.taotao.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.goods.mapper.GoodsDescMapper;
import com.taotao.goods.pojo.GoodsDesc;
import com.taotao.goods.service.GoodsDescService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService{
    @Autowired
    GoodsDescMapper goodsDescMapper;

    @Override
    public PageInfo<GoodsDesc> selectPageInfo(GoodsDesc goodsDesc) {
        return null;
    }

    @Override
    public List<GoodsDesc> selectList(GoodsDesc goodsDesc) {
        return null;
    }

    @Override
    public void insert(GoodsDesc goodsDesc) {

    }

    @Override
    public void update(GoodsDesc goodsDesc) {

    }
}
