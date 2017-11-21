package com.taotao.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.manager.service.OrderManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Reference
    private OrderManagerService orderManagerService;

    @ResponseBody
    @RequestMapping(value = "/findOrderById")
    public  String findOrderById(){
        orderManagerService.findOrderById();
        return "";
    }
}
