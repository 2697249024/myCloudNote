package com.lyy.note.study.concurrence.z;

public class TestM {
	public static void main(String[] args) {
		MyThread MyThread1 = new MyThread(1);
		MyThread MyThread2 = new MyThread(2);
		MyThread MyThread3 = new MyThread(3);
		MyThread MyThread4 = new MyThread(4);
		MyThread MyThread5 = new MyThread(5);
		MyThread MyThread6 = new MyThread(6);
		MyThread MyThread7 = new MyThread(7);
		MyThread MyThread8 = new MyThread(8);
		MyThread MyThread9 = new MyThread(9);
		MyThread MyThread10 = new MyThread(10);
		
		
		MyThread1.start();
		MyThread2.start();
		MyThread3.start();
		MyThread4.start();
		MyThread5.start();
		MyThread6.start();
		MyThread7.start();
		MyThread8.start();
		MyThread9.start();
		MyThread10.start();
		
		
	}
}
