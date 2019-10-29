package com.lyy.note.entity.vo;

import java.io.Serializable;

/**
 * 标签统计对象 
 */
public class TagResultVo implements Serializable{
	private static final long serialVersionUID = 4028767017424409137L;
	
	public String name;
	public Long count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
