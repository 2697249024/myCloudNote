package com.lyy.note.study.workStudyTimerAndThread;


public class IsInteruptedTest {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();


        myThread.start();

        myThread.isInterrupted();
        Thread.currentThread().interrupt();

        System.out.println("第一次调用返回值："+Thread.interrupted());
        System.out.println("第二次调用返回值："+Thread.interrupted());
        System.out.println("=============end============");



    }



}
