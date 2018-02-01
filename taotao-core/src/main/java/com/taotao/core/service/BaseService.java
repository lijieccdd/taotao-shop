package com.taotao.core.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author : lijie
 * @Description :
 * @Date : Create in 2018/1/31 19:26
 * @Modified by :
 */
public interface BaseService<T> {
    /**
     * 分页查询
     * @param t
     * @return
     */
    PageInfo<T> selectPageInfo(T t);

    /**
     * 查询列表
     * @param t
     * @return
     */
    List<T> selectList(T t);

    /**
     * 添加
     * @param t
     */
    void insert(T t);

    /**
     * 更新
     * @param t
     */
    void update(T t);
}
