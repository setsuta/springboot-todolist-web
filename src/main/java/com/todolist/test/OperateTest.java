package com.todolist.test;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.User;
import com.todolist.service.Learning;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@SpringBootTest()
@RunWith(SpringRunner.class)
public class OperateTest {

    @Autowired
    private TaskHistoryMapper taskHistoryMapper;

    @Test
    public void test(){


        List<TaskHistory> taskHistoryList = taskHistoryMapper.findByTaskHistoryId(20);
        for (TaskHistory taskHistory : taskHistoryList) {

            System.out.println(taskHistory);
        }
        taskHistoryList.removeIf(taskHistory -> taskHistory.getStatus().equals("1"));
        for (TaskHistory taskHistory : taskHistoryList) {

            System.out.println(taskHistory);
        }
    }


    @Autowired
    public Learning learning;
    @Test
    public void test2(){
        learning.complete(20,2,"Math homework","103410_83613742_p0.jpg");
        for (TaskHistory taskHistory : taskHistoryMapper.findByTaskHistoryId(20)) {
            System.out.println(taskHistory);
        }
    }

}
