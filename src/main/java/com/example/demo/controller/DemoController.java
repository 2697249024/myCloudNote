package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.eumns.ResponseEumn;
import com.example.demo.service.TestService;
import com.example.demo.vo.ResponseDTO;

/**
 * 测试
 * @author 80004198
 *
 */

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private TestService test;
	
	@ResponseBody
	@RequestMapping(value = "/demo1",method = RequestMethod.GET)
	public ResponseDTO demo() {
		return ResponseDTO.buildSuccess(ResponseEumn.SUCCESS.getDesc());
	}
	
}
