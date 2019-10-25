package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 获取当前时间工具类
 * @author 80004198
 *
 */
public class GetTimeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(GetTimeUtil.class);
	
	public static Date getNowTime(){
		Date date = new Date();//获得系统时间.
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		String nowTime = sdf.format(date);
		try {
			Date time = sdf.parse(nowTime);
			System.out.println("NowTime:"+time);
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/***
	 *  	拼接日期
	 * @param yyyy-MM-dd
	 * @param hhmm
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getNewDateByJoint(String yyyyMMdd,String hhmm) {
		String resultAdd ="";
		try {
			StringBuffer stringBuffer = new StringBuffer(hhmm);
			StringBuffer Rhhmm = stringBuffer.insert(4, ":00");
			stringBuffer.insert(2, ":");
			resultAdd =yyyyMMdd +" "+ Rhhmm.toString();
			return resultAdd;
		} catch (Exception e) {
			logger.error("日期拼接错误",e);
			return resultAdd;
		}
    }
	
}
