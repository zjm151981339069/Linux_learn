package cn.zjm.spring.redis;

import org.junit.Test;

public class ZsetTest extends BaseTest {
	@Test
	public void add() throws Exception {
		System.out.println(template.opsForZSet().add("zset1","zset-1",1.0));
	}
	
//	@Test
//	public void addSet() throws Exception {
//		ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<Object>("zset-5",9.6);
//	      ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<Object>("zset-6",9.9);
//	      Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
//	      tuples.add(objectTypedTuple1);
//	      tuples.add(objectTypedTuple2);
//	      System.out.println(template.opsForZSet().add("zset1",tuples));
//	      System.out.println(template.opsForZSet().range("zset1",0,-1));
//	}
	
	@Test
	public void testName() throws Exception {
		System.out.println(template.opsForZSet().rangeByScore("zset1",0,5));
	      System.out.println(template.opsForZSet().count("zset1",0,5));
	}
}
