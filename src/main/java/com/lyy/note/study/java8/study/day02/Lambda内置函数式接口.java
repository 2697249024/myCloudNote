package com.lyy.note.study.java8.study.day02;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda内置四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 *         void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *         T get();
 *
 * Function<T, R>  :  函数型接口
 *         R apply(T t);
 *
 * Predicate<T>  : 断言型接口
 *        boolean test(T t);
 *
 *   其他
 *          除了上述得4种类型得接口外还有其他的一些接口供我们使用：
 *
 * 　　　　1）.BiFunction<T, U, R>
 *
 * 　　　　　　参数类型有2个，为T，U，返回值为R，其中方法为R apply(T t, U u)
 *
 * 　　　　2）.UnaryOperator<T>(Function子接口)
 *
 * 　　　　　　参数为T，对参数为T的对象进行一元操作，并返回T类型结果，其中方法为T apply(T t)
 *
 * 　　　　3）.BinaryOperator<T>(BiFunction子接口)
 *
 * 　　　　　　参数为T，对参数为T得对象进行二元操作，并返回T类型得结果，其中方法为T apply（T t1， T t2）
 *
 * 　　　　4）.BiConsumcr(T, U)
 *
 * 　　　　　　参数为T，U无返回值，其中方法为 void accept(T t, U u)
 *
 * 　　　　5）.ToIntFunction<T>、ToLongFunction<T>、ToDoubleFunction<T>
 *
 * 　　　　　　参数类型为T，返回值分别为int，long，double，分别计算int，long，double得函数。
 *
 * 　　　　6）.IntFunction<R>、LongFunction<R>、DoubleFunction<R>
 *
 * 　　　　　　参数分别为int，long，double，返回值为R。
 *
 *
 */
public class Lambda内置函数式接口 {

    //需求：将满足条件的字符串添加到集合中  Predicate<T>  : 断言型接口
    @Test
    public void Test4(){
        List<String> strList = Arrays.asList("a1", "a2", "b2", "d2", "aa1");
        List<String> aResult = filterStr(strList, (x) -> x.contains("a"));
        for (String ss:aResult) {
            System.out.println(ss);
        }
    }

    public List<String> filterStr( List<String> list ,Predicate<String> pre){
        List<String> result = new ArrayList<>();
        for (String str:list) {
            if(pre.test(str)){
                result.add(str);
            }
        }
        return  result;
    }



    //需求：用于处理字符串  Function<T, R>  :  函数型接口
    @Test
    public void Test3(){
        //将字符串截取
        String result = strHandler("ss快乐风男灬", (str) -> str.substring(2));
        System.out.println(result);
    }

    public String strHandler(String str,Function<String ,String > fun ) {
        return  fun.apply(str);
    }


    //需求：产生指定个数的随机整数，并放入集合中 Supplier<T> : 供给型接口
    @Test
    public void Test2(){
        List<Integer> num = getNum(5, () -> (int) (Math.random() * 100));
        for (Integer a: num) {
            System.out.println(a);
        }
    }


    public List<Integer> getNum(int a1 , Supplier<Integer> su){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a1; i++) {
            Integer integer = su.get();
            result.add(integer);
        }
        return result;
    }




    //Consumer<T> : 消费型接口
    @Test
    public void Test1(){
        happy(200,x -> System.out.println("消费了"+x+"$"));
    }

    public void happy(double m ,Consumer con){
        con.accept(m);
    }




}
