package com.lyy.note.entity.vo;

/***
 * 搜索结果
 */
public class SearchResultVo {
	
	/**查询的文章id*/
	private String id;
	private String articleTitle;
	private String tag1;
	private String tag2;
	private String tag3;
	/**返回拼接的标题与标签字段*/
	private String searchResult;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getTag1() {
		return tag1;
	}
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}
	public String getTag2() {
		return tag2;
	}
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}
	public String getTag3() {
		return tag3;
	}
	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}
	public String getSearchResult() {
		
		if(articleTitle!=null && articleTitle != "") {
			this.searchResult += articleTitle;
		}
		if(tag1!=null && tag1 != "") {
			this.searchResult += tag1;
		}
		if(tag2!=null && tag2 != "") {
			this.searchResult += tag2;
		}
		if(tag3!=null && tag3 != "") {
			this.searchResult += tag3;
		}
		return searchResult;
	}
	
}
