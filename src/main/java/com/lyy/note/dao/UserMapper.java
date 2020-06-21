package com.lyy.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lyy.note.entity.User;
import com.lyy.note.vo.PageQueryDTO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
	//查询所有用户
	List<User> selectAllUser1();
	//分页查询所有用户 map
	List<User> selectAllUserByPageQuery(PageQueryDTO pageQuery);
	
}
