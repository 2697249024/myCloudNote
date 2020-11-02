package com.lyy.note.study.java8.study.day01;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class day01练习 {

    /**
     * 声明一个函数式接口，接口中声明抽象方法，public String getValue(String str);
     * 声明类 TestLambda，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值
     * 再将一个字符串的第二个和第四个索引位置进行截取子串
     */
    @Test
    public void test1(){
        String a = "sakURa";
        TestLambda ta = new TestLambda();
        //转换为大写
        String s1 = ta.stringCase(a, (x) -> x.toUpperCase());
        System.out.println(s1);
        //将一个字符串的第二个和第四个索引位置进行截取子串
        System.out.println("---------------");
        String s2 = ta.stringCase(a, (x) -> a.substring(2, 4));
        System.out.println(s2);
    }

    /***
     * 声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
     * 接口中声明对应的抽象方法
     * 在TestLambda 类中声明方法，使用接口作为参数，计算两个long型参数的和
     * 在计算两个long型参数的乘积。
     */
    @Test
    public void test2(){
        TestLambda tb = new TestLambda();
        Long value = tb.getValue(100L, 200L, (x, y) ->  x + y);
        System.out.println(value);
        Long value1 = tb.getValue(100L, 200L, (x, y) ->  x * y);
        System.out.println(value1);

    }



}

