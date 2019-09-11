package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Notice;
import com.example.demo.vo.ResponseDTO;

@Mapper
public interface NoticeMapper {
	
	/**根据类型请求
	 * 
	 * 	@param type
	 *  0  站点公告
	 *  1 置顶公告
	 * */
	Notice selectNoticeByType (Integer type);
	
	/***
	 * 查询全部
	 */
	List<Notice> selectaAllNotice();
}
