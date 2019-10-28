package com.lyy.note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired 
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedis(){
		/*
		 * String name = redisTemplate.opsForValue().get("name");
		 * System.out.println("name:"+name);
		 */
    }
	/*
	 * @Test public void add(){ String name= "zy";
	 * redisTemplate.opsForValue().set("name", name); }
	 */
    
    
    
    
}
