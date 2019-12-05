package com.lyy.note.study;

import org.apache.commons.lang.StringUtils;

public class TestString {
	public static void main(String[] args) {
		String a = "2019-10-01,2019-10-02,2019-10-03,2019-10-04,2019-10-08,2019-10-09,2019-10-10,2019-10-11";
		String substringBefore = StringUtils.substringBefore(a, ",");
		System.out.println("substringBefore:"+substringBefore);
		
		String substringBeforeLast = StringUtils.substringAfterLast(a, ",");
		
		System.out.println("substringBeforeLast:"+substringBeforeLast);
	}
}
