package com.lyy.note.study.concurrence.T1;

public class Run2 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(500000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
