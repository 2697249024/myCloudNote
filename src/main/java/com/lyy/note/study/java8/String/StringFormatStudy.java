package com.lyy.note.study.java8.String;

import org.springframework.beans.BeanUtils;

public class StringFormatStudy {
    public static void main(String[] args) {
        String str=null;

        str = String.format("hi,%s","八重樱");

        System.out.println(str);

        //BeanUtils.copyProperties();

    }

}
