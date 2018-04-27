package cn.zjm.spring.redis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.jpa.boot.scan.spi.ScanOptions;
import org.junit.Test;

public class SetTest extends BaseTest {

	@Test
	public void test() {
		String[] strarrays = new String[]{"strarr1","sgtarr2"};
		template.opsForSet().add("setTest","aaa");
		template.opsForSet().add("setTest","bbb");
//	      System.out.println(template.opsForSet().add("setTest", strarrays));

	}
	
	@Test
	public void member() throws Exception {
		Set members = template.opsForSet().members("setTest");
		Iterator iterator = members.iterator();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}
	@Test
	public void pop() throws Exception {
		System.out.println(template.opsForSet().pop("setTest"));
		System.out.println(template.opsForSet().members("setTest"));
	}
	
	@Test
	public void intersect() throws Exception {
		System.out.println(template.opsForSet().members("setTest"));
	      System.out.println(template.opsForSet().members("setTest2"));
	      System.out.println(template.opsForSet().intersect("setTest","setTest2"));
	}
	
	@Test
	public void intersectList() throws Exception {
		System.out.println(template.opsForSet().members("setTest"));
        System.out.println(template.opsForSet().members("setTest2"));
        System.out.println(template.opsForSet().members("setTest3"));
        List<String> strlist = new ArrayList<String>();
        strlist.add("setTest2");
        strlist.add("setTest3");
        System.out.println(template.opsForSet().intersect("setTest",strlist));
	}
	
	@Test
	public void intersectAndStore() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
		System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
		System.out.println(template.opsForSet().intersectAndStore("setTest","setTest2","destKey1"));
		System.out.println(template.opsForSet().members("destKey1"));
	}
	
	@Test
	public void intersectAndStoreList() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println("setTest3:" + template.opsForSet().members("setTest3"));
	      List<String> strlist = new ArrayList<String>();
	      strlist.add("setTest2");
	      strlist.add("setTest3");
	      System.out.println(template.opsForSet().intersectAndStore("setTest",strlist,"destKey2"));
	      System.out.println(template.opsForSet().members("destKey2"));
	}
	
	@Test
	public void union() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println(template.opsForSet().union("setTest","setTest2"));
	}
	
	@Test
	public void unionList() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println("setTest3:" + template.opsForSet().members("setTest3"));
	      List<String> strlist = new ArrayList<String>();
	      strlist.add("setTest2");
	      strlist.add("setTest3");
	      System.out.println(template.opsForSet().union("setTest",strlist));
	}
	@Test
	public void unionAndStoreList() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println("setTest3:" + template.opsForSet().members("setTest3"));
	      List<String> strlist = new ArrayList<String>();
	      strlist.add("setTest2");
	      strlist.add("setTest3");
	      System.out.println(template.opsForSet().unionAndStore("setTest",strlist,"unionAndStoreTest2"));
	      System.out.println("unionAndStoreTest2:" + template.opsForSet().members("unionAndStoreTest2"));
	}
	@Test
	public void difference() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println(template.opsForSet().difference("setTest","setTest2"));
	}
	
	@Test
	public void differenceList() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println("setTest3:" + template.opsForSet().members("setTest3"));
	      List<String> strlist = new ArrayList<String>();
	      strlist.add("setTest2");
	      strlist.add("setTest3");
	      System.out.println(template.opsForSet().difference("setTest",strlist));
	}
	
	@Test
	public void differenceAndStore() throws Exception {
		System.out.println("setTest:" + template.opsForSet().members("setTest"));
	      System.out.println("setTest2:" + template.opsForSet().members("setTest2"));
	      System.out.println(template.opsForSet().differenceAndStore("setTest","setTest2","differenceAndStore1"));
	      System.out.println("differenceAndStore1:" + template.opsForSet().members("differenceAndStore1"));
	}
	
	@Test
	public void members() throws Exception {
		System.out.println(template.opsForSet().members("setTest"));
	}
	
	
	

}
