package com.lyy.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lyy.note.entity.Talk;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TalkMapper {

	/***
	 * 查询说说详情
	 * @param currentPage 当前页
	 * @param pageSize 一页展示多少
	 * @return
	 */
	List<Talk> selectTalk(@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize); 
	
}
