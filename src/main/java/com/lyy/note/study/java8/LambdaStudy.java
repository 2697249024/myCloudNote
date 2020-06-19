package com.lyy.note.study.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;

import io.netty.util.Mapping;

public class LambdaStudy {
	
	
	public static void main(String[] args) {


		//List<Integer> intList = Arrays.asList(1,2,3);
//		//变成一倍
//		List<Integer> collect = intList.stream().map(e ->
//			e = e * e
//
//		).collect(Collectors.toList());
		
		//List<Integer> collect = intList.stream().map( e -> e * e ).collect(Collectors.toList());
		
		//collect.forEach(System.out::println);
		// 不使用lambda表达式为每个订单加上12%的税
//		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//		for (Integer cost : costBeforeTax) {
//		    double price = cost + .12*cost;
//		    System.out.println(price);
//		}
//		System.out.println("-------");
//		// 使用lambda表达式
//		List<Double> collect = costBeforeTax.stream().map(p->p + .12*p).collect(Collectors.toList());
//		collect.forEach(System.out::println);
		
		// 为每个订单加上12%的税 求税和
		// 老方法：
//		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//		double total = 0;
//		for (Integer cost : costBeforeTax) {
//		    double price = cost + .12*cost;
//		    total = total + price;
//		}
//		System.out.println("Total : " + total);
//		System.out.println("==========");
//		Double double1 = costBeforeTax.stream().map(cost -> cost+ .12*cost).reduce((sum,cost) -> sum+cost).get();
//		System.out.println(double1);
//		System.out.println("==========");
//		
//		//获取数字的个数、最小值、最大值、总和以及平均值
//		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//		IntSummaryStatistics summaryStatistics = primes.stream().mapToInt(p->p).summaryStatistics();
//		System.out.println(summaryStatistics.getCount());
		
//		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//		//使用 QwQ分割
//		String collect = primes.stream().map(String::valueOf).collect(Collectors.joining("-QwQ-","[","]"));
//		System.out.println(collect);
		//数据分组
//		List<String> views =  Arrays.asList("wsbs","xafaswzx","b8fw","ad");
		//根据字符串长度分组Map<Integer, List<String>>
		//Map<Integer, List<String>> collect = views.stream().collect(Collectors.groupingBy(String::length));
		
//		String string = collect.toString();
//		System.out.println("stringMap:"+string);
//		collect.forEach((key,value) ->{
//			System.out.println("key:"+key);
//			value.stream().forEach(System.out::println);
//		});
	//	System.out.println(collect.toString());
		

		
		
	}
}
