package com.lyy.note.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.note.dao.NoticeMapper;
import com.lyy.note.entity.Notice;
import com.lyy.note.service.NoticeService;

/***
 *  公告接口实现类
 * @author 80004198
 *
 */
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper noticeMapper;
	private static final Logger log =LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	/**根据类型请求
	 * 
	 * 	@param type
	 *  0  站点公告
	 *  1 置顶公告
	 * */
	@Override
	public Notice selectNoticeByType(Integer type) {
		if(type == 0 || type == 1) {
			Notice selectNoticeByType = noticeMapper.selectNoticeByType(type);
			return selectNoticeByType;
		}
		log.error("selectNoticeByType --->传入参数type错误："+type);
		return null;
	}

	@Override
	public List<Notice> selectaAllNotice() {
		List<Notice> selectaAllNotice = noticeMapper.selectaAllNotice();
		return selectaAllNotice;
	}

}
