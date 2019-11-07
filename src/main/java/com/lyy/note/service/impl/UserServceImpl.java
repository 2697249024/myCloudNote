package com.lyy.note.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import com.lyy.note.dao.UserMapper;
import com.lyy.note.entity.User;
import com.lyy.note.service.UserService;
import com.lyy.note.vo.PageQueryDTO;

@Service
public class UserServceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServceImpl.class);
	@Autowired
	UserMapper userMapper;
	@Override
	public List<User> selectAllUser1() {
		try {
			List<User> AllUsers = userMapper.selectAllUser1();
			return AllUsers;
		} catch (BadSqlGrammarException e) {
			log.error("sql语句错误");
			return null;
		} catch (Exception e) {
			log.error("其他异常");
			return null;
		}
	}
	
	//分页查询所有用户 map
	@Override
	public List<User> selectAllUserByPageQuery(PageQueryDTO pageQuery) {
		List<User> selectAllUserByPageQuery = userMapper.selectAllUserByPageQuery(pageQuery);
		return selectAllUserByPageQuery;
	}

}
