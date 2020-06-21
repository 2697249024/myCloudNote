package com.lyy.note.entity.pojo;

import java.util.Date;

public class FileImport {
    private Long id;

    private String oldName;

    private String newName;

    private String visitFileUrl;

    private Date createTm;

    private String fileType;

    private String creatUser;

    private String deleteUser;

    private Date deleteTime;

    private Integer valid;

    private Integer status;

    private String realFileUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName == null ? null : oldName.trim();
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName == null ? null : newName.trim();
    }

    public String getVisitFileUrl() {
        return visitFileUrl;
    }

    public void setVisitFileUrl(String visitFileUrl) {
        this.visitFileUrl = visitFileUrl == null ? null : visitFileUrl.trim();
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getCreatUser() {
        return creatUser;
    }

    public void setCreatUser(String creatUser) {
        this.creatUser = creatUser == null ? null : creatUser.trim();
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser == null ? null : deleteUser.trim();
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealFileUrl() {
        return realFileUrl;
    }

    public void setRealFileUrl(String realFileUrl) {
        this.realFileUrl = realFileUrl == null ? null : realFileUrl.trim();
    }
}