package com.taotao.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.content.mapper.ContentCatMapper;
import com.taotao.content.pojo.ContentCat;
import com.taotao.content.service.ContentCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author : lijie
 * @Description : 内容分类服务层实现类
 * @Date : Create in 2018/1/31 19:31
 * @Modified by :
 */
@Service
public class ContentCatServiceImpl implements ContentCatService{
    @Autowired
    ContentCatMapper contentCatMapper;
    @Override
    public PageInfo<ContentCat> selectPageInfo(ContentCat contentCat) {
        return null;
    }

    @Override
    public List<ContentCat> selectList(ContentCat contentCat) {
        return contentCatMapper.selectList(contentCat);
    }

    @Override
    public void insert(ContentCat contentCat) {
        //添加sort_order is_parent created
        contentCatMapper.insertSelective(contentCat);
    }

    @Override
    public void update(ContentCat contentCat) {
        contentCatMapper.updateByPrimaryKeySelective(contentCat);
    }

    @Override
    public void delete(Long id) {
        //判断父节点是否还有子节点
        contentCatMapper.deleteByPrimaryKey(id);
    }
}
