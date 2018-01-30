package com.taotao.manager.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.taotao.core.pojo.EasyUIDataGridResult;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.pojo.TbItemExample;
import com.taotao.manager.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class GoodsController {
    @Reference
    private ItemService itemService;

    @RequestMapping("/findItemList")
    public EasyUIDataGridResult findItemList(TbItemExample tbItemExample){
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        PageInfo<TbItem> tbItemPageInfo = itemService.findItemList(tbItemExample);
        easyUIDataGridResult.setRows(tbItemPageInfo.getList());
        easyUIDataGridResult.setTotal(tbItemPageInfo.getTotal());
        return easyUIDataGridResult;
    }
}
