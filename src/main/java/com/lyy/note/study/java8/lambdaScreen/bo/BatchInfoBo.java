package com.lyy.note.study.java8.lambdaScreen.bo;

/**
 * 班次信息
 */
public class BatchInfoBo {
	private String batchName;
	private String date;
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BatchInfo [batchName=" + batchName + ", date=" + date + "]";
	}
	
	
}
