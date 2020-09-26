package com.todolist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "/Users/linua/Desktop/todolistArchive/";

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
