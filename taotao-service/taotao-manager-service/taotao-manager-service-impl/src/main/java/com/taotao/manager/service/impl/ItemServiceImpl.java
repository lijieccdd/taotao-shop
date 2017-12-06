package com.taotao.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manager.mapper.TbItemMapper;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.pojo.TbItemExample;
import com.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public PageInfo<TbItem> findItemList(TbItemExample tbItemExample) {
        // TODO 参数判断 异常处理
        PageHelper.startPage(tbItemExample.getPage(),tbItemExample.getRows());
        List<TbItem> tbItemList = tbItemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<TbItem>(tbItemList);
        return tbItemPageInfo;
    }
}
