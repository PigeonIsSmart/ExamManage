package com.songlea.springboot.demo.pojo;

import java.util.Date;

public class Problem {
    private Integer id;

    private String title;

    private String desction;

    private String answer;

    private String rightAns;

    private Integer score;

    private Date createTime;

    private Date lastEditTime;

    public Problem(Integer id) {
        this.id = id;
    }

    public Problem(Integer id, String title, String desction, String answer, String rightAns, Integer score, Date createTime, Date lastEditTime) {
        this.id = id;
        this.title = title;
        this.desction = desction;
        this.answer = answer;
        this.rightAns = rightAns;
        this.score = score;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    public Problem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightAns() {
        return rightAns;
    }

    public void setRightAns(String rightAns) {
        this.rightAns = rightAns;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desction='" + desction + '\'' +
                ", answer='" + answer + '\'' +
                ", rightAns='" + rightAns + '\'' +
                ", score=" + score +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}