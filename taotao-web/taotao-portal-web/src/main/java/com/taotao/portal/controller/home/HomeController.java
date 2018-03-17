package com.taotao.portal.controller.home;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.content.pojo.Content;
import com.taotao.content.service.ContentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author : lijie
 * @Description : 首页控制层
 * @Date : Create in 2018/2/1 10:11
 * @Modified by :
 */
@Controller
public class HomeController {
    @Value("home.adCategoryId")
    private Long adCategoryId;

    @Reference
    ContentService contentService;

    /**
     * 默认跳转到首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String login(Model model){
        Content adContent = new Content();
        adContent.setCategoryId(adCategoryId);
        List<Content> adContendList = contentService.selectList(adContent);
        model.addAttribute("ad1",adContendList);
        return "index";
    }

    /**
     * 跳转到webroot下页面
     * @param page 页面名称
     * @return
     */
    @RequestMapping("page/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    /**
     * 跳转到webroot下文件夹+页面
     * @param page 页面名称
     * @param dir 目录
     * @return
     */
    @RequestMapping("page/{dir}/{page}")
    public String dispatcheDirPage(@PathVariable String page,@PathVariable String dir){
        return dir+"/"+page;
    }
}
