package com.taotao.portal.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : lijie
 * @Description :
 * @Date : Create in 2018/2/1 10:02
 * @Modified by :
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.taotao.portal"})
public class PortalWebApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PortalWebApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PortalWebApp.class,args);
    }
}
