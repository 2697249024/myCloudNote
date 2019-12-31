package com.lyy.note.study.workStudy.service;

import java.util.List;

import com.lyy.note.study.workStudy.po.PassModelJobPo;

/**
 * 获取任务
 */
public interface getJobService {
	
	/***
	 * 获取所有任务
 	 * @return 任务集合
	 */
	List<PassModelJobPo> getJob();
}
