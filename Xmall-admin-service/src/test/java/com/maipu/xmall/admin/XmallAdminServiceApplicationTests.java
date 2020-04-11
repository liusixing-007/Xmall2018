package com.maipu.xmall.admin;

import com.maipu.xmall.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class XmallAdminServiceApplicationTests {

    @Autowired
    RedisUtil redisUtil;
    @Test
    void contextLoads() {
        Jedis jedis = redisUtil.getJedis();
        System.out.println(jedis);
    }

}
