package com.taotao.core.service;

import com.github.pagehelper.PageInfo;
import com.taotao.core.exception.common.ServiceException;

import java.util.List;

/**
 * @Author : lijie
 * @Description :服务层接口定义抽象接口
 * @Date : Create in 2018/1/31 19:26
 * @Modified by :
 */
public interface BaseService<T> {
    /**
     * 分页查询
     * @param t
     * @return
     */
    PageInfo<T> selectPageInfo(T t) throws ServiceException;

    /**
     * 查询列表
     * @param t
     * @return
     */
    List<T> selectList(T t) throws ServiceException;

    /**
     * 添加
     * @param t
     */
    void insert(T t) throws ServiceException;

    /**
     * 更新
     * @param t
     */
    void update(T t) throws ServiceException;
}
