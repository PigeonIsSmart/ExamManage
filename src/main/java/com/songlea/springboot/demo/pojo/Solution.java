package com.songlea.springboot.demo.pojo;

import java.util.Date;

public class Solution {
    private Integer id;

    private String account;

    private Integer paperId;

    private String choiceAns;

    private String judgeAns;

    private String shortAnswerAns;

    private String status;

    private Integer total;

    private Date createTime;

    private Date lastEditTime;

    public Solution(Integer id, String account, Integer paperId, String choiceAns, String judgeAns, String shortAnswerAns, String status, Integer total, Date createTime, Date lastEditTime) {
        this.id = id;
        this.account = account;
        this.paperId = paperId;
        this.choiceAns = choiceAns;
        this.judgeAns = judgeAns;
        this.shortAnswerAns = shortAnswerAns;
        this.status = status;
        this.total = total;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    public Solution() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getChoiceAns() {
        return choiceAns;
    }

    public void setChoiceAns(String choiceAns) {
        this.choiceAns = choiceAns == null ? null : choiceAns.trim();
    }

    public String getJudgeAns() {
        return judgeAns;
    }

    public void setJudgeAns(String judgeAns) {
        this.judgeAns = judgeAns == null ? null : judgeAns.trim();
    }

    public String getShortAnswerAns() {
        return shortAnswerAns;
    }

    public void setShortAnswerAns(String shortAnswerAns) {
        this.shortAnswerAns = shortAnswerAns == null ? null : shortAnswerAns.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
}