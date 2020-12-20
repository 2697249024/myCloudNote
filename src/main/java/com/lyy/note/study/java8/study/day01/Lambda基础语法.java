package com.lyy.note.study.java8.study;

import com.lyy.note.study.java8.study.day01.MyFun;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/***
 * Lambda 基础语法
 *  1. lambda 表达式， ->
 *
 * 左侧 lambda表达式的参数列表
 * 右侧 Lambda表达式所需要执行的功能，即Lambda体
 *
 *
 * 语法格式一 ： 无参数，无返回值
 *      （） —> System.out.println("Hello Lambda");
 *
 * 语法格式二 ：有一个参数，并且无返回值 （若只有一个参数 左小括号可以不写）
 *       (x) -> System.out.println(x);
 *       x -> System.out.println(x);
 * 语法格式三 ：有两个以上参数，有返回值，并且Lambda 体中有多条语句
 *          Comparator<Integer> cc = (x,y) ->{
 *             System.out.println("我是compare方法");
 *             return Integer.compare(x,y);
 *         };
 *语法格式四 ：若只有一条语句，大括号和return都可以省略
 *          Comparator<Integer> cc = (x,y) -> Integer.compare(x,y);
 *
 *备注 ： Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 *
 * 2.Lambda 表达式需要‘函数式接口’的支持
 *  函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用 @FunctionalInterface 修饰。检查是否是函数式接口
 *
 */
public class Lambda基础语法 {

    @Test
    public void test1(){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        r.run();
        System.out.println("------------------");
        Runnable r1 = () -> System.out.println("Hello Lambda");
        r1.run();

    }


    @Test
    public void  test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("一个参数，无返回值");
    }

    @Test
    public void  test3(){
        Comparator<Integer> cc = (x,y) ->{
            System.out.println("我是compare方法");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void  test4(){
        Comparator<Integer> cc = (x,y) -> Integer.compare(x,y);
    }

    //练习 需求：对一个数进行运算

    @Test
    public void  test5(){
        Integer operation = operation(100, (x) -> x * x);
        System.out.println(operation);
        System.out.println(operation(200,(x) -> x+300));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

}
