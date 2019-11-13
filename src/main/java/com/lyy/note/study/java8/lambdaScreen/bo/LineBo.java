package com.lyy.note.study.java8.lambdaScreen.bo;

/***
 * 线路
 */
public class LineBo {
	/**线路名*/
	private String lineName;
	/**票数*/
	private Integer sumVote;
	/**计划到达时间*/
	private String arrDate;
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public Integer getSumVote() {
		return sumVote;
	}
	public void setSumVote(Integer sumVote) {
		this.sumVote = sumVote;
	}
	public String getArrDate() {
		return arrDate;
	}
	public void setArrDate(String arrDate) {
		this.arrDate = arrDate;
	}
	@Override
	public String toString() {
		return "Line [lineName=" + lineName + ", sumVote=" + sumVote + ", arrDate=" + arrDate + "]";
	}
	
}
