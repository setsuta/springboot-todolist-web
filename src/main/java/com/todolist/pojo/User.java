package com.todolist.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private Integer coin;

    public User() {
    }

    public User(Integer uid, String username, String password, String name, Integer coin) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", coin=" + coin +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }
}
