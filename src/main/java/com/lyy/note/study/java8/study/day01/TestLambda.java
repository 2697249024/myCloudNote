package com.lyy.note.study.java8.study.day01;

public class TestLambda {

    //将一个字符串转换成大写，并作为方法的返回值
    public String stringCase(String str ,DayOneExercise doe){
        return doe.getValue(str);
    }

    public Long getValue(Long l1,Long l2,DayOneExercise1<Long,Long> do1){
        return do1.getResult(l1,l2);
    }


}
