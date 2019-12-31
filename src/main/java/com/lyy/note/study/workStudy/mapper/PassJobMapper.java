package com.lyy.note.study.workStudy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lyy.note.study.workStudy.po.PassModelJobPo;
/**
 * 获取任务表数据
 */
@Mapper
public interface PassJobMapper {
	
	
	List<PassModelJobPo> getJob();
	
}
