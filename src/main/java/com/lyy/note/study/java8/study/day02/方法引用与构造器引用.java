package com.lyy.note.study.java8.study.day02;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *1. 方法引用: 若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 *
 *主要有三种语法格式：
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 *  注意：
 *  1. Lambda体中调用方法的参数列表和返回值类型，要与函数式接口中的抽象方法的函数列表和返回值类型保持一致。
 *  2. 若Lambda 参数列表中的第一个参数，是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 * 2. 构造器引用
 *  格式：
 *      ClassName::new
 */
public class 方法引用与构造器引用 {

        // 类::实例方法名
        @Test
        public void  test3(){
            BiPredicate<String,String> bp = (x,y) ->x.equals(y);
            BiPredicate<String,String> bp2 = String::equals;
        }


        // 类::静态方法名
        @Test
        public void  test2(){
            Comparator<Integer> co = (x,y) -> Integer.compare(x,y);
            Comparator<Integer> co1 = Integer::compare;
            int compare = co1.compare(5, 3);
            System.out.println(compare);

        }


        // 对象::实例方法名
        @Test
        public void  test1(){
            PrintStream out = System.out;
            Consumer<String> con = (x) -> System.out.println(x);
            Consumer<String> con1 =out::println;
            Consumer<String> con2 =System.out::println;
            con2.accept("assss");
        }

}
