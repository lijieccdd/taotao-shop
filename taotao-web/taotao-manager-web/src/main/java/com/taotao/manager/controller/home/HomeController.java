package com.taotao.manager.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("page/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @RequestMapping("page/{dir}/{page}")
    public String dispatcheDirPage(@PathVariable String page,@PathVariable String dir){
        return dir+"/"+page;
    }
}
