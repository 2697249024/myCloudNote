package com.example.demo.entity;

import java.io.Serializable;

/**
 *  content实体类
 * @author 80004198
 *
 */
public class Content implements Serializable{
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
