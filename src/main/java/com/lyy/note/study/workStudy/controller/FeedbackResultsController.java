package com.lyy.note.study.workStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyy.note.study.workStudy.po.PassModelJobPo;
import com.lyy.note.study.workStudy.service.getJobService;
import com.lyy.note.vo.ResponseDTO;

/***
 *  Stream练习
 */
@RestController
public class FeedbackResultsController {

	@Autowired
	getJobService getJob;
	/***
	 * 
	 * @return
	 */
	@RequestMapping(value = "/streamStudy", method = RequestMethod.POST)
	 public ResponseDTO<List<PassModelJobPo>> streamStudy(String taskBelong){
		 	
		List<PassModelJobPo> job = getJob.getJob();
		if(job !=null && !job.isEmpty()  ) {
			return	ResponseDTO.buildSuccessMsg(job, "任务信息");
		}
		 return ResponseDTO.buildFailure("查询失败");
	 }
	

	 
	
}
