package com.taotao.manager.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String login(){
        System.out.println("1112");
        return "login";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
