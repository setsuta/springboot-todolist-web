package com.todolist.pojo.element;

public class Achievement {
    private Integer cid;
    private String name;
    private String description;
    private String image;

    @Override
    public String toString() {
        return "Achievement{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", describe='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
