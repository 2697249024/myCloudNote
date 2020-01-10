package com.lyy.note.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.util.comparator.Comparators;

import com.google.common.collect.Maps;

/***
 * 来自同事的笔记
 */
public class NoteStreamCase {
	
	
	public static void main(String[] args) {
		
		List<TheUser> list = Arrays.asList(new TheUser("sakura", 18),new TheUser("jizi", 17));
		
		
		//1，stream 中break（list.stream().filter().findFirst();）
		 Optional<TheUser> name = list.stream().filter(p -> {
       			if (p.getName()!= "nn") {
          			        System.out.println("1111");
          			        return true;
       			}else{
       						System.out.println("2222");
          			        return false;
       			}
   		}).findFirst();
		 
		 

		// 2，stream 中continue （return;）
		  list.forEach(p->{
			if (p.getName().equals("sakura"))
   			    return;
   			System.out.println(p.getName());
		  });	 
		 
	  	// 3，遍历list拼接字符串
		//list.stream().reduce(new StringBuilder(), (sb, s) -> sb.append(s).append(','), StringBuilder::append).toString();
		//或者
		String joining = list.stream().map(TheUser::getName).collect(Collectors.joining(":"));
		System.out.println("joining:"+joining);
	
		//按出现次数从大到小排序 筛选出出现次数最多的前4个字符串 
		

		String[] a = {"java","java","BigDecimal","java","java8","流","时间工具类","uuid","collects","执行计划","版本"
				,"maven","工具类","util","接口","缓存","数据库","stream","BigDecimal","缓存","缓存","数据库","数据库","util",
				"util","util","util"
				,"工具类","工具类"};
		Map<String,Integer> map = Maps.newHashMap();
		for (String str:a) {
			if(!map.containsKey(str)){
				map.put(str,0);
			}
			map.put(str,map.get(str)+1);
		}
		String[] b = new String[a.length];
		for (Map.Entry<String,Integer> entry: map.entrySet()) {
			b[entry.getValue()] = null!=b[entry.getValue()]?(b[entry.getValue()]+","+entry.getKey()):entry.getKey();
		}
		
		int index = 0;
		for (int i = b.length-1; i >= 0 ; i--) {
			if(null!=b[i]){
				System.out.println(Arrays.toString(b[i].split(",")));
				index+=b[i].split(",").length;
				if(index >= 4){
					break;
				}
			}
		}
		
	}
}
