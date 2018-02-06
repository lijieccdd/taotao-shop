package com.taotao.manager.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.content.pojo.ContentCat;
import com.taotao.content.service.ContentCatService;
import com.taotao.core.pojo.common.EasyUITreeNode;
import com.taotao.core.pojo.common.Result;
import com.taotao.core.util.common.ResultUtil;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : lijie
 * @Description :内容管理分类控制层
 * @Date : Create in 2018/2/1 10:49
 * @Modified by :
 */
@RestController
@RequestMapping("/contentCat")
public class ContentCatController {
    @Reference
    ContentCatService contentCatService;

    @RequestMapping("/selectContentCatTree")
    public List<EasyUITreeNode> selectContentCatTree(@RequestParam(name = "id",defaultValue = "0")long parentId){
        ContentCat contentCat = new ContentCat();
        contentCat.setParentId(parentId);

        List<ContentCat> contentCatList = contentCatService.selectList(contentCat);
        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(contentCatList)){
            contentCatList.forEach(contentCatRs -> {
                EasyUITreeNode node = new EasyUITreeNode();
                node.setId(contentCatRs.getId());
                node.setText(contentCatRs.getName());
                //如果节点下有子节点“closed”，如果没有子节点“open”
                node.setState(contentCatRs.getIsParent()?"closed":"open");
                //添加到节点列表
                easyUITreeNodeList.add(node);
            });
        }
        return easyUITreeNodeList;
    }

    @RequestMapping("/insertContentCat")
    public Result insertContentCat(ContentCat contentCat){
        Long id = contentCatService.insertWithReturn(contentCat);
        return ResultUtil.success(id);
    }

    @RequestMapping("/updateContentCat")
    public Result updateContentCat(ContentCat contentCat){
        contentCatService.update(contentCat);
        return ResultUtil.success();
    }

    @RequestMapping("/deleteContentCat")
    public Result deleteContentCat(ContentCat contentCat){
        contentCatService.delete(contentCat);
        return ResultUtil.success();
    }
}
