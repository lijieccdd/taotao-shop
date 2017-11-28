package com.taotao.manager.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:spring/spring-consumer.xml" })
public class DubboConfig {
  
}  