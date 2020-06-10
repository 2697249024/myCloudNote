package com.lyy.note.study.feign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.note.dao.LoginMapper;
import com.lyy.note.study.feign.service.GetUsersService;

@Service
public class GetUsersServiceImpl implements GetUsersService	{
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public Integer selectUserStatusByUname(String userName) {
		return loginMapper.selectUserStatusByUname(userName);
	}

}
