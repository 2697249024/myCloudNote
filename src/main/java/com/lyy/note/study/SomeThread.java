package com.lyy.note.study;

public class SomeThread extends Thread{
	//并重写该类的run()方法
	public void run() {
		 //do something here
		System.out.println("我启动了"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		//创建Thread子类的实例，即创建了线程对象
		SomeThread oneThread = new SomeThread();
		//启动线程
		oneThread.start();
	}
	
}
