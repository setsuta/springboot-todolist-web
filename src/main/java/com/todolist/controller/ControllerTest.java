package com.todolist.controller;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.TaskMapper;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Task;
import com.todolist.service.impl.LearningImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ControllerTest {
    @Autowired
    private UserMapper userMapper;




    @RequestMapping("/query")
    @ResponseBody
    public List<User> findAllUser(){
        List<User> userList = userMapper.findAllUser();
        System.out.println(userList);
        return userList;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String create(User user, Model model) {

        try {
            user = new User();
            user.setName("qier");
            user.setUsername("xiaoxiaoqi");
            user.setPassword("lqe2020");
            userMapper.create(user);
            model.addAttribute("message", "保存客户信息系成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(findAllUser());
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateCoin(User user, Model model) {

        try {
            user = new User();
            user.setUid(2);
            user.setCoin(10);
            userMapper.updateCoin(user);
            model.addAttribute("message", "保存客户信息系成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(findAllUser());
    }

    @RequestMapping(value = "/find")
    @ResponseBody
    public User findById(User user, Model model) {

        try {
            user = new User();
            user.setUid(2);
            userMapper.findByUserId(user.getUid());
            model.addAttribute("message", "保存客户信息系成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMapper.findByUserId(user.getUid());
    }



    @Autowired
    private TaskMapper taskMapper;
    @RequestMapping(value = "/createTask")
    @ResponseBody
    public void createTask(){
        Task task = new Task();
        task.setCoin(10);
        task.setName("English course");
        task.setDescription("通过多邻国学习英语一个小时，并且记上自己的笔记");
        taskMapper.create(task);
        System.out.println(taskMapper.findAllTask());
    }



    @Autowired
    private LearningImpl learning;
    @Autowired
    private TaskHistoryMapper taskHistoryMapper;
    @RequestMapping(value = "/addTask")
    @ResponseBody
    public List<TaskHistory> addTask(Integer uid, Integer tid){
        tid = 1;
        uid = 11;
        learning.taskAdd(uid,tid);
        return taskHistoryMapper.findAllTaskHistory();
    }

    @RequestMapping(value = "/completeTask")
    @ResponseBody
    public List<TaskHistory> completeTask(Integer uid, Integer tid,String path,String course){
        tid = 2;
        uid = 11;
        course = "english";
        path = "/test/test.jpg";
        learning.complete(uid,tid,path,course);
        return taskHistoryMapper.findByTaskHistoryId(uid);
    }
}
