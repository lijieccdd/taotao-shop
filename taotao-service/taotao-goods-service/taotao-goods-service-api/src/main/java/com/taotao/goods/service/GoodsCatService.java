package com.taotao.goods.service;

import com.taotao.goods.pojo.GoodsCat;

import java.util.List;

/**
 * 商品分类服务接口
 * Created by dell on 2018/1/30.
 */
public interface GoodsCatService {
    List<GoodsCat> selectGoodsCatListByModel(GoodsCat goodsCat);
}
