package com.taotao.order.startup;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by dell on 2018/1/30.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.taotao.order"})
public class OrderServiceApp {
    public static void main(String[] args) {

    }
}
