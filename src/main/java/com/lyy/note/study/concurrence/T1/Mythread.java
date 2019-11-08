package com.lyy.note.study.concurrence.T1;

public class Mythread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("run ="+Thread.currentThread().getName());
		}
	}
}
