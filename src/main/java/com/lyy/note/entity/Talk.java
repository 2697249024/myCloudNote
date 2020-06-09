package com.lyy.note.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 说说表
 * @author 80004198
 */
public class Talk implements Serializable{
	private static final long serialVersionUID = -1076728784361543167L;
	
	private String talkId;
	/**内容*/
	private String details;
	/**创建日期*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-6")
	private Date createDate;
	/**评论id*/
	private Integer commentId;
	/**说说状态 0展示 1隐藏*/
	private Integer talkStatus;
	public String getTalkId() {
		return talkId;
	}
	public void setTalkId(String talkId) {
		this.talkId = talkId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
	
		this.createDate = createDate;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getTalkStatus() {
		return talkStatus;
	}
	public void setTalkStatus(Integer talkStatus) {
		this.talkStatus = talkStatus;
	}
	@Override
	public String toString() {
		return "Talk [talkId=" + talkId + ", details=" + details + ", createDate=" + createDate + ", commentId="
				+ commentId + ", talkStatus=" + talkStatus + "]";
	}
	
	
}
