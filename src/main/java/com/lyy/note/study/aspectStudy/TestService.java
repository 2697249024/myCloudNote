package com.lyy.note.study.aspectStudy;

import org.springframework.stereotype.Component;

@Component
public class TestService {
	
	public String test(String message) {
		return "TestService ->test:"+message ;
	}
}
