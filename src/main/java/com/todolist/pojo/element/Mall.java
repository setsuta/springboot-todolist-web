package com.todolist.pojo.element;

public class Mall {
    private Integer mid;
    private String name;
    private String description;
    private String image;
    private Integer price;

    @Override
    public String toString() {
        return "Mall{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", describe='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
