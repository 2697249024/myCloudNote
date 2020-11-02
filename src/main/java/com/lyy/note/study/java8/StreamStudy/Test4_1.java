package com.lyy.note.study.java8.StreamStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lyy.note.service.impl.NoticeServiceImpl;
import com.lyy.note.study.java8.StreamStudy.Dish.Type;

public class Test4_1 {
	
	private static final Logger logger = LoggerFactory.getLogger(Test4_1.class); 
	
	public enum CaloricLevel {DIET,NORMAL,FAT};

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("猪肉", false, 800, Dish.Type.MEAT),
				new Dish("牛肉", false, 700, Dish.Type.MEAT), 
				new Dish("鸡肉", false, 400, Dish.Type.MEAT),
				new Dish("法式炸薯条", true, 530, Dish.Type.OTHER), 
				new Dish("米饭", true, 350, Dish.Type.OTHER), 
				new Dish("核果", true, 120, Dish.Type.OTHER),
				new Dish("比萨饼", true, 550, Dish.Type.OTHER), 
				new Dish("大虾", false, 300, Dish.Type.FISH),
				new Dish("鲑鱼", false, 450, Dish.Type.FISH));
		

//Map<Type, Dish> collect = menu.stream().collect(groupingBy(Dish::getType,collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
//System.out.println("collect:"+collect);
		
		//对于每种类型的dish 菜单中有哪些等级
//		
//		Map<Type, List<Dish>> collect2 = menu.stream().collect(groupingBy(Dish::getType));
//		System.out.println(collect2);
//		
//		
		 Map<Type, Set<String>> aa = menu.stream().collect(groupingBy(Dish::getType,mapping(a -> {
			return a.getName() ;
		}, toSet())));
		System.out.println(aa);
		
		//按照素食和非素食分区 并按照type类型分组
		
		 Map<Boolean, Map<Type, Set<String>>> collect = menu.stream()
		.collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType,mapping(d ->{
			return d.getName();
		}, toSet()))));
		 System.out.println(collect);
		
		
		/*
		 * List<String> collect2 = menu.stream().map(Dish::getName).collect(toList());
		 * System.out.println(collect2);
		 */

		


		
		//menu 中有多少菜?
//		Integer reduce = menu.stream().map(Dish::getName).distinct().map(name ->1).reduce(0,(a,b)->a+b);
//		System.out.println("menu中有"+reduce+"道菜");
//		
//		long count = menu.stream().map(Dish::getName).distinct().count();
//		System.out.println("menu中有"+count+"道菜");
//		 
//		Long counting = menu.stream().collect(counting());
//		System.out.println("menu中有"+counting+"道菜");
//		 long count2 = menu.stream().count();
//		 System.out.println("menu中有"+count2+"道菜");
		 
		 //数值流 计算所有食物的热量和
//		 Integer sum1 = menu.stream().map(Dish::getCalories).reduce(0,(a,b) ->a+b);
//		 
//		IntSummaryStatistics collect = menu.stream().collect(summarizingInt(Dish::getCalories));
//		System.out.println("menu中:"+collect);
//		 	
//		Map<Type, List<Dish>> collect2 = menu.stream().collect(groupingBy(Dish::getType));
//		System.out.println(collect2.toString());
//		
//		int sum2 = menu.stream().mapToInt(Dish::getCalories).sum();
//		System.out.println(sum2);
//		
//		
		//自定义分组 热量低于400 划分为diet 热量400-700 划为normal 热量高于700 fat
