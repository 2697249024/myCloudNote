package com.lyy.note.study.concurrence.codeBlock;

public class MTherd2 extends Thread{

	private Mylist mylist;
	
	
	public MTherd2(Mylist mylist) {
		super();
		this.mylist = mylist;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			mylist.add("MTherdB"+(i+1));
		}
	}

}
