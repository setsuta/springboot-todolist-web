package com.todolist.controller;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Mall;
import com.todolist.pojo.element.Task;
import com.todolist.pojo.operate.CompleteTask;
import com.todolist.service.Shoping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/operate")
public class OperateController {

    public String result(){
        JSONObject result = new JSONObject();
        try {
            result.put("success",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Autowired
    private Shoping shoping;
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @PostMapping("/buy")
    public String buy(HttpServletRequest request,@RequestBody Mall mall){
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        shoping.add(mall.getMid(),userlogin.getUid());
        request.getSession().setAttribute("userlogin",userMapper.findByUserId(userlogin.getUid()));
        return result();
    }
}
