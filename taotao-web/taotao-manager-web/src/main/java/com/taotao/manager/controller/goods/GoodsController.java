package com.taotao.manager.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.taotao.core.pojo.common.EasyUIDataGridResult;
import com.taotao.goods.pojo.Goods;
import com.taotao.goods.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class GoodsController {
    @Reference
    private GoodsService goodsService;

    @RequestMapping("/findItemList")
    public EasyUIDataGridResult findItemList(Goods goods){
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        PageInfo<Goods> tbItemPageInfo = goodsService.selectGoodsPage(goods);
        easyUIDataGridResult.setRows(tbItemPageInfo.getList());
        easyUIDataGridResult.setTotal(tbItemPageInfo.getTotal());
        return easyUIDataGridResult;
    }
}
