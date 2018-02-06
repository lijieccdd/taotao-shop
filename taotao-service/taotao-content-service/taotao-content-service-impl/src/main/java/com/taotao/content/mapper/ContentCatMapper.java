package com.taotao.content.mapper;

import com.taotao.content.pojo.ContentCat;

import java.util.List;

public interface ContentCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContentCat record);

    void insertSelective(ContentCat record);

    ContentCat selectByPrimaryKey(Long id);
    List<ContentCat> selectList(ContentCat contentCat);

    int updateByPrimaryKeySelective(ContentCat record);

    int updateByPrimaryKey(ContentCat record);
}