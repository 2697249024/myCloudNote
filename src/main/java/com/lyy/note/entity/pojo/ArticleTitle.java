package com.lyy.note.entity.pojo;

import java.io.Serializable;

/***
 *  标题
 * @author 80004198
 *
 */
public class ArticleTitle implements Serializable{
	private static final long serialVersionUID = -1609384244526948540L;
	/**文章id*/
	private String id;
	/**文章标题*/
	private String articleTitle;
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
	@Override
	public String toString() {
		return "ArticleTitle [id=" + id + ", articleTitle=" + articleTitle + "]";
	}
	
}
