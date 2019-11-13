package com.lyy.note.study.concurrence.codeBlock;

public class MTherd1 extends Thread{

	
	private Mylist list;
	
	
	public MTherd1(Mylist list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			list.add("ThreadA"+(i+1));
		}
		
		
	}
}
