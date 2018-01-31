package com.taotao.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.core.enums.common.ExceptionEnum;
import com.taotao.core.exception.common.ServiceException;
import com.taotao.goods.mapper.GoodsMapper;
import com.taotao.goods.pojo.Goods;
import com.taotao.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> selectGoodsPage(Goods goods) {
        PageHelper.startPage(goods.getPage(),goods.getRows());
        List<Goods> goodsList = goodsMapper.selectGoodsList(goods);
        PageInfo<Goods> goodsPageInfo = new PageInfo<Goods>(goodsList);
        return goodsPageInfo;
    }

    @Override
    public void updateGoods(Goods goods) {
        if (goods==null){
            throw new ServiceException(ExceptionEnum.PARAM_ERROR);
        }
        if (goods.getId()==null){
            throw new ServiceException(ExceptionEnum.PARAM_ERROR);
        }
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public void insertGoods(Goods goods) {
        if (goods==null){
            throw new ServiceException(ExceptionEnum.PARAM_ERROR);
        }
        goodsMapper.insertSelective(goods);
    }
}
