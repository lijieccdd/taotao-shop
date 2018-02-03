package com.taotao.goods.mapper;

import com.taotao.goods.pojo.GoodsParam;

public interface GoodsParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsParam record);

    int insertSelective(GoodsParam record);

    GoodsParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsParam record);

    int updateByPrimaryKeyWithBLOBs(GoodsParam record);

    int updateByPrimaryKey(GoodsParam record);
}