package com.taotao.goods.mapper;

import com.taotao.goods.pojo.Goods;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);
    List<Goods> selectGoodsList(Goods goods);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}