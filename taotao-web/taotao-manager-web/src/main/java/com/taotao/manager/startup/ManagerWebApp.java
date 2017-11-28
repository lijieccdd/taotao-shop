package com.taotao.manager.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.taotao.manager"})
public class ManagerWebApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApp.class,args);
    }
}
