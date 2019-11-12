package com.lyy.note.study.concurrence.codeBlock;

public class MTest {
	public static void main(String[] args) {
		
		Mylist mlist = new Mylist();
		
		MTherd1 m1 = new MTherd1(mlist);
		m1.setName("A");
		m1.start();
		MTherd2 m2 = new MTherd2(mlist);
		m2.setName("B");
		m2.start();
	}
}
