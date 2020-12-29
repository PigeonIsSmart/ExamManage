package com.songlea.springboot.demo.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String account;

    private String passwd;

    private String userRole;

    private String examId;

    private Date createTime;

    private Date lastEditTime;

    public User(Integer id, String account, String passwd, String userRole, String examId, Date createTime, Date lastEditTime) {
        this.id = id;
        this.account = account;
        this.passwd = passwd;
        this.userRole = userRole;
        this.examId = examId;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    public User(String account, String passwd, String userRole) {
        this.account = account;
        this.passwd = passwd;
        this.userRole = userRole;
    }

    public User(String account, String passwd, String userRole, String examId) {
        this.account = account;
        this.passwd = passwd;
        this.userRole = userRole;
        this.examId = examId;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
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
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                ", userRole='" + userRole + '\'' +
                ", examId='" + examId + '\'' +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}