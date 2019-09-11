package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;

public interface LoginService {
	/**查询所有用户*/
	List<User> selectAllUser();
	
	/**验证用户名+密码*/
	Boolean getUsNameAndPwd(String UsNameAndPwd);
	
	/**根据用户账号名改变用户状态 
	 * 
	 * @param status 状态0为未登录 1为已登录 
	 * @param userName 用户名
	 * */
	Boolean updateUserStatus(Integer status,String userName);
	
	/***
	 * 	 查询用户当前登录状态
	 * @param userName 用户吗
	 * @return 0为未登录 1为已登录 
	 */
	Integer selectUserStatusByUname(String userName);
}
