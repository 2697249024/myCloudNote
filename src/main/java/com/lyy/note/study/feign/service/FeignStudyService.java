package com.lyy.note.study.feign.service;

import feign.Param;
import feign.RequestLine;

public interface FeignStudyService {
	
	//@RequestLine指定HTTP协议及URL地址
	@RequestLine("GET /study/getUserStatus?userName={userName}")  
	String getUserStatus(@Param(value = "userName") String userName);
	
}
