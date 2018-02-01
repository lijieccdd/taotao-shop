package com.taotao.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.content.mapper.ContentMapper;
import com.taotao.content.pojo.Content;
import com.taotao.content.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author : lijie
 * @Description :内容管理服务层实现类
 * @Date : Create in 2018/1/31 19:31
 * @Modified by :
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    ContentMapper contentMapper;

    @Override
    public PageInfo<Content> selectPageInfo(Content content) {
        PageHelper.startPage(content.getPage(),content.getRows());
        List<Content> contentList = contentMapper.selectListByModel(content);
        PageInfo<Content> contentPageInfo = new PageInfo<Content>(contentList);
        return contentPageInfo;
    }

    @Override
    public List<Content> selectList(Content content) {
        return contentMapper.selectListByModel(content);
    }

    @Override
    public void insert(Content content) {
        contentMapper.insertSelective(content);
    }

    @Override
    public void update(Content content) {
        contentMapper.updateByPrimaryKeySelective(content);
    }
}
