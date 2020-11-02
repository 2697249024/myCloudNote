package com.lyy.note.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyy.note.entity.User;
import com.lyy.note.enums.ResponseEnum;
import com.lyy.note.service.UserService;
import com.lyy.note.vo.PageQueryDTO;
import com.lyy.note.vo.ResponseDTO;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	
	@ResponseBody
	@RequestMapping(value = "/alluser",method = RequestMethod.GET)
	public ResponseDTO<List<User>> AllUsers(){
		List<User> selectAllUser = userService.selectAllUser1();
		//先判断是否为null
		if (selectAllUser == null) {
			return ResponseDTO.buildFailure(ResponseEnum.ERROE.getDesc());
		}if(selectAllUser.isEmpty()) {
			return ResponseDTO.buildFailure("未查询到任何数据");
		}
		return ResponseDTO.buildSuccessMsg(selectAllUser, ResponseEnum.SUCCESS.getDesc());
	}
	
	//分页查询
	@ResponseBody
	@RequestMapping(value = "/AllUsersByPageQuery",method = RequestMethod.GET)
	public ResponseDTO<List<User>> AllUsersByPageQuery(Integer pageNo,Integer pageSize){
		
		if(StringUtils.isEmpty(pageNo)||StringUtils.isEmpty(pageSize)) {
			return ResponseDTO.buildFailure("传入参数错误");
		}
		PageQueryDTO pageQuery = new PageQueryDTO(pageNo, pageSize);
		try {
			List<User> selectAllUserByPageQuery =userService.selectAllUserByPageQuery(pageQuery);
			return ResponseDTO.buildSuccessMsg(selectAllUserByPageQuery,null);
		} catch (Exception e) {
			log.error("UserController->AllUsersByPageQuery 查询失败",e);
		}
		return ResponseDTO.buildFailure("查询失败");
		
		
	}
	
	
	
	
}
