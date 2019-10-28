package com.lyy.note.entity;

import java.io.Serializable;

/**
 *  content实体类
 * @author 80004198
 *
 */
public class Content implements Serializable{
	private static final long serialVersionUID = 5035278573259636654L;
	private String contentId;
	private String detial;
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}
	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", detial=" + detial + "]";
	}
	
}
