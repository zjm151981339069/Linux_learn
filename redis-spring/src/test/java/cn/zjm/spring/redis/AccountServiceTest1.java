package cn.zjm.spring.redis;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.fep.redis.RedisTemplateUtil;
import com.test.fep.redis.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountServiceTest1 {
	@Autowired
	private RedisUtil redisUtil; // 记得注入
    @Autowired @Qualifier("redisTemplateUtil")
	private RedisTemplateUtil redisTemplateUtil;
    
    @Autowired @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;  

	

	@Test
	public void test1() {
		System.out.println(redisUtil);
		redisUtil.set("key", "123");
		Object object = redisUtil.get("key");
		System.out.println(object);
		System.out.println(redisUtil.exists("key"));
	}
	
	@Test
	public void test2() {
		Map<String, String> map  = new HashMap<String, String>();
		map.put("1", "11");
		map.put("2", "22");
		redisUtil.setSet("key", map);
		System.out.println(redisUtil.exists("key"));
	}
  
}