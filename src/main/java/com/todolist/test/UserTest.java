package com.todolist.test;

import com.todolist.mapper.UserMapper;
import com.todolist.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void finduser(){
        System.out.println(userMapper.findAllUser());
    }


    @Autowired
    private UserService userService;

    @Test
    public void userCreate(){
        userService.create("ane","cocoannne","123456");
        System.out.println(userMapper.login("cocoannne"));
    }
}
