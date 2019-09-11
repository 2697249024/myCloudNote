package com.example.demo.entity;

import java.io.Serializable;

/**
 *  公告表
 * @author 80004198
 *
 */
public class Notice implements Serializable{
    private Integer id;
    /**类型 0为站点公告 1为置顶公告*/
    private Long stype;

    /**内容*/
    private String details;

    /**标题*/
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStype() {
        return stype;
    }

    public void setStype(Long stype) {
        this.stype = stype;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}