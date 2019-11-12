package com.lyy.note.study.aspectStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {
	
	@Autowired
	TestService testService;
	
	@Test
	public void TestService1() {
		
		String message = "change11";
		String test = testService.test(message);
		System.out.println("TestService1:"+test);
		
	}
}
