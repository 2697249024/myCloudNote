package com.lyy.note.service;

import java.util.List;

import com.lyy.note.entity.User;
import com.lyy.note.vo.PageQueryDTO;

public interface UserService {
	List<User> selectAllUser1();
	
	//分页查询所有用户 map
	List<User> selectAllUserByPageQuery(PageQueryDTO pageQuery);
}
