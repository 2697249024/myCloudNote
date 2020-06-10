package com.lyy.note.study.feign.service;

import org.apache.ibatis.annotations.Param;

public interface GetUsersService {
	
	/***
	 * 	 查询用户当前登录状态
	 * @param userName 用户吗
	 * @return 0为未登录 1为已登录 
	 */
	Integer selectUserStatusByUname(@Param("user_name")String userName);
}
