package com.lyy.note.study.workStudy.vo;

import java.io.Serializable;

/***
 * 反馈结果总览
 */
public class FeedbackCountReslutVo implements Serializable{
	private static final long serialVersionUID = -2121151607411486397L;

	/**数据更新日期*/
	private String dateUpdated;
	
	/**任务名称*/
	private String jobName;
	
	/**数据总数*/
	private Integer totalLines;
	
	/**类别 可优化、未反馈、其他具体原因*/
	private String type;
	
	/**该类别的线路数*/
	private Integer lineNum;
	
	/**分组名称 包含 可优化，不优化，未反馈*/
	private String groupCode;

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getTotalLines() {
		return totalLines;
	}

	public void setTotalLines(Integer totalLines) {
		this.totalLines = totalLines;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@Override
	public String toString() {
		return "FeedbackCountReslutVo [dateUpdated=" + dateUpdated + ", jobName=" + jobName + ", totalLines="
				+ totalLines + ", type=" + type + ", lineNum=" + lineNum + ", groupCode=" + groupCode + "]";
	}
	
	
	
	
	
}
