package com.lyy.note.study.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyy.note.study.feign.service.FeignStudyService;
import com.lyy.note.study.feign.service.GetUsersService;
import com.lyy.note.vo.ResponseDTO;

import feign.Feign;
import feign.Request.Options;
import feign.Retryer;
import io.lettuce.core.dynamic.annotation.Command;
@Controller
@RequestMapping(value = "/study")
public class GetAllUsersController {
	
	@Autowired
	GetUsersService getUsersService;
	
	@Value("${product.url}")
	String serverUrl;
	/***
	 * 	 查询用户当前登录状态
	 * @param userName 用户吗
	 * @return 0为未登录 1为已登录 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/getUserStatus")
	public ResponseDTO<String> getUserStatus(@RequestParam String userName) {
		Integer userStatus = getUsersService.selectUserStatusByUname(userName);
		if(userStatus != null) {
			if(userStatus == 0) {
				return ResponseDTO.buildSuccess("未登录");
			}
			if(userStatus == 1) {
				return ResponseDTO.buildSuccess("已登录");
			}
		}
		return ResponseDTO.buildFailure("查询状态失败：当前用户为"+userName);
	}
	
	/**测试feign调用 */
	@ResponseBody
	@RequestMapping(value = "/testFeign")
	public ResponseDTO<String> testFeign(String userName) {
		//String serverUrl2 = serverUrl;
		//System.out.println(serverUrl2);
		int connectTimeoutMillis = 5*60*1000;
		int readTimeoutMillis = 5*60*1000;
		Options options = new Options(connectTimeoutMillis, readTimeoutMillis);
		FeignStudyService target = Feign.builder()
			.options(options) //options方法指定连接超时时长及响应超时时长
			//.retryer(new Retryer.Default(5000, 5000, 3)) //retryer方法指定重试策略, 可省略
			.target(FeignStudyService.class, serverUrl); //target方法绑定接口与服务端地址。返回类型为绑定的接口类型。
		String userStatus = target.getUserStatus(userName);
		JSONObject parseObject = JSON.parseObject(userStatus);
		String data = parseObject.getString("data");
		//System.out.println("userStatus:"+userStatus);
		return ResponseDTO.buildSuccess(data);
	}
	
	
}
