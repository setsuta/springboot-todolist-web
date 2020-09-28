package com.todolist.pojo;

import java.io.Serializable;

public class TaskHistory implements Serializable {
    private Integer uid;
    private Integer tid;
    private String status;
    private String date;
    private String title;
    private String archive;

    @Override
    public String toString() {
        return "TaskHistory{" +
                "uid=" + uid +
                ", tid=" + tid +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", archive='" + archive + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
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
