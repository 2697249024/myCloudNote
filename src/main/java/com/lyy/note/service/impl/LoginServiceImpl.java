package com.lyy.note.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.lyy.note.dao.LoginMapper;
import com.lyy.note.entity.User;
import com.lyy.note.service.LoginService;
import com.lyy.note.util.MD5Util;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	/**查询所有用户*/
	@Override
	public List<User> selectAllUser() {
		List<User> selectAllUser = loginMapper.selectAllUser();
		return selectAllUser;
	}

	/**获取用户名+密码*/
	@Override
	public Boolean getUsNameAndPwd(String UsNameAndPwd) {
		List<User> selectAllUser = loginMapper.selectAllUser();
		for (User user : selectAllUser) {
			String result=user.getUserName()+user.getPassWord();
			//MD5加密
			String userMD5= MD5Util.string2MD5(result);
			//判断用户是否存在
			if(UsNameAndPwd.equals(userMD5)) {
				//true表明用户状态修改成功  放置redis中
				redisTemplate.opsForValue().set(user.getUserName(), user.getPassWord(), 10, TimeUnit.MINUTES);
				return true;
			}
		}
		return false;
	}
	
	/**根据用户账号名改变用户状态 0为未登录 1为已登录*/
	@Override
	public Boolean updateUserStatus(Integer status, String userName) {
		//改变用户状态status
		Boolean updateUserStatus = loginMapper.updateUserStatus(status,userName);
		return updateUserStatus;
	}
	/**根据用户名查询用户登录状态*/
	@Override
	public Integer selectUserStatusByUname(String userName) {
		Integer ResuleStatus = loginMapper.selectUserStatusByUname(userName);
		return ResuleStatus;
	}

}
