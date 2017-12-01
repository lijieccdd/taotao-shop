package com.taotao.manager.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("1112");
        return "index";
    }
}
