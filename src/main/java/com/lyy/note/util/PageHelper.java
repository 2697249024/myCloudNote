package com.lyy.note.util;

import java.util.List;

/**
 * 分页查询
 * 
 * @author liuyueyang
 * 
 */
public class PageHelper<T> {
	private int currentPage;// 当前页
	private int pageSize;// 每页显示多少条记录
	private int totalCount;// 总记录数
	private int totalPageNum;// 总页数
	private List<T> list;// 当页要显示的数据

	public PageHelper() {
	}

	public PageHelper(int currentPage, int pageSize, int totalCount,
			List<T> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
		if (totalCount != 0 && pageSize != 0) {
			totalPageNum = totalCount / pageSize;
//			if (totalCount % pageSize > 0) {
//				totalPageNum = totalPageNum;
//			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
