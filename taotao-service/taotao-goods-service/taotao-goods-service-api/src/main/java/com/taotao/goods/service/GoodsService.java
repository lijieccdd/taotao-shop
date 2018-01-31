package com.taotao.goods.service;

import com.github.pagehelper.PageInfo;
import com.taotao.goods.pojo.Goods;

/**
 * 商品服务接口
 * Created by dell on 2018/1/30.
 */
public interface GoodsService {
    /**
     * 分页查询-商品列表
     * @param goods
     * @return
     */
    PageInfo<Goods> selectGoodsPage(Goods goods);
}
