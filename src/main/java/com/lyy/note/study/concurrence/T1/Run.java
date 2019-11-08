package com.lyy.note.study.concurrence.T1;

public class Run {
	
	public static void main(String[] args) throws InterruptedException {
		Mythread mythread = new Mythread();
		mythread.start();
		Thread.sleep(200);
		System.out.println("结束");
	}
}
