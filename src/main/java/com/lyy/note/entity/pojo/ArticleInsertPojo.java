package com.lyy.note.entity.pojo;

import java.io.Serializable;
import java.util.Date;

/***
 * 文章插入实体类
 * @author 80004198
 *	@param id
 *	@param articleTitle 标题
 *	@param articleContentId 详情id
 *	@param postedId 用户id
 *	@param articleCreateDate 发表日期
 *	@param articleTagId 标签id
 *	@param articleIntro 简介
 *	@param articlePicture 简介配图url
 */
public class ArticleInsertPojo implements Serializable{
	
	private static final long serialVersionUID = -7679146406811100794L;
	/**id*/
	private String id;
	/**标题*/
	private String articleTitle;
	/**详情id*/
	private String articleContentId;
	/**用户id*/
	private Integer postedId;
	/**发表日期*/
	private Date articleCreateDate;
	/**标签id*/
	private String articleTagId;
	/**简介*/
	private String articleIntro;
	/**简介配图url*/
	private String articlePicture;
	/**阅读量*/
	private Integer readingQuantity;
	
	
	public Integer getReadingQuantity() {
		return readingQuantity;
	}
	public void setReadingQuantity(Integer readingQuantity) {
		this.readingQuantity = readingQuantity;
	}
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
	public String getArticleContentId() {
		return articleContentId;
	}
	public void setArticleContentId(String articleContentId) {
		this.articleContentId = articleContentId;
	}
	public Integer getPostedId() {
		return postedId;
	}
	public void setPostedId(Integer postedId) {
		this.postedId = postedId;
	}
	public Date getArticleCreateDate() {
		return articleCreateDate;
	}
	public void setArticleCreateDate(Date articleCreateDate) {
		this.articleCreateDate = articleCreateDate;
	}
	public String getArticleTagId() {
		return articleTagId;
	}
	public void setArticleTagId(String articleTagId) {
		this.articleTagId = articleTagId;
	}
	public String getArticleIntro() {
		return articleIntro;
	}
	public void setArticleIntro(String articleIntro) {
		this.articleIntro = articleIntro;
	}
	public String getArticlePicture() {
		return articlePicture;
	}
	public void setArticlePicture(String articlePicture) {
		this.articlePicture = articlePicture;
	}
	
	@Override
	public String toString() {
		return "ArticleInsertPojo [id=" + id + ", articleTitle=" + articleTitle + ", articleContentId="
				+ articleContentId + ", postedId=" + postedId + ", articleCreateDate=" + articleCreateDate
				+ ", articleTagId=" + articleTagId + ", articleIntro=" + articleIntro + ", articlePicture="
				+ articlePicture + ", readingQuantity=" + readingQuantity + "]";
	}
	
	
}
