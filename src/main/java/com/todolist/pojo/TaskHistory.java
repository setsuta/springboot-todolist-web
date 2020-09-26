package com.todolist.pojo;

public class TaskHistory {
    private Integer uid;
    private Integer tid;
    private String status;
    private String date;


    @Override
    public String toString() {
        return "TaskHistory{" +
                "uid=" + uid +
                ", tid=" + tid +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
