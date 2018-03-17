package com.taotao.manager.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.taotao.content.pojo.Content;
import com.taotao.content.service.ContentService;
import com.taotao.core.pojo.common.EasyUIDataGridResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : lijie
 * @Description : 内容管理控制层
 * @Date : Create in 2018/2/1 10:49
 * @Modified by :
 */
@RestController
@RequestMapping("/content")
public class ContentController {
    @Reference
    ContentService contentService;

    @RequestMapping("/list")
    public EasyUIDataGridResult selectContentPage(Content content){
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        PageInfo<Content> contentPageInfo = contentService.selectPageInfo(content);
        easyUIDataGridResult.setRows(contentPageInfo.getList());
        easyUIDataGridResult.setTotal(contentPageInfo.getTotal());
        return  easyUIDataGridResult;
    }
}
