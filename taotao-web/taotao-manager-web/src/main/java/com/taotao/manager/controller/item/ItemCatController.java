package com.taotao.manager.controller.item;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.core.pojo.EasyUITreeNode;
import com.taotao.manager.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类控制层
 * Created by lijie on 2017/12/17.
 */
@Controller
@RequestMapping("itemCat")
public class ItemCatController {
    @Reference
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping("list")
    public List<EasyUITreeNode> findItemCatList(@RequestParam(name = "id",defaultValue = "0")long parentId){
        List<EasyUITreeNode> easyUITreeNodeList = itemCatService.findItemCatList(parentId);
        return easyUITreeNodeList;
    }
}
