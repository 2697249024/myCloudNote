package com.lyy.note.study.workStudy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.note.study.workStudy.mapper.PassJobMapper;
import com.lyy.note.study.workStudy.po.PassModelJobPo;
import com.lyy.note.study.workStudy.service.getJobService;

@Service
public class getJobServiceImpl implements getJobService{

	private static final Logger logger = LoggerFactory.getLogger(getJobServiceImpl.class);

	
	@Autowired
	PassJobMapper passJobMapper;
	
	@Override
	public List<PassModelJobPo> getJob() {
		
		List<PassModelJobPo> jobList = passJobMapper.getJob();
		
		jobList.forEach(
			(job) -> {
				logger.info("所有job:"+job.toString());
			}
		);
		return jobList;
	}

}
