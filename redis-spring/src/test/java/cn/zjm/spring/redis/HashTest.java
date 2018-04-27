package cn.zjm.spring.redis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class HashTest extends BaseTest {
	@Test
	public void hashput() throws Exception {
		template.opsForHash().put("redisHash","name","tom");
	      template.opsForHash().put("redisHash","age",27);
	      template.opsForHash().put("redisHash","class","6");
	System.out.println(template.opsForHash().entries("redisHash"));
	}
	
	@Test
	public void hashputAll() throws Exception {
		Map<String,Object> testMap = new HashMap();
	      testMap.put("name","jack");
	      testMap.put("age",27);
	      testMap.put("class","1");
	      template.opsForHash().putAll("redisHash1",testMap);
	      System.out.println(template.opsForHash().entries("redisHash1"));
	}
	
	@Test
	public void testName() throws Exception {
		System.out.println(template.opsForHash().putIfAbsent("redisHash","age",30));
		System.out.println(template.opsForHash().putIfAbsent("redisHash","kkk1","kkk"));
	}
	
	@Test
	public void value() throws Exception {
		System.out.println(template.opsForHash().values("redisHash"));
		System.out.println(template.opsForHash().size("redisHash1"));
		System.out.println(template.opsForHash().keys("redisHash1"));
		
		System.out.println(template.opsForHash().get("redisHash","age"));
//		  System.out.println(template.opsForHash().increment("redisHash","age",(long) 1.1));
	}
	
	@Test
	public void multGet() throws Exception {
		List<Object> kes = new ArrayList<Object>();
	      kes.add("name");
	      kes.add("age");
	      System.out.println(template.opsForHash().multiGet("redisHash",kes));
	      
	      System.out.println(template.opsForHash().hasKey("redisHash","age"));
	      System.out.println(template.opsForHash().hasKey("redisHash","ttt"));
	}
	
	@Test
	public void delete() throws Exception {
		template.opsForHash().delete("redisHash","kkk1");
	      System.out.println(template.opsForHash().entries("redisHash"));
	}
}
