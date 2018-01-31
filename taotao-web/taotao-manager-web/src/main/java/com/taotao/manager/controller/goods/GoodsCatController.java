package com.taotao.manager.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.core.enums.common.ExceptionEnum;
import com.taotao.core.exception.common.ServiceException;
import com.taotao.core.pojo.common.EasyUITreeNode;
import com.taotao.goods.pojo.GoodsCat;
import com.taotao.goods.service.GoodsCatService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类控制层
 * Created by lijie on 2017/12/17.
 */
@RestController
@RequestMapping("/itemCat")
public class GoodsCatController {
    @Reference
    private GoodsCatService goodsCatService;

    @RequestMapping("/list")
    public List<EasyUITreeNode> selectGoodsCatList(@RequestParam(name = "id",defaultValue = "0")long parentId){
        GoodsCat goodsCat = new GoodsCat();
        goodsCat.setParentId(parentId);

        List<GoodsCat> goodsCatList = goodsCatService.selectGoodsCatListByModel(goodsCat);
        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();

        if(!CollectionUtils.isEmpty(goodsCatList)){
            goodsCatList.forEach(tbItemCat -> {
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

    @RequestMapping("/testError")
    public void testError(){
        throw new ServiceException(ExceptionEnum.UNKNOW_ERROR);
    }
}
