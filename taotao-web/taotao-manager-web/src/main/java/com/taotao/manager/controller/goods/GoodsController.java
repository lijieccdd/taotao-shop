package com.taotao.manager.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.taotao.core.pojo.common.EasyUIDataGridResult;
import com.taotao.core.pojo.common.Result;
import com.taotao.core.util.common.ResultUtil;
import com.taotao.goods.pojo.Goods;
import com.taotao.goods.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    private GoodsService goodsService;

    /**
     * 查询商品列表-分页
     * @param goods
     * @return
     */
    @RequestMapping("/selectGoodsList")
    public EasyUIDataGridResult selectGoodsList(Goods goods){
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        PageInfo<Goods> tbItemPageInfo = goodsService.selectGoodsPage(goods);
        easyUIDataGridResult.setRows(tbItemPageInfo.getList());
        easyUIDataGridResult.setTotal(tbItemPageInfo.getTotal());
        return easyUIDataGridResult;
    }

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @RequestMapping("/updateGoods")
    public Result updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return ResultUtil.success();
    }

    /**
     * 添加商品信息
     * @param goods
     * @return
     */
    @RequestMapping("/insertGoods")
    public Result insertGoods(Goods goods){
        goodsService.insertGoods(goods);
        return ResultUtil.success();
    }
}
