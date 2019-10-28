package com.lyy.note.vo;

import java.io.Serializable;

/**
 * 前端分页组件查询对象
 */
public class PageQueryDTO implements Serializable{
	private static final long serialVersionUID = -8786901568612592254L;
	//默认页数
	public static final int DEFAULT_PAGENO = 1;
	//默认每页展示数量
	public static final int DEFAULT_PAGESIZE = 10;
	
	/**
	 * 分页页码，从1开始（和前端保持一致）
	 */
	private int pageNo;
	
	/**
	 * 分页大小 ，每页显示的条数
	 */
	private int pageSize;

	/**
	 *开始位置即 页码
	 */
	private int startIndex;
	
	public PageQueryDTO(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}


	public int getPageNo() {
		return pageNo <= 0 ? DEFAULT_PAGENO : pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize <= 0 ?DEFAULT_PAGESIZE : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	// 页码
	public int getStartIndex() {
		return pageNo >= 1 ? (pageNo-1)*pageSize : 0;
	}

	
	
	
	
}
