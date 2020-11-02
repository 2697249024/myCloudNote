package com.lyy.note.study.java8.核心技术卷1;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class 第六章01 {

    public static void main(String[] args) {


        Employee[] staff =new Employee[3];
        staff[0] = new Employee("八重樱",6000);
        staff[1] = new Employee("芽衣",4000);
        staff[2] = new Employee("鸣人",5000);
        Arrays.sort(staff);
        for (Employee e:staff) {
            System.out.println("name"+e.getName()+"salary"+e.getSalary());
        }
        int a = 10;
        int b =20;
        int result = Integer.compare(a, b);
        System.out.println(result);


    }

}
