package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间工具类
 * @author 80004198
 *
 */
public class GetTimeUtil {
	
	public static Date getNowTime(){
		Date date = new Date();//获得系统时间.
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		String nowTime = sdf.format(date);
		try {
			Date time = sdf.parse(nowTime);
			System.out.println("NowTime:"+time);
			return time;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
