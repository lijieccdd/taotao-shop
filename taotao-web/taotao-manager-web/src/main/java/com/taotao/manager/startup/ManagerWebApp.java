package com.taotao.manager.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @SpringBootApplication 等同于 @Configuration @EnableAutoConfiguration @ComponentScan的集合
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.taotao.manager"})
public class ManagerWebApp extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManagerWebApp.class);
    }

    /**
     * web项目 直接运行main好像访问不了 需要通过maven spring-boot:run才能访问
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApp.class,args);
    }
}
