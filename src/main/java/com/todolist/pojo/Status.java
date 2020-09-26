package com.todolist.pojo;

public class Status {
    private String name;
    private String taskname;
    private String data;
    private String taskstatus;

    public Status() {
    }

    public Status(String name, String taskname, String data, String taskstatus) {
        this.name = name;
        this.taskname = taskname;
        this.data = data;
        this.taskstatus = taskstatus;
    }

    @Override
    public String toString() {
        return "Status{" +
                "name='" + name + '\'' +
                ", taskname='" + taskname + '\'' +
                ", data='" + data + '\'' +
                ", taskstatus='" + taskstatus + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus;
    }
}
