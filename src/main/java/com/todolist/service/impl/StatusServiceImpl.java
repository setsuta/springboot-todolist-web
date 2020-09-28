package com.todolist.service.impl;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.TaskMapper;
import com.todolist.pojo.operate.Status;
import com.todolist.pojo.TaskHistory;
import com.todolist.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private TaskHistoryMapper taskHistoryMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Status> getStatus(Integer uid) {
        List<TaskHistory> taskHistory=taskHistoryMapper.findByTaskHistoryId(uid);
        List<Status> statuses = new ArrayList<>();
        for (TaskHistory history : taskHistory) {
            if (history.getStatus().equals("0")){
                statuses.add(new Status(userMapper.findByUserId(history.getUid()).getName(),
                        taskMapper.findByTaskId(history.getTid()).getName(),history.getDate(),"进行中"));
            }else {
                statuses.add(new Status(userMapper.findByUserId(history.getUid()).getName(),
                        taskMapper.findByTaskId(history.getTid()).getName(),history.getDate(),"已完成"));
            }
        }
        return statuses;
    }


}
