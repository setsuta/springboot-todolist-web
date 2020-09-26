package com.todolist.pojo;

public class Grade {
    private Integer uid;
    private Integer cid;
    private Integer mid;
    private String midstatus;
    private String date;

    @Override
    public String toString() {
        return "Grade{" +
                "uid=" + uid +
                ", cid=" + cid +
                ", mid=" + mid +
                ", midstatus='" + midstatus + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMidstatus() {
        return midstatus;
    }

    public void setMidstatus(String midstatus) {
        this.midstatus = midstatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
