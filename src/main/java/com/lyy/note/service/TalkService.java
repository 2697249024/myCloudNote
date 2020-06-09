package com.lyy.note.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lyy.note.entity.Talk;
import com.lyy.note.exception.ActualException;

/**
 * 说说接口
 * @author 80004198
 */
public interface TalkService {
	
	/**
	 * 分页查询所有说说
	 * @param currentPage 当前页
	 * @param pageSize 每页多少
	 * @throws ActualException 
	 */
	List<Talk> selectTalk(Integer currentPage,Integer pageSize) throws ActualException; 
}
