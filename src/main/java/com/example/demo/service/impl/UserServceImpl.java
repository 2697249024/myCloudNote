package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.PageQueryDTO;

@Service
public class UserServceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServceImpl.class);
	@Autowired
	UserMapper userMapper;
	@Override
	public List<User> selectAllUser1() {
		// TODO Auto-generated method stub
		try {
			List<User> AllUsers = userMapper.selectAllUser1();
			return AllUsers;
		} catch (BadSqlGrammarException e) {
			// TODO: handle exception
			log.error("sql语句错误");
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("其他异常");
			return null;
		}
	}
	
	//分页查询所有用户 map
	@Override
	public List<User> selectAllUserByPageQuery(PageQueryDTO pageQuery) {
		// TODO Auto-generated method stub
		List<User> selectAllUserByPageQuery = userMapper.selectAllUserByPageQuery(pageQuery);
		return selectAllUserByPageQuery;
	}

}
