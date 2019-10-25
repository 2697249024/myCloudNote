package com.example.demo.study;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.util.ChangeDateUtil;
import com.example.demo.util.GetTimeUtil;

public class Test {
		public static void main(String[] args) {
			
			
			List<String> changeDateExclusiveWednesdayAfter1 = ChangeDateUtil.ChangeDateExclusiveWednesdayAfter1("167", 1);
			System.out.println(changeDateExclusiveWednesdayAfter1.toString());
			
			
//			List<String> a1 = new ArrayList<String>();
//			a1.add("a");
//			List<String> a2 = new ArrayList<String>();
//			a2.add("b");
//			a2.addAll(a1);
//			
//			Map<String , List<String>> a = new HashMap<String, List<String>>();
//			a.put("1", a2);
//			System.out.println(a.get("1"));
//			a2.clear();
//			
//			System.out.println(a.get("1"));
//			
//			String requireType ="";
//			List<String> result = Arrays.asList(requireType.split(","));
//			for (int i = 0; i < result.size(); i++) {
//				System.out.println(result.get(i));
//			}
			
//			
//			String yyyyMMdd="2019-09-03";
//			String hhmm="2025";
//			String newDateByJoint = GetTimeUtil.getNewDateByJoint(yyyyMMdd, hhmm);
//			System.out.println(newDateByJoint);
			
			//String a = "17";
//			
			//List<String> changeDateExclusiveWednesdayBefore = ChangeDateUtil.ChangeDateExclusiveWednesdayAfter1(a, 2);
			
//			System.out.println(changeDateExclusiveWednesdayBefore.toString());
			
			
//			System.out.println("===============>>");
//			String time1 = "0214";
//			BigDecimal time2 = new BigDecimal("2100.2");
//			time2=time2.setScale(2, BigDecimal.ROUND_HALF_UP);
//			System.out.println("time2:"+time2.toString());
			//DecimalFormat df = new DecimalFormat("#0.00");
			//String format = df.format(time2);			
			//BigDecimal hoursReduceTime = ChangeDateUtil.getHoursReduceTime(time1, time2);
//			String time1 ="1040";
//			String time2 ="1030";
//			String hourWithReduceTime = ChangeDateUtil.getHourWithReduceTime(time1, time2);
//			System.out.println(hourWithReduceTime);
			
		}
}
