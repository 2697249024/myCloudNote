package com.lyy.note.entity;
/**
 *   文章Article 入参
 * @author 80004198
 *
 */
public class ArticlePageHelperParam {
	/**
	 * 当前页数
	 */
	private Integer currentPage;
	/**
	 * 分几页
	 */
	private Integer pageSize;
	/**
	 * 需要查询的标签
	 */
	private String tags;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "ArticlePageHelperParam [currentPage=" + currentPage + ", pageSize=" + pageSize + ", tags=" + tags + "]";
	}
	
	
}
