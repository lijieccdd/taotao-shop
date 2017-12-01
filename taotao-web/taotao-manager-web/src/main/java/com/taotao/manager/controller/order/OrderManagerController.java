package com.taotao.manager.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.manager.service.OrderManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderManager")
public class OrderManagerController {
    @Reference
    private OrderManagerService orderManagerService;

    @RequestMapping("/findOrderById")
    public String findOrderById(){
        return orderManagerService.findOrderById();
    }
}
