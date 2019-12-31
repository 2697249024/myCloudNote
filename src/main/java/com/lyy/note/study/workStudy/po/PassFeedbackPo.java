package com.lyy.note.study.workStudy.po;

import java.util.Date;

public class PassFeedbackPo {
    private Long id;

    private Long pid;

    private Long processId;

    private String lineCode;

    private Integer assessStatus;

    private Integer isFeedbackSelf;

    private Integer isExec;

    private Integer isFollowTask;

    private String execDate;

    private String replaceTask;

    private String unexecReason;

    private String unexecReasonDesc;

    private String optimizeWay;

    private String optimizeLabel;

    private String creator;

    private String creatorName;

    private Date createTm;

    private String modifyor;

    private String modifyorName;

    private Date modifyTm;

    private Date publishDate;

    private Date expireDate;

    private String taskBelong;

    private String lineAreaBelong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode == null ? null : lineCode.trim();
    }

    public Integer getAssessStatus() {
        return assessStatus;
    }

    public void setAssessStatus(Integer assessStatus) {
        this.assessStatus = assessStatus;
    }

    public Integer getIsFeedbackSelf() {
        return isFeedbackSelf;
    }

    public void setIsFeedbackSelf(Integer isFeedbackSelf) {
        this.isFeedbackSelf = isFeedbackSelf;
    }

    public Integer getIsExec() {
        return isExec;
    }

    public void setIsExec(Integer isExec) {
        this.isExec = isExec;
    }

    public Integer getIsFollowTask() {
        return isFollowTask;
    }

    public void setIsFollowTask(Integer isFollowTask) {
        this.isFollowTask = isFollowTask;
    }

    public String getExecDate() {
        return execDate;
    }

    public void setExecDate(String execDate) {
        this.execDate = execDate == null ? null : execDate.trim();
    }

    public String getReplaceTask() {
        return replaceTask;
    }

    public void setReplaceTask(String replaceTask) {
        this.replaceTask = replaceTask == null ? null : replaceTask.trim();
    }

    public String getUnexecReason() {
        return unexecReason;
    }

    public void setUnexecReason(String unexecReason) {
        this.unexecReason = unexecReason == null ? null : unexecReason.trim();
    }

    public String getUnexecReasonDesc() {
        return unexecReasonDesc;
    }

    public void setUnexecReasonDesc(String unexecReasonDesc) {
        this.unexecReasonDesc = unexecReasonDesc == null ? null : unexecReasonDesc.trim();
    }

    public String getOptimizeWay() {
        return optimizeWay;
    }

    public void setOptimizeWay(String optimizeWay) {
        this.optimizeWay = optimizeWay == null ? null : optimizeWay.trim();
    }

    public String getOptimizeLabel() {
        return optimizeLabel;
    }

    public void setOptimizeLabel(String optimizeLabel) {
        this.optimizeLabel = optimizeLabel == null ? null : optimizeLabel.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public String getModifyor() {
        return modifyor;
    }

    public void setModifyor(String modifyor) {
        this.modifyor = modifyor == null ? null : modifyor.trim();
    }

    public String getModifyorName() {
        return modifyorName;
    }

    public void setModifyorName(String modifyorName) {
        this.modifyorName = modifyorName == null ? null : modifyorName.trim();
    }

    public Date getModifyTm() {
        return modifyTm;
    }

    public void setModifyTm(Date modifyTm) {
        this.modifyTm = modifyTm;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getTaskBelong() {
        return taskBelong;
    }

    public void setTaskBelong(String taskBelong) {
        this.taskBelong = taskBelong == null ? null : taskBelong.trim();
    }

    public String getLineAreaBelong() {
        return lineAreaBelong;
    }

    public void setLineAreaBelong(String lineAreaBelong) {
        this.lineAreaBelong = lineAreaBelong == null ? null : lineAreaBelong.trim();
    }
}