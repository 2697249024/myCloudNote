package com.lyy.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyy.note.entity.Talk;
import com.lyy.note.exception.ActualException;
import com.lyy.note.service.TalkService;
import com.lyy.note.vo.ResponseDTO;

/**
 *  说说
 * @author 80004198
 *
 */
@RestController
public class TalkController {
	
	@Autowired
	TalkService talkService;
	
	/**
	 * 查询说说内容
	 * @param currentPage 当前页
	 * @param pageSize 
	 * @return
	 */
	@RequestMapping(value = "/selectTalkDetails",method = RequestMethod.POST)
	public ResponseDTO<List<Talk>> selectTalkDetails(Integer currentPage,Integer pageSize) {
		try {
			List<Talk> selectTalk = talkService.selectTalk(currentPage, pageSize);
			return ResponseDTO.buildSuccessMsg(selectTalk, "查询成功！");
		} catch (Exception e) {
			if(e instanceof ActualException) {
				return ResponseDTO.buildFailure(e.getMessage());
			}
			return ResponseDTO.buildFailure("网络异常");
		}
	}
	
}
