package com.taotao.content.service;

import com.taotao.content.pojo.ContentCat;
import com.taotao.core.service.BaseService;

/**
 * @Author : lijie
 * @Description : 内容分类服务层接口定义
 * @Date : Create in 2018/1/31 19:22
 * @Modified by :
 */
public interface ContentCatService extends BaseService<ContentCat>{
    void delete(Long id);
}
