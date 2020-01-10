package com.lyy.note.study.java8.test551;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/***
 *  page 98
 * @author 80004198
 *
 */
public class Test551 {

	public static void main(String[] args) {
		
		Trader yayi = new Trader("芽衣","剑桥");
		Trader jizi = new Trader("姬子","米兰");
		Trader sakura = new Trader("八重樱","剑桥");
		Trader xier = new Trader("希尔","剑桥");
		
		List<Transaction> transactions = Arrays.asList(new Transaction(xier, 2011, 300),
				new Transaction(xier, 2011, 300),
				new Transaction(yayi, 2012, 1000),
				new Transaction(yayi, 2011, 400),
				new Transaction(jizi, 2012, 710),
				new Transaction(jizi, 2012, 700),
				new Transaction(sakura, 2012, 950)
				);
		
		System.out.println("------------------------");
		
		//找出2011年发生的所有交易,并按交易额排序（从低到高）
		List<Transaction> collect = transactions.stream().filter(year -> year.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		System.out.println(collect.toString());
		//交易员都在哪些不同城市工作过？
		List<String> collects = transactions.stream().map(a -> a.getTrader().getCity()).distinct().collect(Collectors.toList());
		System.out.println(collects.toString());
		//查找所有来自剑桥的交易员，并按照姓名排序
		 List<String> collect2 = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("剑桥")).map(a -> a.getName()).distinct().sorted().collect(Collectors.toList());
		System.out.println(collect2.toString());
		//返回所有交易员的姓名字符串，按字母顺序排序
		String reduce1 = transactions.stream().map(a -> a.getTrader().getName()).distinct().sorted().reduce("",(a,b)->a+b);
		System.out.println(reduce1);
		//高效率
		String collect3 = transactions.stream().map(a -> a.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
		System.out.println(collect3);
		
		//有没有交易员是在米兰工作的？
		transactions.stream().filter(a -> a.getTrader().getCity().equals("米兰")).findAny().ifPresent(System.out::println);
		boolean anyMatch = transactions.stream().anyMatch(a ->a.getTrader().getCity().equals("米兰"));
		System.out.println(anyMatch);
		//打印生活在剑桥的交易员的所有交易额
		Optional<Integer> reduce = transactions.stream().filter(T -> T.getTrader().getCity().equals("剑桥")).map(Transaction -> Transaction.getValue()).reduce(Integer::sum);
		System.out.println(reduce);
		
		//所有交易中，最高的交易额是多少？
		Optional<Integer> reduce2 = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(reduce2);
		
		//找到交易额最小的交易
		Optional<Transaction> reduce3 = transactions.stream().reduce((t1,t2) -> t1.getValue()<t2.getValue()?t1:t2);
		System.out.println(reduce3.toString());
		//或
		 Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		 System.out.println(min.toString());
		 
				
	}

}
