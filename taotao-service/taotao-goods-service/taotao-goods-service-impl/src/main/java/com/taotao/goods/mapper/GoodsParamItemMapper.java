package com.taotao.goods.mapper;

import com.taotao.goods.pojo.GoodsParamItem;

public interface GoodsParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsParamItem record);

    int insertSelective(GoodsParamItem record);

    GoodsParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsParamItem record);

    int updateByPrimaryKeyWithBLOBs(GoodsParamItem record);

    int updateByPrimaryKey(GoodsParamItem record);
}