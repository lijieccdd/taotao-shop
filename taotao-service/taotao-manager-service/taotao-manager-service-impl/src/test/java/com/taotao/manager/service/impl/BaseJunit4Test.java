package com.taotao.manager.service.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml","classpath:spring/spring-provider.xml"
        ,"classpath:spring/spring-trans.xml"})//加载spring配置文件
public class BaseJunit4Test {
}
