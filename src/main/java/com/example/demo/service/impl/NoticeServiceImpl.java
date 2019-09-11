package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NoticeMapper;
import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

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
		// TODO Auto-generated method stub
		if(type == 0 || type == 1) {
			Notice selectNoticeByType = noticeMapper.selectNoticeByType(type);
			return selectNoticeByType;
		}
		log.error("selectNoticeByType --->传入参数type错误："+type);
		return null;
	}

	@Override
	public List<Notice> selectaAllNotice() {
		// TODO Auto-generated method stub
		List<Notice> selectaAllNotice = noticeMapper.selectaAllNotice();
		return selectaAllNotice;
	}

}
