package com.lyy.note.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;

import org.springframework.util.StringUtils;


public class Lambda {
	public static void main(String[] args) {
		List<String> asList = Arrays.asList("java","java","BigDecimal","java","java8","流","时间工具类","uuid","collects","执行计划","版本"
				,"maven","工具类","util","接口","缓存","数据库","stream","BigDecimal","缓存","缓存","数据库","数据库","util","util","util","util"
				,"工具类","工具类"
				);
		//按出现次数从大到小排序 筛选出出现次数最多的前4个字符串 
		List<A> list = new ArrayList<>();
		asList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach( (key, value) -> {A a= new A(); a.name = key; a.count = value; list.add(a);});
		list.stream().sorted(Comparator.comparing(A::getCount).reversed()).limit(4).forEach( (a) -> System.out.println(a.name + ","+a.count ));
		
		System.out.println("---------------------------------------------------------------------");
		PriorityQueue<A> tyQueue = new PriorityQueue<>(Comparator.comparing(A::getCount));
		list.forEach(a -> {
			if (tyQueue.size() < 4) {
				tyQueue.add(a);
			} else {
				if (tyQueue.peek().count < a.count) {
					tyQueue.poll();
					tyQueue.add(a);
				}
			}
		});
		
		tyQueue.forEach( (a) -> System.out.println(a.name + ","+a.count ));
		
	}
	
}

class A {
	public String name;
	public Long count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
