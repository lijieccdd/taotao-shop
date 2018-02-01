package com.taotao.content.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : lijie
 * @Description : 内容管理服务启动类
 * @Date : Create in 2018/1/31 19:49
 * @Modified by :
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.taotao.content"})
public class ContentServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApp.class, args);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
