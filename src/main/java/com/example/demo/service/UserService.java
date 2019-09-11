package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.vo.PageQueryDTO;

public interface UserService {
	List<User> selectAllUser1();
	
	//分页查询所有用户 map
	List<User> selectAllUserByPageQuery(PageQueryDTO pageQuery);
}
