package com.lyy.note.util;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrUtils {
	
	private static final Logger logger =LoggerFactory.getLogger(StrUtils.class);
	
	/***
	 *  版本号增加工具类
	 * @param oldVersion  "V1.0"
	 * @return newVersion "V1.1"
	 */
	public static String versionAdd(String oldVersion) {
		if(oldVersion.length()<4) {
			logger.error("StrUtils versionAdd ->当前版本号：{} ,格式错误",oldVersion);
			return oldVersion;
		}
		logger.info("StrUtils versionAdd ->当前版本号：{}",oldVersion);
		String substring = oldVersion.substring(1);
		BigDecimal b = new BigDecimal(substring);
		BigDecimal valueOf = BigDecimal.valueOf(0.1);
		String newVersion ="V"+b.add(valueOf).toString();
		logger.info("StrUtils versionAdd ->新增版本号：{}",newVersion);
		return newVersion;
		
	}
	
	
	
}
