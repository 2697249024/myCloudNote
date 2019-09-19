package com.example.demo.study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda {
	public static void main(String[] args) {
//		List<String> asList = Arrays.asList("a","b","A","B");
//		asList.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
//		asList.sort(String::compareToIgnoreCase);
//		List<Integer> asList2 = Arrays.asList(1,2,1,3,2,4,2,5,3);
//		asList2.stream().filter(i->i%2==0).distinct().forEach(System.out::println);
//		Map<Integer, Long> collect = asList2.stream().collect(Collectors.groupingBy(p->p,Collectors.counting()));
//		List<Integer> asList3 = Arrays.asList(1,2,3,4,5);
//		List<Integer> collect2 = asList3.stream().map(i -> i*i).collect(Collectors.toList());
//		collect2.forEach(System.out::println);
//		List<Integer> ast1 = Arrays.asList(1,2,3);
//		List<Integer> ast2 = Arrays.asList(3,4);
//		ast1.stream().flatMap(i -> ast2.stream().map(j -> new int[] {i,j})).collect(Collectors.toList());
//		
//		List<Integer> ast2 = Arrays.asList(1,2,3,4,5,6);
//		Optional<Integer> findFirst = ast2.stream().map(i -> i*i).filter(i ->i%3 ==0).findAny();
//		System.out.println(findFirst.get());
		IntStream rangeClosed = IntStream.rangeClosed(1, 100);
		System.out.println(rangeClosed.count());
		
		
	}
}
