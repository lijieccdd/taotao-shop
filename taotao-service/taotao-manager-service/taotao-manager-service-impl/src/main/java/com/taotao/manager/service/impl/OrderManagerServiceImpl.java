package com.taotao.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manager.mapper.TbContentMapper;
import com.taotao.manager.pojo.TbContent;
import com.taotao.manager.pojo.TbContentExample;
import com.taotao.manager.service.OrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderManagerServiceImpl implements OrderManagerService {
    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public String findOrderById() {
        PageHelper.startPage(1,2);
        List<TbContent> tbContentList = tbContentMapper.selectByExample(new TbContentExample());
        PageInfo<TbContent> tbContentPageInfo = new PageInfo<TbContent>(tbContentList);
        System.out.println(tbContentPageInfo.getTotal());
        return "111";
    }
}
