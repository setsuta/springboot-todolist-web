package com.todolist.test;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.TaskMapper;
import com.todolist.pojo.Status;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.element.Task;

import com.todolist.service.StatusService;
import com.todolist.service.impl.LearningImpl;
import com.todolist.utils.HttpContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class TaskTest {
    @Autowired
    private TaskMapper taskMapper;
    @Test
    public void createTask(){
        Task task = new Task();
        task.setCoin(10);
        task.setName("Math course");
        task.setDescription("通过YouTube学习一节数学课，并完成课后练习");
        taskMapper.create(task);
        System.out.println(taskMapper.findAllTask());
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void finduser(){
        System.out.println(userMapper.findAllUser());
    }

    @Autowired
    private LearningImpl learning;
    @Autowired
    private TaskHistoryMapper taskHistoryMapper;


    @Test
    public void completeTask(){
        Integer tid = 1;
        Integer uid = 20;
        String course = "english";
        String path = "/archive/english/test1.jpg";
        learning.complete(uid,tid,path,course);
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        request.getSession().setAttribute("userlogin",userMapper.findByUserId(20));
        System.out.println(taskHistoryMapper.findByTaskHistoryId(uid));
    }

    @Test
    public void addTask(){
        Integer tid = 1;
        Integer uid = 11;
        learning.taskAdd(uid,tid);

    }
    @Autowired
    StatusService statusService;
    @Test
    public void getTask(){
        List<Status> status=statusService.getStatus(2);
        for (Status status1 : status) {
            System.out.println(status1);
        }
    }

    @Test
    public void status(){
        List<TaskHistory> taskHistory=taskHistoryMapper.findAllTaskHistory();
        List<Status> statuses = new ArrayList<>();
        /*Integer number = 1;*/
        for (TaskHistory history : taskHistory) {
            /*Status status = new Status();
            status.setName(userMapper.findByUserId(history.getUid()).getName());
            status.setTaskname(taskMapper.findByTaskId(history.getTid()).getName());
            status.setData(history.getDate());
            status.setTaskstatus(history.getStatus());
            statuses.add(status);*/
            statuses.add(new Status(userMapper.findByUserId(history.getUid()).getName(),
                    taskMapper.findByTaskId(history.getTid()).getName(),history.getDate(),history.getStatus()));

        }

        for (Status status : statuses) {
            System.out.println(status);
        }

    }
}
