package com.todolist.pojo.element;

import java.io.Serializable;

public class Task implements Serializable {
    private Integer tid;
    private String name;
    private String description;
    private Integer coin;

    public Task() {
    }

    public Task(Integer tid, String name, String description, Integer coin) {
        this.tid = tid;
        this.name = name;
        this.description = description;
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", describe='" + description + '\'' +
                ", coin=" + coin +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }
}
