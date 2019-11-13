package com.lyy.note.study.concurrence.T1;

public class TestRun {
	public static void main(String[] args) {
		Mythread thread = new Mythread();
		thread.setName("MyThread");
		thread.start();
		
		for (int i = 0; i < 10000; i++) {
			System.err.println("main ="+Thread.currentThread().getName());
		}
		
	}
}
