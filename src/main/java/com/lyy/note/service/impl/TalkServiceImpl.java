package com.lyy.note.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.note.dao.TalkMapper;
import com.lyy.note.entity.Talk;
import com.lyy.note.exception.ActualException;
import com.lyy.note.service.TalkService;
@Service
public class TalkServiceImpl implements TalkService {
	
	private static final  Logger logger =  LoggerFactory.getLogger(TalkServiceImpl.class);
	@Autowired
	TalkMapper talkMapper;

	
	@Override
	public List<Talk> selectTalk(Integer currentPage, Integer pageSize) throws ActualException {
		if(currentPage < 1) {
			logger.info("当前页不能小于1");
		   throw new ActualException("当前页不能小于1");
		}
		try {
			currentPage =(currentPage-1)*pageSize;
			List<Talk> selectTalk = talkMapper.selectTalk(currentPage, pageSize);
			return selectTalk;
			
		} catch (Exception e) {
			logger.error("selectTalk->说说分页错误:"+e);
			throw new ActualException("说说分页查询失败");
		}
	}

}