//		Map<CaloricLevel, List<Dish>> dish3 = menu.stream().collect(groupingBy(dish -> {
//			if(dish.getCalories() <=400) {
//				return CaloricLevel.DIET;
//			}else if(dish.getCalories() <=700){
//				return CaloricLevel.NORMAL;
//			}else {
//				return CaloricLevel.FAT;
//			}
//		}));
//		System.out.println("dish3:"+dish3);
//		
//		Map<Type, Map<CaloricLevel, List<Dish>>> collect3 = menu.stream().collect(groupingBy(Dish::getType,groupingBy(dish -> {
//			if(dish.getCalories() <=400) {
//				return CaloricLevel.DIET;
//			}else if(dish.getCalories() <=700){
//				return CaloricLevel.NORMAL;
//			}else {
//				return CaloricLevel.FAT;
//			}
//			})
//		));
//		System.out.println("dish3:"+collect3);
	
		
		// Optional.ofNullable( menu.stream().collect(groupingBy(Dish::getType,maxBy(Comparator.comparing(Dish::getCalories))))).ifPresent(System.out::print);
		
		
		
		//Optional<Map<Type,Dish>> ofNullable = Optional.ofNullable(menu.stream().collect(groupingBy(Dish::getType,collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)),Optional::get))));
		
		/*
		 * List<String> collectMenu = menu.stream().filter(d -> {
		 * System.out.println(d.getName()+","+d.getCalories()); return
		 * d.getCalories()>300; }) .map(r ->{ System.out.println("map:"+r.getName());
		 * return r.getName(); }) .limit(3).collect(Collectors.toList());
		 * System.out.println(collectMenu);
		 * 
		 * 
		 * // 筛选所有素菜，创造素食菜单
		 * 
		 * List<String> collect =
		 * menu.stream().filter(Dish::isVegetarian).map(Dish::getName).distinct().
		 * collect(Collectors.toList()); collect.forEach(d -> {
		 * System.out.println(d.toString()); });
		 * 
		 * //limit和skip 跳过300K的前三道菜 List<Dish> collect2 = menu.stream().filter(d ->
		 * d.getCalories()>300).skip(3).collect(Collectors.toList()); collect2.forEach(d
		 * ->{ System.out.println(d.toString());});
		 */
		// 筛选前两道荤菜
		/*
		 * List<Dish> collect3 = menu.stream().filter(d -> d.getType() ==
		 * Dish.Type.MEAT).limit(2).collect(Collectors.toList()); collect3.forEach(d ->
		 * { System.out.println(d.toString()); });
		 */
		// 获取[1, 4, 9, 16, 25]
		/*
		 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); List<Integer> r1 = new
		 * ArrayList<Integer>(); for (int i = 0; i < numbers.size(); i++) { r1.add(i,
		 * numbers.get(i) * numbers.get(i)); }
		 * 
		 * System.out.println("以前的做作法：" + r1.toString()); List<Integer> co =
		 * numbers.stream().map(d -> d * d).collect(Collectors.toList());
		 * System.out.println("java8" + co.toString());
		 */

		// 给定两个数字列表，如何返回所有的数对呢？ [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4),]
		/*
		 * List<Integer> n1 = Arrays.asList(1, 2, 3); List<Integer> n2 =
		 * Arrays.asList(3,4); List<String> n3 = new ArrayList<String>(); for (int i =
		 * 0; i < n1.size(); i++) { for (int j = 0; j < n2.size(); j++) {
		 * n3.add("("+n1.get(i)+","+n2.get(j)+")"); } }
		 * System.out.println(n3.toString()); List<int[]> collect =
		 * n1.stream().flatMap(i -> n2.stream().map(j -> new int[]
		 * {i,j})).collect(Collectors.toList());
		 */
	
		//anyMatch 菜单中是否有素食选择
		/*
		 * boolean anyMatch = menu.stream().anyMatch(Dish::isVegetarian);
		 * System.out.println(anyMatch);
		 */
		//allMatch 看看菜是否健康，即热量低于1000
		/*
		 * boolean allMatch = menu.stream().allMatch(p -> p.getCalories()<1000);
		 * System.out.println(allMatch);
		 */
		//查找第一个平方能被3整除的数
		/*
		 * List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
		 * someNumbers.stream().map(d -> d*d).filter(n -> n%3 ==
		 * 0).findFirst().ifPresent(result -> { System.out.println(result); });
		 */
		
		//查找最大的数
		/*
		 * List<Integer> ss = Arrays.asList(1,9,3,4,5);
		 * 
		 * Optional<Integer> reduce2 = ss.stream().reduce((a,b) -> a<=b? a:b);
		 * System.out.println("最小："+reduce2); Optional<Integer> reduce =
		 * ss.stream().reduce(Integer::max); System.out.println("最大:"+reduce);
		 */
					
	
	}

}
