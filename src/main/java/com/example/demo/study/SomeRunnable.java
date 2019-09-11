package com.example.demo.study;

public class SomeRunnable implements Runnable{

	@Override
	public void run() {
		//do something here
		System.out.println("我启动了"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		//创建Runnable实现类的实例，并以此实例作为Thread的target对象，即该Thread对象才是真正的线程对象。
		Runnable oneRunnable = new SomeRunnable();   
		Thread oneThread = new Thread(oneRunnable);   
		oneThread.start();
	}
	
	
}
