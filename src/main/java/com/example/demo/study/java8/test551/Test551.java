package com.example.demo.study.java8.test551;

import java.util.Arrays;
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
		// TODO Auto-generated method stub
		
		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		System.out.println("------------------------");
		//按年份筛选
		//Map<Integer, List<Transaction>> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
		
//		//按年份和人名刷选
		Map<Integer, List<Transaction>> collect2 = transactions.stream().filter(Transaction -> Transaction.getTrader().equals(mario)).collect(Collectors.groupingBy(Transaction::getYear));
		System.out.println("-2-->:"+collect2);
		
		
		//计算所有交易额
//		Integer integer = transactions.stream().map(Transaction::getValue).reduce(Integer::sum).get();
//		System.out.println(integer);
//		//or  使用IntStream避免了自动拆箱操作，性能更好
//		int sum = transactions.stream().mapToInt(Transaction::getValue).sum();
//		System.out.println(sum);
		
		//找到交易额最小的交易
//		Optional<Transaction> reduce2 = transactions.stream().reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2 );
//		System.out.println(reduce2.get().getValue());
		
		//找出2011年发生的所有交易,并按交易额排序（从低到高）
		//transactions.stream().filter(transaction -> transaction.getYear()==2011).map(Transaction::getValue).sorted().collect(Collectors.toList()).forEach(System.out::println);
		//交易员都在哪些不同城市工作过？
		//transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList()).forEach(System.out::println);
		//查找所有来自剑桥的交易员，并按照姓名排序
//		transactions.stream().filter(transaction ->
//		transaction.getTrader().getCity().equals("Cambridge")).map(
//				transaction ->transaction.getTrader().getName()).sorted().distinct().collect(Collectors.toList()).forEach(System.out::println);
		//or
		//transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().collect(Collectors.toList()).forEach(System.out::println);
		//返回所有交易员的姓名字符串，按字母顺序排序
//		String reduce = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (n1,n2)->n1+n2);
//		System.out.println(reduce);
//		
		//有没有交易员是在米兰工作的？
//		boolean anyMatch = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
//		System.out.println(anyMatch);
		
		//打印生活在剑桥的交易员的所有交易额
		//transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
		//所有交易中，最高的交易额是多少？
//		Optional<Integer> reduce = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
//		System.out.println(reduce.get());
		//averagingInt 计算平均数
//		Double collect = transactions.stream().collect(Collectors.averagingInt(Transaction::getValue));
//		System.out.println(collect);
		//summarizing 计算最大最小平均求和
//		IntSummaryStatistics collect2 = transactions.stream().collect(Collectors.summarizingInt(Transaction::getValue));
//		System.out.println(collect2);
		
//		final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
//		Stream<String> Snames = Stream.of(names);
//		String collect = Snames.collect(Collectors.joining(" -> "));
//		System.out.println(collect);
	}

}
