package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public String getDatabase() {
		// TODO Auto-generated method stub
		System.out.println("进入了getDatabase");
		String a = "我是结果";
		Map<String,String> map = new HashMap<String, String>();
		
		return a;
	}

}
