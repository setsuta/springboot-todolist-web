package com.todolist.service.impl;


import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.ArchiveMapper;
import com.todolist.mapper.element.TaskMapper;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Archive;
import com.todolist.pojo.element.Task;
import com.todolist.service.Learning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;

@Service
public class LearningImpl implements Learning {

    @Autowired
    private TaskHistoryMapper taskHistoryMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private ArchiveMapper archiveMapper;

    @Autowired
    private UserMapper userMapper;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Transactional
    @Override
    public void taskAdd(Integer uid, Integer tid) {
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setUid(uid);
        taskHistory.setTid(tid);
        taskHistory.setStatus("0");
        taskHistory.setDate(String.valueOf(timestamp));
        taskHistoryMapper.create(taskHistory);
    }

    @Transactional
    @Override
    public void complete(Integer uid, Integer tid,String title,String path) {
        Integer taskCoin = taskMapper.findByTaskId(tid).getCoin();
        User user = userMapper.findByUserId(uid);
        user.setCoin(user.getCoin()+taskCoin);
        userMapper.updateCoin(user);
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setUid(uid);
        taskHistory.setTid(tid);
        taskHistory.setStatus("1");
        taskHistory.setTitle(title);
        taskHistory.setArchive(path);
        taskHistory.setDate(String.valueOf(timestamp));
        taskHistoryMapper.updateStatus(taskHistory);
    }

}
