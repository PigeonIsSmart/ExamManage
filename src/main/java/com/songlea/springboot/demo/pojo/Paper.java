package com.songlea.springboot.demo.pojo;

import java.util.Date;

public class Paper {
    private Integer id;

    private String choiceIdList;

    private String judgeIdList;

    private String shortAnsIdList;

    private Date createTime;

    private Date lastEditTime;

    public Paper(Integer id, String choiceIdList, String judgeIdList, String shortAnsIdList, Date createTime, Date lastEditTime) {
        this.id = id;
        this.choiceIdList = choiceIdList;
        this.judgeIdList = judgeIdList;
        this.shortAnsIdList = shortAnsIdList;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    public Paper() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChoiceIdList() {
        return choiceIdList;
    }

    public void setChoiceIdList(String choiceIdList) {
        this.choiceIdList = choiceIdList == null ? null : choiceIdList.trim();
    }

    public String getJudgeIdList() {
        return judgeIdList;
    }

    public void setJudgeIdList(String judgeIdList) {
        this.judgeIdList = judgeIdList == null ? null : judgeIdList.trim();
    }

    public String getShortAnsIdList() {
        return shortAnsIdList;
    }

    public void setShortAnsIdList(String shortAnsIdList) {
        this.shortAnsIdList = shortAnsIdList == null ? null : shortAnsIdList.trim();
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
        return "Paper{" +
                "id=" + id +
                ", choiceIdList='" + choiceIdList + '\'' +
                ", judgeIdList='" + judgeIdList + '\'' +
                ", shortAnsIdList='" + shortAnsIdList + '\'' +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}