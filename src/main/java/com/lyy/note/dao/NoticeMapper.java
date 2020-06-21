package com.lyy.note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lyy.note.entity.Notice;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
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
