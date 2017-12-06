package com.taotao.manager.service;

import com.github.pagehelper.PageInfo;
import com.taotao.manager.pojo.TbItem;
import com.taotao.manager.pojo.TbItemExample;

public interface ItemService {
    PageInfo<TbItem> findItemList(TbItemExample tbItem);
}
