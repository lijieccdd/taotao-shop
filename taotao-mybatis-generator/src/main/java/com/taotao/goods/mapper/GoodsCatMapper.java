package com.taotao.goods.mapper;

import com.taotao.goods.pojo.GoodsCat;

public interface GoodsCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsCat record);

    int insertSelective(GoodsCat record);

    GoodsCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCat record);

    int updateByPrimaryKey(GoodsCat record);
}