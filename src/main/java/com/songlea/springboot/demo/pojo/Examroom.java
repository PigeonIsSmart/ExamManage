package com.songlea.springboot.demo.pojo;

import java.util.Date;

public class Examroom {
    private Integer id;

    private String title;

    private String desction;

    private String paperId;

    private Date createTime;

    private Date lastEditTime;

    public Examroom(Integer id, String title, String desction, String paperId, Date createTime, Date lastEditTime) {
        this.id = id;
        this.title = title;
        this.desction = desction;
        this.paperId = paperId;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    public Examroom() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDesction() {
        return desction;
    }

    public void setDesction(String desction) {
        this.desction = desction == null ? null : desction.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "Examroom{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desction='" + desction + '\'' +
                ", paperId=" + paperId +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}