package com.taotao.portal.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : lijie
 * @Description : 首页控制层
 * @Date : Create in 2018/2/1 10:11
 * @Modified by :
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String login(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @RequestMapping("/{dir}/{page}")
    public String dispatcheDirPage(@PathVariable String page,@PathVariable String dir){
        return dir+"/"+page;
    }
}
