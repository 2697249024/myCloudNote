package com.lyy.note.study.concurrence.codeBlock;

import java.util.ArrayList;
import java.util.List;

public  class Mylist {
	private List<String> list = new ArrayList<String>();
	
	synchronized public void add(String userName) {
		System.out.println("ThreadName:"+Thread.currentThread().getName()+"执行了add方法！");
		list.add(userName);
		System.out.println("ThreadName:"+Thread.currentThread().getName()+"退出了add方法！");
	}
	
	synchronized public int getSize() {
		System.out.println("ThreadName:"+Thread.currentThread().getName()+"执行了getSize方法！");
		int sizeVaue= list.size();
		System.out.println("ThreadName:"+Thread.currentThread().getName()+"退出了getSize方法！");
		return sizeVaue;
	}
	
	
	
	
}
