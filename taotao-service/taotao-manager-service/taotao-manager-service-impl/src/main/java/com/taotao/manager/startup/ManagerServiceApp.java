package com.taotao.manager.startup;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.taotao.manager"})
public class ManagerServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ManagerServiceApp.class, args);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
