package com.taotao.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.taotao.core.pojo.EasyUITreeNode;
import com.taotao.manager.mapper.TbItemCatMapper;
import com.taotao.manager.pojo.TbItemCat;
import com.taotao.manager.pojo.TbItemCatExample;
import com.taotao.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类查询实现类
 * Created by lijie on 2017/12/12.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> findItemCatList(Long parentId) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(tbItemCatExample);

        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(tbItemCatList)){
            tbItemCatList.forEach(tbItemCat -> {
                EasyUITreeNode node = new EasyUITreeNode();
                node.setId(tbItemCat.getId());
                node.setText(tbItemCat.getName());
                //如果节点下有子节点“closed”，如果没有子节点“open”
                node.setState(tbItemCat.getIsParent()?"closed":"open");
                //添加到节点列表
                easyUITreeNodeList.add(node);
            });
        }

        return easyUITreeNodeList;
    }
}
