package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.util.ChangeDateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Test
	public void contextLoads() {
		
		String timeParam1 = "2019-09-20 01:29:00";
		String transferTime = ChangeDateUtil.transferTime(timeParam1);
		System.out.println("transferTime:"+transferTime);
		
		
		
//		Integer addtime = 60;
//		String prothromiTime = "0055";
//		String addTime2 = ChangeDateUtil.reduceTime(addtime, prothromiTime);
//		System.out.println(addTime2);
		
//		String timeParam1 = "0110";
//		String timeParam2 = "0110";
//		ChangeDateUtil.compareTime(timeParam1, timeParam2);
		
		
		
//		List<String> changeDateIncludeWednesdayBefore = ChangeDateUtil.ChangeDateExclusiveWednesdayBefore(2);
//		changeDateIncludeWednesdayBefore.stream().forEach(System.out::println);
//		
		
		//Stream 流
		
		//List<String> list = Arrays.asList("aaa","ddd","bbb","ccc","a2a","d2d","b2b","c2c","a3a","d3d","b3b","c3c");
		//滤出只包含”a”的元素
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).contains("a")) {
//				System.out.println(list.get(i));
//			}
//		}
		
		//list.stream().filter((s) -> s.contains("a")).forEach(s -> System.out.println(s));
		//去重
//		List<String> disList = Arrays.asList("aaa","ddd","bbb","ddd","aaa");
//		List<String> list2 = disList.stream().distinct().collect(Collectors.toList());
//		
//		list2.stream().forEach(s -> System.out.println(s));
//		list2.stream().forEach(System.out::println);
		
		
		
	}
	

}
