package com.todolist.pojo.operate;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class CompleteTask implements Serializable {
    private Integer uid;
    private Integer tid;
    private MultipartFile image;
    private String title;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CompleteTask{" +
                "uid=" + uid +
                ", tid=" + tid +
                ", image=" + image +
                ", title='" + title + '\'' +
                '}';
    }

    public CompleteTask() {
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



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
