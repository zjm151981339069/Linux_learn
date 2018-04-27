package cn.zjm.spring.redis;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest extends BaseTest {

	@Test
	public void test() {
		template.opsForList().leftPush("list", "java");
		template.opsForList().leftPush("list", "python");
		template.opsForList().leftPush("list", "c++");

	}

	@Test
	public void print() {
		System.out.println(template.opsForList().range("list", 0, -1));

	}

	@Test
	public void testName() throws Exception {
		System.out.println(template.opsForList().range("list", 0, -1));
		template.opsForList().trim("list", 1, -1);// 裁剪第一个元素
		System.out.println(template.opsForList().range("list", 0, -1));
	}

	@Test
	public void testName1() throws Exception {
		System.out.println(template.opsForList().size("listRight"));
	}

	@Test
	public void leftpush() throws Exception {
		String[] stringarrays = new String[] { "1", "2", "3" };
		template.opsForList().leftPush("listarray", stringarrays);
		System.out.println(template.opsForList().range("listarray", 0, -1));
	}

	@Test
	public void leftPushIfPresent() throws Exception {
		System.out.println(template.opsForList().leftPushIfPresent("leftPushIfPresent", "aa"));
		System.out.println(template.opsForList().leftPushIfPresent("leftPushIfPresent", "bb"));
		System.out.println(template.opsForList().leftPush("leftPushIfPresent", "aa"));
		System.out.println(template.opsForList().leftPushIfPresent("leftPushIfPresent", "bb"));
	}
	
	@Test
	public void leftpushon() throws Exception {
		template.opsForList().leftPush("list","java","oc");
	      System.out.print(template.opsForList().range("list",0,-1));
	}
	
	@Test
	public void rightpush() throws Exception {
		template.opsForList().rightPush("listRight","java");
	      template.opsForList().rightPush("listRight","python");
	      template.opsForList().rightPush("listRight","c++");
	}
	
	@Test
	public void setval() throws Exception {
		System.out.println(template.opsForList().range("listRight",0,-1));
	      template.opsForList().set("listRight",1,"setValue");
	      System.out.println(template.opsForList().range("listRight",0,-1));
	}
	
	@Test
	public void remove() throws Exception {
		System.out.println(template.opsForList().range("listRight",0,-1));
	      template.opsForList().remove("listRight",1,"setValue");//将删除列表中存储的列表中第一次次出现的“setValue”。
	      System.out.println(template.opsForList().range("listRight",0,-1));
	}
	
	@Test
	public void index() throws Exception {
		System.out.println(template.opsForList().range("listRight",0,-1));
		System.out.println(template.opsForList().index("listRight",1));
	}
	@Test
	public void rightpopandleftpush() throws Exception {
		System.out.println(template.opsForList().range("list",0,-1));
		template.opsForList().rightPopAndLeftPush("list","rightPopAndLeftPush");
		  System.out.println(template.opsForList().range("list",0,-1));
		  System.out.println(template.opsForList().range("rightPopAndLeftPush",0,-1));
	}
	
}
