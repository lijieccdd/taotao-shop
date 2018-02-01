package com.taotao.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.goods.mapper.GoodsCatMapper;
import com.taotao.goods.pojo.GoodsCat;
import com.taotao.goods.service.GoodsCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class GoodsCatServiceImpl implements GoodsCatService{
    @Autowired
    GoodsCatMapper goodsCatMapper;

    @Override
    public PageInfo<GoodsCat> selectPageInfo(GoodsCat goodsCat) {
        return null;
    }

    @Override
    public List<GoodsCat> selectList(GoodsCat goodsCat) {
        return goodsCatMapper.selectGoodsCatListByModel(goodsCat);
    }

    @Override
    public void insert(GoodsCat goodsCat) {
        goodsCatMapper.insert(goodsCat);
    }

    @Override
    public void update(GoodsCat goodsCat) {
        goodsCatMapper.updateByPrimaryKeySelective(goodsCat);
    }
}
