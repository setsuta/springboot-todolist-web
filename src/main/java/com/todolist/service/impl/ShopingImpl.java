package com.todolist.service.impl;

import com.todolist.mapper.GradeMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.ArchiveMapper;
import com.todolist.mapper.element.MallMapper;
import com.todolist.pojo.Grade;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Archive;
import com.todolist.pojo.element.Mall;
import com.todolist.service.Shoping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class ShopingImpl implements Shoping {

    @Autowired
    private MallMapper mallMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private UserMapper userMapper;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Transactional
    @Override
    public void add(Integer mid,Integer uid) {
        Mall mall = mallMapper.findByMallId(mid);
        Integer price= mall.getPrice();
        User user = userMapper.findByUserId(uid);
        user.setCoin(user.getCoin()-price);
        userMapper.updateCoin(user);
        Grade grade = new Grade();
        grade.setUid(uid);
        grade.setMid(mid);
        grade.setMidstatus("0");
        grade.setDate(String.valueOf(timestamp));
        gradeMapper.create(grade);
    }
}
