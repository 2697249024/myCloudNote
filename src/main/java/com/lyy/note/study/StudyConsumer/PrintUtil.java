package com.lyy.note.study.StudyConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 打印加强处理类
 * @author 80004198
 *
 */
public class PrintUtil {
	public void addString(String x) {
		System.out.println(x+" add");
	}
	
	public static void addString1(String x) {
		System.out.println(x+" add1");
	}
	
	@Test
	public void TestDome() {
		
		List<String> strList = Arrays.asList("AA", "BB", "CC");
	
		strList.forEach(PrintUtil :: addString1 );
	}
	
	@Test
	public void TestStrem1() {
		//将List集合中的重量大于0.3kg的水果筛选出来进行排序后拿出它的名字最后放到另一个List中去
        List<Fruit> fruits = new ArrayList<>();
//        fruits.add(new Fruit("Apple", 0.8));
//        fruits.add(new Fruit("orange", 0.3));
//        fruits.add(new Fruit("watermelon", 1.2));
//        fruits.add(new Fruit("banana", 0.6));
//		
		
	}
	
	
	
}
