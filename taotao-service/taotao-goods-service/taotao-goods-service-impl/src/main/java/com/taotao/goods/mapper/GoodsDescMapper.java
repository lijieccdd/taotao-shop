package com.taotao.goods.mapper;

import com.taotao.goods.pojo.GoodsDesc;

public interface GoodsDescMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    GoodsDesc selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKeyWithBLOBs(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);
}