package test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taotao.common.service.IRedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : lijie
 * @Description :
 * @Date : Create in 2018/2/5 10:01
 * @Modified by :
 */
public class RedisConfigTest extends AbstractSpringTest{
    @Autowired
    IRedisService iRedisService;

    @Test
    public void setStr(){
        iRedisService.set("1fda","1fa");
    }
}
