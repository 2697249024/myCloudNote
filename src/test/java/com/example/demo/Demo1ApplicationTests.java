package com.example.demo;

import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Test
	public void contextLoads() {
		//Stream 流
		
		List<String> list = Arrays.asList("aaa","ddd","bbb","ccc","a2a","d2d","b2b","c2c","a3a","d3d","b3b","c3c");
		//滤出只包含”a”的元素
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).contains("a")) {
//				System.out.println(list.get(i));
//			}
//		}
		
		//list.stream().filter((s) -> s.contains("a")).forEach(s -> System.out.println(s));
		//去重
		List<String> disList = Arrays.asList("aaa","ddd","bbb","ddd","aaa");
		List<String> list2 = disList.stream().distinct().collect(Collectors.toList());
		
		list2.stream().forEach(s -> System.out.println(s));
		list2.stream().forEach(System.out::println);
		
		
		
	}
	

}
