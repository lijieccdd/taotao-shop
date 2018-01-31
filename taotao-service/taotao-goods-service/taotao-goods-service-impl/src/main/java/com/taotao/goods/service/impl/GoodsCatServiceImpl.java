package com.taotao.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.taotao.goods.mapper.GoodsCatMapper;
import com.taotao.goods.pojo.GoodsCat;
import com.taotao.goods.service.GoodsCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dell on 2018/1/30.
 */
@Service
public class GoodsCatServiceImpl implements GoodsCatService{
    @Autowired
    GoodsCatMapper goodsCatMapper;
    @Override
    public List<GoodsCat> selectGoodsCatListByModel(GoodsCat goodsCat) {
       /* List<GoodsCat> tbItemCatList = goodsCatMapper.selectGoodsCatListByModel(goodsCat);

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
        }*/
        return goodsCatMapper.selectGoodsCatListByModel(goodsCat);
    }
}
