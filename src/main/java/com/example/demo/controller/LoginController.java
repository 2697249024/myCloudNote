package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.eumns.ResponseEumn;
import com.example.demo.service.LoginService;
import com.example.demo.util.MD5Util;
import com.example.demo.vo.ResponseDTO;
/**
 *  用户登录
 * @author 80004198
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	/***
	 * 	登录请求 MD5 加密
	 * @param UsNameAndPwd
	 * @param userName
	 * @param response
	 * @param UserExists sessionStorage中user是存在
	 * @return
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/loginMd5",method=RequestMethod.POST)
    public ResponseDTO loginMd5(String UsNameAndPwd,String userName, HttpServletResponse response){
        //对比
		Boolean result = loginService.getUsNameAndPwd(UsNameAndPwd);
		//跨域响应
		//response.setHeader("Access-Control-Allow-Origin","*");
		if(result) {
			//判断sessionStorage中user是存在
			return ResponseDTO.buildSuccess("");
		}
        return ResponseDTO.buildFailure("用户名或密码错误");
    }
	
	
	
	/*
	 * @CrossOrigin
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/loginMd5",method=RequestMethod.POST) public
	 * ResponseDTO loginMd5(String UsNameAndPwd,String userName,String UserExists,
	 * HttpServletResponse response){ //对比 Boolean result =
	 * loginService.getUsNameAndPwd(UsNameAndPwd); //跨域响应
	 * //response.setHeader("Access-Control-Allow-Origin","*"); if(result) {
	 * //判断sessionStorage中user是存在 if(StringUtils.isEmpty(UserExists)) {
	 * //如果为空则表示用户非正常状态退出 改变用户登录状态为0 Boolean updateUserStatus =
	 * loginService.updateUserStatus(0, userName); } //根据状态判断用户是否已经登录 Integer
	 * resultStatus = loginService.selectUserStatusByUname(userName); //等于0表示未登录
	 * if(resultStatus == 0) { //将登陆状态改为1 loginService.updateUserStatus(1,
	 * userName); return ResponseDTO.buildSuccess(""); }else if(resultStatus == 1){
	 * //表示已经登录拒绝在次登录 return ResponseDTO.buildFailure("账号已登录，请注销后重试！"); } return
	 * ResponseDTO.buildSuccess(""); } return ResponseDTO.buildFailure("用户名或密码错误");
	 * }
	 */
	
	//前端发送退出登录时 改变用户登录状态
	//即清空sessionStorage
	/*
	 * @CrossOrigin
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/logOut",method=RequestMethod.POST) public
	 * ResponseDTO logOut(String userName){ Boolean updateUserStatus =
	 * loginService.updateUserStatus(0, userName); if(updateUserStatus) { return
	 * ResponseDTO.buildSuccess(""); } return ResponseDTO.buildFailure("注销失败"); }
	 */
	
	
	
}
