package test;

import com.taotao.common.startup.CommonServiceApp;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommonServiceApp.class)
//@ActiveProfiles("test")
//@WebAppConfiguration
/**
 * If you have any property file to load to test uncomment below line) 
   @TestPropertySource({
   "classpath:/properties/dbConfig-test.properties",
   "classpath:/properties/unittest.properties"
   })
*/
public abstract class AbstractSpringTest{}