package com.lyy.note.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.lyy.note.exception.ActualException;
import com.lyy.note.service.impl.NoticeServiceImpl;

/**
 * 字符串处理工具
 */
public class StringChackUtils {
	
	private static final Logger logger =LoggerFactory.getLogger(StringChackUtils.class);
	/**
	 * 去除空格"& n bsp";
	 */
	public static String nesgame(String tags) throws ActualException{
		try {
			if(StringUtils.isEmpty(tags)||!tags.contains("&")){
				return tags;
			}
			
			int index = tags.indexOf(";");
			if(index+1==tags.length()) {
				String substring = tags.substring(0, tags.indexOf("&")).trim();
				return substring;
			}
			char charAt = tags.charAt(index+1);
			if(charAt != '\0') {//判断char是否是空字符其实就是'\0' 基本数据类型不会为null
				String substring = tags.substring(tags.indexOf(";")+1,tags.length()).trim();
				return substring;
			}
		} catch (Exception e) {
			logger.error("StringChackUtils-->字符串去空格&异常",e.getMessage());
			throw new ActualException("字符串去空格异常");
		}
		return "";
	}
	
}
