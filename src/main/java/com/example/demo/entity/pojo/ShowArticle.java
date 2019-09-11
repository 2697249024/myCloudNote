package com.example.demo.entity.pojo;
/**
 *  内容展示
 * @author 80004198
 *
 */

import java.io.Serializable;
import java.sql.Date;

public class ShowArticle implements Serializable{
	/**id*/
	private String id;
	/**标题*/
	private String articleTitle;
	/**作者*/
	private String userName;
	/**创建时间*/
	private Date articleCreateDate;
	/**标签1*/
	private String tag1;
	/**标签2*/
	private String tag2;
	/**标签3*/
	private String tag3;
	/**文章介绍*/
	private String articleIntro;
	/**展示图片url*/
	private String articlePicture;
	/**笔记详情*/
	private String detial;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getArticleCreateDate() {
		return articleCreateDate;
	}
	public void setArticleCreateDate(Date articleCreateDate) {
		this.articleCreateDate = articleCreateDate;
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
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}
	@Override
	public String toString() {
		return "ShowArticle [id=" + id + ", articleTitle=" + articleTitle + ", userName=" + userName
				+ ", articleCreateDate=" + articleCreateDate + ", tag1=" + tag1 + ", tag2=" + tag2 + ", tag3=" + tag3
				+ ", articleIntro=" + articleIntro + ", articlePicture=" + articlePicture + ", detial=" + detial + "]";
	}
	
}
