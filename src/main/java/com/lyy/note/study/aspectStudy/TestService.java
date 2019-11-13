package com.lyy.note.study.aspectStudy;

import org.springframework.stereotype.Component;

@Component
public class TestService {
	
	public String test(String message) {
		System.out.println("1112321");
		return "TestService ->test:"+message ;
	}
}
