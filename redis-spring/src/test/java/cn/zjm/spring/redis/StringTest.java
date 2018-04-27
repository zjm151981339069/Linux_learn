package cn.zjm.spring.redis;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.data.redis.core.ValueOperations;

public class StringTest extends BaseTest {

	@Test
	public void test() {
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.set("1", "1");
		System.out.println(opsForValue.get("1"));

		opsForValue.set("key2", "hello world");
		redisTemplate.opsForValue().set("name", "tom", 100, TimeUnit.SECONDS);

		opsForValue.set("key2", "redis", 0);
		System.out.println("***************" + redisTemplate.opsForValue().get("key2"));

	}
	@Test
	public void testc() {
		Integer i = new Integer(257);
		System.err.println(i.byteValue());
	}
	@Test
	public void test3() {
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("multi1", "multi1");
		maps.put("multi2", "multi2");
		maps.put("multi3", "multi3");
		redisTemplate.opsForValue().multiSet(maps);
		List<String> keys = new ArrayList<String>();
		keys.add("multi1");
		keys.add("multi2");
		keys.add("multi3");
		System.out.println(redisTemplate.opsForValue().multiGet(keys));
	}

	@Test
	public void getandset() {
		System.out.println(template.opsForValue().get("getSetTest"));
		template.opsForValue().set("getSetTest", "test");
		System.out.println(template.opsForValue().getAndSet("getSetTest", "test2"));

		// template.opsForValue().set("appendTest","test");
		template.opsForValue().append("appendTest", "Hello");
		System.out.println(template.opsForValue().get("appendTest"));
		template.opsForValue().append("appendTest", "world");
		System.out.println(template.opsForValue().get("appendTest"));
	}

	@Test
	public void name() {
		template.opsForValue().set("appendTest","Hello");
		template.opsForValue().append("appendTest","Hello");
	      System.out.println(template.opsForValue().get("appendTest"));
	      template.opsForValue().append("appendTest","world");
	      System.out.println(template.opsForValue().get("appendTest"));

	}
	@Test
	public void nameget() {
		template.opsForValue().set("bitTest","a");
	      // 'a' 的ASCII码是 97。转换为二进制是：01100001
	      // 'b' 的ASCII码是 98  转换为二进制是：01100010
	      // 'c' 的ASCII码是 99  转换为二进制是：01100011
	      //因为二进制只有0和1，在setbit中true为1，false为0，因此我要变为'b'的话第六位设置为1，第七位设置为0
	      System.out.println(template.opsForValue().get("bitTest"));

	}
}
