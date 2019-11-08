package com.lyy.note.study.java8.lambdaScreen.service;

import java.util.List;
import java.util.Map;

import com.lyy.note.study.java8.lambdaScreen.bo.LineBo;

/**
 * 线路筛选 
 */
public interface Filterline {
	/***
	 * 线路筛选
	 * @return
	 */
	List<LineBo> selectLine(Map<String, List<LineBo>> LineMap);
	
}
