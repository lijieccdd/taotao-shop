package com.taotao.goods.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:spring/spring-provider.xml" })
public class DubboConfig {
  
}  