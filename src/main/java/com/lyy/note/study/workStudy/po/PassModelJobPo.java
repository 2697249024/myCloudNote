package com.lyy.note.study.workStudy.po;

import java.util.Date;
public class PassModelJobPo {
    private Long id;

    private String jobName;
    
    private Date publishDate;

    private Date expireDate;

    private Integer isEmail;

    private Integer isExpireEmail;

    private Integer isPublish;

    private Integer jobStatus;

    private Integer jobAssessStatus;

    private String remark;

    private Integer totalLines;

    private Integer totalAreacodes;

    private String creator;

    private String creatorName;

    private Date createTm;

    private String modifyor;

    private String modifyorName;

    private Date modifyTm;

    private Long taskId;

    private String taskBelong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
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

    public Integer getIsEmail() {
        return isEmail;
    }

    public void setIsEmail(Integer isEmail) {
        this.isEmail = isEmail;
    }

    public Integer getIsExpireEmail() {
        return isExpireEmail;
    }

    public void setIsExpireEmail(Integer isExpireEmail) {
        this.isExpireEmail = isExpireEmail;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Integer getJobAssessStatus() {
        return jobAssessStatus;
    }

    public void setJobAssessStatus(Integer jobAssessStatus) {
        this.jobAssessStatus = jobAssessStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(Integer totalLines) {
        this.totalLines = totalLines;
    }

    public Integer getTotalAreacodes() {
        return totalAreacodes;
    }

    public void setTotalAreacodes(Integer totalAreacodes) {
        this.totalAreacodes = totalAreacodes;
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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskBelong() {
        return taskBelong;
    }

    public void setTaskBelong(String taskBelong) {
        this.taskBelong = taskBelong == null ? null : taskBelong.trim();
    }
}