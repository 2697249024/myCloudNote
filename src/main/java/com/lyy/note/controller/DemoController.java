package com.lyy.note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyy.note.eumns.ResponseEumn;
import com.lyy.note.vo.ResponseDTO;

/**
 * 测试
 * @author 80004198
 *
 */

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@ResponseBody
	@RequestMapping(value = "/demo1",method = RequestMethod.GET)
	public ResponseDTO<String> demo() {
		return ResponseDTO.buildSuccess(ResponseEumn.SUCCESS.getDesc());
	}
	
}
