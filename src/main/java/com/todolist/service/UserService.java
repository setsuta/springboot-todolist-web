package com.todolist.service;

import com.todolist.pojo.User;

public interface UserService {
    void create(String name,String username,String password);
    User login(String username);
}
