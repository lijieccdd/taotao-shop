package com.taotao.manager.service;

import com.taotao.core.pojo.common.EasyUITreeNode;

import java.util.List;

/**
 * 商品分类服务
 * Created by lijie on 2017/12/12.
 */
public interface ItemCatService {
    /**
     * 通过父id查找其所有商品分类子类
     * @param parentId 父id
     * @return
     */
    List<EasyUITreeNode> findItemCatList(Long parentId);
}
