package com.lyy.note.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ChangeDateUtil {
	
	private static final Logger logger =LoggerFactory.getLogger(ChangeDateUtil.class);
	/**
	 * V1.0 调整前向前推一周 获取二三四五的日期
	 */
	public static List<String> ChangeDateIncludeWednesdayBefore(Integer changeDate){
		//获取当前日期
		Date date = new Date();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		Calendar cal5 = Calendar.getInstance();
		cal2.setTime(getThisWeekMonday(date));
		cal3.setTime(getThisWeekMonday(date));
		cal4.setTime(getThisWeekMonday(date));
		cal5.setTime(getThisWeekMonday(date));
		//向前推N周的周二
		int chdate2 = -(6+(changeDate-1)*7);
		cal2.add(Calendar.DATE, chdate2);
		//向前推N周的周三
		int chdate3 = -(5+(changeDate-1)*7);
		cal3.add(Calendar.DATE, chdate3);
		//向前推N周的周四
		int chdate4= -(4+(changeDate-1)*7);
		cal4.add(Calendar.DATE, chdate4);
		//向前推N周的周五
		int chdate5 = -(3+(changeDate-1)*7);
		cal5.add(Calendar.DATE, chdate5);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String format2 = sdf.format(cal2.getTime());
		String format3 = sdf.format(cal3.getTime());
		String format4 = sdf.format(cal4.getTime());
		String format5 = sdf.format(cal5.getTime());
		List<String> asListResult = Arrays.asList(format2,format3,format4,format5);
		System.out.println("2 3 4 5:"+format2+" "+format3+" "+format4+" "+format5);
		return asListResult;
	}
	
	/***
	 * V1.0 调整后向前适用工作日不包含星期三 向前推两周取与班次适用日期相同的工作日
	 * @param workDay 试用工昨日
	 * @param changeDate 调整日期
	 * @return 日期集合
	 */
	public static List<String> ChangeDateExclusiveWednesdayAfter(String workDay,Integer changeDate){
		//获取当前日期
		Date date = new Date();
		char[] charArray = workDay.toCharArray();
		List<String> asListResult1 = new ArrayList<String>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		for (int i = 0; i < charArray.length; i++) {
			String valueOf = String.valueOf(charArray[i]);
			Calendar cal1 = Calendar.getInstance();
			Calendar calL1 = Calendar.getInstance();
			cal1.setTime(getThisWeekMonday(date));
			calL1.setTime(getThisWeekMonday(date));
			if(valueOf.equals("1")) {
				cal1.add(Calendar.DATE, -(7+(changeDate-1)*7-1));
				calL1.add(Calendar.DATE, -(14+(changeDate-1)*7-1));
				String format1 = sdf1.format(cal1.getTime());
				String formatL1 = sdf1.format(calL1.getTime());
				 logger.info("调整前取周一:[{}],[{}]",format1,formatL1);
				asListResult1.add(format1);
				asListResult1.add(formatL1);
			}
			if(valueOf.equals("6")) {
				cal1.add(Calendar.DATE, -(2+(changeDate-1)*7-1));
				calL1.add(Calendar.DATE, -(9+(changeDate-1)*7-1));
				String format1 = sdf1.format(cal1.getTime());
				String formatL1 = sdf1.format(calL1.getTime());
				logger.info("调整前取周六:[{}],[{}]",format1,formatL1);
				asListResult1.add(format1);
				asListResult1.add(formatL1);
			}
			if(valueOf.equals("7")) {
				cal1.add(Calendar.DATE, -(1+(changeDate-1)*7-1));
				calL1.add(Calendar.DATE, -(8+(changeDate-1)*7-1));
				String format1 = sdf1.format(cal1.getTime());
				String formatL1 = sdf1.format(calL1.getTime());
				logger.info("调整前取周日:[{}],[{}]",format1,formatL1);
				asListResult1.add(format1);
				asListResult1.add(formatL1);
			}
		}
		return asListResult1;
	}
	
	/***
	 * V1.0 调整前向前适用工作日不包含星期三 向前推两周取与班次适用日期相同的工作日（未跨天）
	 * @param workDay 试用工昨日
	 * @param changeDate 调整日期
	 * @return 日期集合
	 */
	public static List<String> ChangeDateExclusiveWednesdayBefore(String workDay,Integer changeDate){
		//获取当前日期
		Date date = new Date();
		char[] charArray = workDay.toCharArray();
		
		List<String> asListResult1 = new ArrayList<String>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		for (int i = 0; i < charArray.length; i++) {
			String valueOf = String.valueOf(charArray[i]);
			Calendar cal1 = Calendar.getInstance();
			Calendar calL1 = Calendar.getInstance();
			cal1.setTime(getThisWeekMonday(date));
			calL1.setTime(getThisWeekMonday(date));
			if(valueOf.equals("1")) {
				cal1.add(Calendar.DATE, -(7+(changeDate-1)*7));
				calL1.add(Calendar.DATE, -(14+(changeDate-1)*7));
				String format1 = sdf1.format(cal1.getTime());
				String formatL1 = sdf1.format(calL1.getTime());
				System.out.println("1:"+format1+",1:"+formatL1);
				asListResult1.add(format1);
				asListResult1.add(formatL1);
			}
			if(valueOf.equals("6")) {
				cal1.add(Calendar.DATE, -(2+(changeDate-1)*7));
				calL1.add(Calendar.DATE, -(9+(changeDate-1)*7));
				String format1 = sdf1.format(cal1.getTime());
				String formatL1 = sdf1.format(calL1.getTime());
				System.out.println("6:"+format1+",6:"+formatL1);
				asListResult1.add(format1);
				asListResult1.add(formatL1);
			}
			if(valueOf.equals("7")) {
				cal1.add(Calendar.DATE, -(1+(changeDate-1)*7));
				calL1.add(Calendar.DATE, -(8+(changeDate-1)*7));
				String format1 = sdf1.format(cal1.getTime());
				String formatL1 = sdf1.format(calL1.getTime());
				System.out.println("7:"+format1+",7:"+formatL1);
				asListResult1.add(format1);
				asListResult1.add(formatL1);
			}
		
			 //logger.info("取数");
		}
		return asListResult1;
	}
	
	/***
	 * V1.0 调整前向前适用工作日不包含星期三 向前推两周取与班次适用日期相同的工作日 最后一个日期往后延一天
	 * @param workDay 试用工昨日
	 * @param changeDate 调整日期
	 * @return 日期集合
	 */
	public static List<String> ChangeDateExclusiveWednesdayAfter1(String workDay,Integer changeDate){
		try {
			//获取当前日期
			Date date = new Date();
			char[] charArray = workDay.toCharArray();
			
			List<String> asListResult1 = new ArrayList<String>();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			Calendar ca1 = Calendar.getInstance();
			Calendar caL1 = Calendar.getInstance();
			for (int i = 0; i < charArray.length; i++) {
				String valueOf = String.valueOf(charArray[i]);
				Calendar cal1 = Calendar.getInstance();
				Calendar calL1 = Calendar.getInstance();
				cal1.setTime(getThisWeekMonday(date));
				calL1.setTime(getThisWeekMonday(date));
				if(valueOf.equals("1")) {
					cal1.add(Calendar.DATE, -(7+(changeDate-1)*7));
					calL1.add(Calendar.DATE, -(14+(changeDate-1)*7));
					String format1 = sdf1.format(cal1.getTime());
					String formatL1 = sdf1.format(calL1.getTime());
					 logger.info("调整前取周一:[{}],[{}]",format1,formatL1);
					asListResult1.add(format1);
					asListResult1.add(formatL1);
					ca1.setTime(cal1.getTime());
					caL1.setTime(calL1.getTime());
					ca1.add(Calendar.DATE, 1);
					caL1.add(Calendar.DATE, 1);
					//加一天
					String format11 = sdf1.format(ca1.getTime());
					String formatL11 = sdf1.format(caL1.getTime());
					asListResult1.add(format11);
					asListResult1.add(formatL11);
					logger.info("周一后延一天日期：[{}],[{}]",format11,formatL11);
				}
				if(valueOf.equals("6")) {
					cal1.add(Calendar.DATE, -(2+(changeDate-1)*7));
					calL1.add(Calendar.DATE, -(9+(changeDate-1)*7));
					String format1 = sdf1.format(cal1.getTime());
					String formatL1 = sdf1.format(calL1.getTime());
					logger.info("调整前取周六:[{}],[{}]",format1,formatL1);
					asListResult1.add(format1);
					asListResult1.add(formatL1);
					ca1.setTime(cal1.getTime());
					caL1.setTime(calL1.getTime());
					ca1.add(Calendar.DATE, 1);
					caL1.add(Calendar.DATE, 1);
					//加一天
					String format11 = sdf1.format(ca1.getTime());
					String formatL11 = sdf1.format(caL1.getTime());
					asListResult1.add(format11);
					asListResult1.add(formatL11);
					logger.info("周六后延一天日期：[{}],[{}]",format11,formatL11);
				}
				if(valueOf.equals("7")) {
					cal1.add(Calendar.DATE, -(1+(changeDate-1)*7));
					calL1.add(Calendar.DATE, -(8+(changeDate-1)*7));
					String format1 = sdf1.format(cal1.getTime());
					String formatL1 = sdf1.format(calL1.getTime());
					logger.info("调整前取周日:[{}],[{}]",format1,formatL1);
					asListResult1.add(format1);
					asListResult1.add(formatL1);
					ca1.setTime(cal1.getTime());
					caL1.setTime(calL1.getTime());
					ca1.add(Calendar.DATE, 1);
					caL1.add(Calendar.DATE, 1);
					//加一天
					String format11 = sdf1.format(ca1.getTime());
					String formatL11 = sdf1.format(caL1.getTime());
					asListResult1.add(format11);
					asListResult1.add(formatL11);
					logger.info("周日后延一天日期：[{}],[{}]",format11,formatL11);
				}
			}
			asListResult1.sort(null);
			return asListResult1;
		} catch (Exception e) {
			logger.error("日期获取错误",e);
			return null;
		}
	}
	
	
	
	/**获取本周一的时间*/
	public static Date getThisWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}
	/**获取下周一时间*/
	public static String getNextWeekTuesday(Date date,Integer changeDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, 7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String format = sdf.format(cal.getTime());
		return format;
	}
	
	/***
	 *  增加时间
	 * @param addtime 增加时间 min
	 * @param prothromiTime 传入时间  HHmm
	 * @return HHmm
	 */
	public static String addTime(Integer addtime, String prothromiTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		 Date currdate;
		 String enddate = "";
		try {
			currdate = sdf.parse(prothromiTime);
			
		 //System.out.println("现在的时间是：" + currdate);
		 currdate.setTime(currdate.getTime()+ addtime*60*1000);
		 
		 //System.out.println("增加后的时间：" + currdate);
		 enddate = sdf.format(currdate);
		 logger.info("现在的时间是： [{}],增加的时间为：[{}], 增加后的结果是：[{}]",prothromiTime,addtime,enddate);
		} catch (ParseException e) {
			logger.error("addTime 时间格式错误",e);
		}
		return enddate;
	}
	
	/***
	 *  减少时间
	 * @param reducetime 减少的时间 min
	 * @param prothromiTime 传入时间  HHmm
	 * @return HHmm
	 */
	public static String reduceTime(Integer reducetime, String prothromiTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		 Date currdate;
		 String enddate = "";
		try {
			currdate = sdf.parse(prothromiTime);
		 //System.out.println("现在的时间是：" + currdate);
		 currdate.setTime(currdate.getTime()- reducetime*60*1000);
		 //System.out.println("减少后的时间：" + currdate);
		 enddate = sdf.format(currdate);
		 logger.info("现在的时间是： [{}],减少的时间为：[{}], 减少后的结果是：[{}]",prothromiTime,reducetime,enddate);
		} catch (ParseException e) {
			logger.error("reduceTime 时间格式错误",e);
		}
		return enddate;
	}
	
	/***
	 * HHmm 相减获取时差
	 * @param time1 HHmm1
	 * @param time2	HHmm2
	 * @return 时差 HHmm
	 */
	public static String getHourWithReduceTime(String time1, String time2) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
		long result;
		String thrResult="";
		try {
			result = sdf.parse(time1).getTime() - sdf.parse(time2).getTime()+sdf1.parse("1970").getTime();//加上1970年
			Date d1 = new Date(result);
			thrResult= sdf.format(d1).toString();
			return thrResult;
		} catch (ParseException e) {
			logger.error("getHourWithReduceTime  时间相减获取小时差异常",e);
			return thrResult;
		}
	}
	
	/***
	 * 相减获取小时差 保留两位小数
	 * @param time1 String HHmm 小时时间 0201 2小时1分钟
	 * @param time2 BigDecimal 0.20 0小时20分钟
	 * @return BigDecimal 相减得到  保留两位小数 
	 */
	public static BigDecimal getHoursReduceTime(String time1,BigDecimal time2) {
		//减去time2
        BigDecimal subtract =null;
		try {
			//截取time1
			String min = time1.substring(time1.length()-2, time1.length());
			String hour = time1.substring(0, time1.length()-2);
			//转换格式
			BigDecimal bd= new BigDecimal(min);
			BigDecimal bd2 = new BigDecimal("60");
			 //除 保留两位小数
			BigDecimal minute = bd.divide(bd2,2, BigDecimal.ROUND_HALF_UP);
	        //System.out.println( minute + "小时");
			 BigDecimal hours = new BigDecimal(hour);
			//System.out.println( hours + "小时");
			 //求和
	        BigDecimal add = hours.add(minute);
	        //System.out.println(add);
			//减去time2
	        subtract = add.subtract(time2);
	        return subtract;
		} catch (Exception e) {
			logger.error("getHoursReduceTime -->返回小时差,时间处理异常",e);
			return subtract;
		}
	}
	/**
	 *  返回小时差 
	 * @param endDate yyyy-MM-dd HH:mm:ss
	 * @param nowDate yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDatePoorWithHour(String endDate, String nowDate) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double nh1 = 1000 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        double diff1;
		try {
			diff1 = df.parse(endDate).getTime() - df.parse(nowDate).getTime();
			//获得的时间差除以小时
	        double hours = diff1/nh1;
	        //保留两位小数
	        DecimalFormat dft = new DecimalFormat("#.00");
	        String result = dft.format(hours);
	        //System.out.println("hours:="+result);
	        return result;
		} catch (ParseException e) {
			logger.error("TimeDifferenceUtil -->getDatePoorWithHour -->返回小时差,时间处理异常",e);
		}
		return null;
    }
	
	
	/***
	 *   转换时间
	 * @param 入参 timeParam1 yyyy-MM-dd HH:mm:ss
	 * @return 获得 HHmm
	 */
	public static String transferTime(String timeParam1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HHmm");
		String format = "";
		try {
			Date parse = sdf.parse(timeParam1);
			format = sdf1.format(parse);
		} catch (ParseException e) {
			logger.error("transferTime--->转换时间异常",e);
		}
		return format;
	}
	/***
	 *  比较时间大小
	 * @param timeParam1  时间1
	 * @param timeParam2  时间2
	 * @return -1 表示timeParam1 < timeParam2   1表示timeParam1 > timeParam2  0  表示timeParam1 = timeParam2
	 */
	public static Integer compareTime(String timeParam1, String timeParam2) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
			 Date sTime = sdf.parse(timeParam1);
			 Date eTime = sdf.parse(timeParam2);
			 int compareTo = sTime.compareTo(eTime);
			logger.info("传入的时间：timeParam1: [{}], timeParam2 :[{}], 比较结果：[{}]",timeParam1,timeParam2,compareTo);
			return compareTo;
		} catch (Exception e) {
			logger.error("compareTime 时间格式错误",e);
		}
		return null;
	}
	
	
}
