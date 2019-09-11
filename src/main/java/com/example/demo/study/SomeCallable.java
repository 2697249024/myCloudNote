package com.example.demo.study;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SomeCallable implements Callable<Object>{
	//该call()方法将作为线程执行体，并且有返回值。
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("我启动了"+Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}
	
	public static void main(String[] args) {
		Callable oneCallable = new SomeCallable();
		//FutureTask是一个包装器，它通过接受Callable来创建，它同时实现了 Future和Runnable接口。 
		FutureTask oneTesk = new FutureTask(oneCallable);
		//由FutureTask创建一个Thread对象
		Thread oneThread = new Thread(oneTesk);
		//启动线程
		oneThread.start();
		
	}
	
}
