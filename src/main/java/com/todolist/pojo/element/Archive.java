package com.todolist.pojo.element;

public class Archive {
    private Integer uid;
    private String literature;
    private String math;
    private String english;
    private String other;
    private String date;

    @Override
    public String toString() {
        return "Archive{" +
                "uid=" + uid +
                ", literature='" + literature + '\'' +
                ", math='" + math + '\'' +
                ", english='" + english + '\'' +
                ", other='" + other + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
