package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Notice;
import com.example.demo.vo.ResponseDTO;

/***
 *  公告接口
 * @author 80004198
 *
 */
public interface NoticeService {
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
