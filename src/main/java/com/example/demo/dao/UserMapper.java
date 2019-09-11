package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;
import com.example.demo.vo.PageQueryDTO;
@Mapper
public interface UserMapper {
	//查询所有用户
	List<User> selectAllUser1();
	//分页查询所有用户 map
	List<User> selectAllUserByPageQuery(PageQueryDTO pageQuery);
	
}
