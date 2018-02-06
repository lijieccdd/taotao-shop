package com.taotao.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.taotao.content.mapper.ContentCatMapper;
import com.taotao.content.pojo.Content;
import com.taotao.content.pojo.ContentCat;
import com.taotao.content.service.ContentCatService;
import com.taotao.core.enums.common.ExceptionEnum;
import com.taotao.core.exception.common.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author : lijie
 * @Description : 内容分类服务层实现类
 * @Date : Create in 2018/1/31 19:31
 * @Modified by :
 */
@Service(retries = 0)
public class ContentCatServiceImpl implements ContentCatService{
    @Autowired
    ContentCatMapper contentCatMapper;
    @Override
    public PageInfo<ContentCat> selectPageInfo(ContentCat contentCat) {
        return null;
    }

    @Override
    public List<ContentCat> selectList(ContentCat contentCat) {
        return contentCatMapper.selectList(contentCat);
    }

    @Override
    public void insert(ContentCat contentCat) throws ServiceException {

    }

    @Override
    public Long insertWithReturn(ContentCat contentCat) {
        //补全属性
        contentCat.setIsParent(false);
        //排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
        contentCat.setSortOrder(1);
        //状态。可选值:1(正常),2(删除)
        contentCat.setStatus(1);
        contentCat.setCreated(new Date());
        contentCat.setUpdated(new Date());
        contentCatMapper.insertSelective(contentCat);

        //更新父节点isParent属性
        ContentCat parentContentCat = contentCatMapper.selectByPrimaryKey(contentCat.getParentId());
        if (parentContentCat!=null){
            if (!parentContentCat.getIsParent()){
                parentContentCat.setIsParent(true);
                parentContentCat.setUpdated(new Date());
                update(parentContentCat);
            }
        }
        return contentCat.getId();
    }

    @Override
    public void update(ContentCat contentCat) {
        contentCatMapper.updateByPrimaryKeySelective(contentCat);
    }

    @Override
    public void delete(ContentCat contentCat) {
        //如果该节点为父节点不允许删除(还有一种解决方案递归删除子节点，暂时不实现)
        /*if (contentCat.getIsParent()==null){
            throw new ServiceException(ExceptionEnum.PARAM_ERROR);
        }*/
        Long id = contentCat.getId();
        ContentCat curContentCat = contentCatMapper.selectByPrimaryKey(id);
        if (curContentCat==null){
            throw new ServiceException(ExceptionEnum.CONTENTCAT_DEL_ERR2);
        }
        if (curContentCat.getIsParent()){
            throw new ServiceException(ExceptionEnum.CONTENTCAT_DEL_ERR1);
        }

        //删除该节点
        contentCatMapper.deleteByPrimaryKey(id);
        //判断父节点是否还有子节点，如果没有子节点，更新isParent为false
        ContentCat parentContentCatParam = new ContentCat();
        parentContentCatParam.setParentId(curContentCat.getParentId());
        List<ContentCat> childContentCatList = contentCatMapper.selectList(parentContentCatParam);
        if (CollectionUtils.isEmpty(childContentCatList)){
            ContentCat parentContentCat = new ContentCat();
            parentContentCat.setId(contentCat.getParentId());
            parentContentCat.setIsParent(false);
            update(parentContentCat);
        }
    }
}
