package com.lyy.note.study.java8.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {

        //返回一个由每个数的平方构成的列表
        //Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
       // Arrays.stream(nums).map(x -> x * x).forEach(System.out::print);
        //把dog字符串过滤掉
        Test1.testFilter();

    }

    public static void testFilter(){
        String[] strings = {"apple", "banana", "cat", "dog"};
        List<String> list = Arrays.stream(strings).filter(s -> !s.equals("dog")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));

    }


}
