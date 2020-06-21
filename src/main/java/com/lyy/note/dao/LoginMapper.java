package com.lyy.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lyy.note.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户
 */
@Mapper
@Repository
public interface LoginMapper {
	//查询所有用户
	List<User> selectAllUser();
	
	/**根据用户账号名改变用户状态 
	 * 
	 * @param status 状态0为未登录 1为已登录 
	 * @param userName 用户名
	 * */
	Boolean updateUserStatus(@Param("status") Integer status,@Param("user_name")String userName);
	
	/***
	 * 	 查询用户当前登录状态
	 * @param userName 用户吗
	 * @return 0为未登录 1为已登录 
	 */
	Integer selectUserStatusByUname(@Param("user_name")String userName);
	
}
