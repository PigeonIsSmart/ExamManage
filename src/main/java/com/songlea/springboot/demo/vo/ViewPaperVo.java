package com.songlea.springboot.demo.vo;

/**
 * Description:
 * Created By xxm
 */
public class ViewPaperVo {

    private String account;
    private String title; // 题型
    private String desc; // 题目
    private String ans; // 学生答案
    private String rightAns; // 选择题正确答案,简答题忽略
    private String total; // 总分,如果批阅过

    public String getRightAns() {
        return rightAns;
    }

    public void setRightAns(String rightAns) {
        this.rightAns = rightAns;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ViewPaperVo{" +
                "account='" + account + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", ans='" + ans + '\'' +
                ", rightAns='" + rightAns + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
