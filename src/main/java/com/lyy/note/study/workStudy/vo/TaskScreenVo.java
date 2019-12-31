package com.lyy.note.study.workStudy.vo;

import java.io.Serializable;

/**
 *  入参
 */
public class TaskScreenVo implements Serializable{
	private static final long serialVersionUID = 7925432758447827457L;
	
	/**任务类型 传参：低效益线路优化 or 转飞转运分析*/
	private String taskBelong;
	/**任务ID*/
	private Integer processId;
	/**开始时间 YYYY-MM-dd*/
	private String startTime;
	/**结束时间 YYYY-MM-dd*/
	private Integer endTime;
	
	/**任务状态0-进行中，1-已结束*/
	private Integer assessStatus;
	
	
	public Integer getAssessStatus() {
		return assessStatus;
	}
	public void setAssessStatus(Integer assessStatus) {
		this.assessStatus = assessStatus;
	}
	public String getTaskBelong() {
		return taskBelong;
	}
	public void setTaskBelong(String taskBelong) {
		this.taskBelong = taskBelong;
	}
	public Integer getProcessId() {
		return processId;
	}
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "TaskScreenVo [taskBelong=" + taskBelong + ", processId=" + processId + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", assessStatus=" + assessStatus + "]";
	}
	
}
