package com.todolist.service.impl;

import com.todolist.mapper.UserMapper;
import com.todolist.pojo.User;
import com.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void create(String name,String username,String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setName(name);
        userMapper.create(user);
    }

    @Override
    public User login(String username) {
        return userMapper.login(username);
    }
}
