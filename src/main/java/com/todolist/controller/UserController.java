package com.todolist.controller;

import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.TaskMapper;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Task;
import com.todolist.service.Learning;
import com.todolist.service.UserService;
import com.todolist.utils.HttpContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    //注入service
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private Learning learning;





    public List<Task> getAllTask(){
        return taskMapper.findAllTask();
    }

    public String result(){
        JSONObject result = new JSONObject();
        try {
            result.put("success",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @ResponseBody
    @PostMapping("/addTask")
    public String addTask(HttpServletRequest request,@RequestBody Task task){

        User userlogin = (User) request.getSession().getAttribute("userlogin");
        learning.taskAdd(userlogin.getUid(),task.getTid());

        return result();
    }



    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        User userlogin=userService.login(user.getUsername());
        if(userlogin.getUsername() != null){
            if(user.getPassword().equals(userlogin.getPassword())){
                HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
                request.getSession().setAttribute("userlogin",userlogin);
                request.getSession().setAttribute("taskList",getAllTask());
                return "redirect:/user/home";
            }else {
                model.addAttribute("msg","用户名或密码错误");
                model.addAttribute("loginError", true);
                return "login";
            }
        }else {
            model.addAttribute("msg","登录失败,请联系管理员");
            return "login";
        }
    }

    @GetMapping("/home")
    public String toHome(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        List<Task> taskList = (List<Task>) request.getSession().getAttribute("taskList");
        model.addAttribute("userlogin",userlogin);
        model.addAttribute("taskList",taskList);
        if(model.getAttribute("userlogin")!= null){
            return "home";
        }else {
            return "redirect:/user/login";
        }
    }

    @PostMapping("/home")
    public String Home(){
        return "home";
    }


    @GetMapping("/forgot")
    public String toForgot(Model model) {
        model.addAttribute("forgot", new User());
        return "forgot";
    }



    @PostMapping("/forgot")
    public Object forgotSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("forgot",user);
        System.out.println(user.getUsername());
        if(user.getUsername() != null){
            return new RedirectView("reset");
        }else {
            return "login";
        }

    }


    @GetMapping("/reset")
    public String toReset(Model model) {
        model.addAttribute("reset", new User());
        return "reset";
    }

    @PostMapping("/reset")
    public String resetSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("reset", user);
        User userlogin=userService.login(user.getUsername());
        if(userlogin.getUsername() != null){
            userlogin.setPassword(user.getPassword());
            userMapper.updatePassword(userlogin);
            model.addAttribute("userlogin", userlogin);
            model.addAttribute("msg","重置密码成功");
            return "/success/resetSuccess";
        }else {
            model.addAttribute("msg","邮箱错误");
            return "reset";
        }

    }

    @GetMapping("/register")
    public String toRegister(Model model) {
        model.addAttribute("register", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("register", user);
        userService.create(user.getName(),user.getUsername(),user.getPassword());
        User userlogin=userService.login(user.getUsername());
        model.addAttribute("userlogin", userlogin);
        return "/success/signupSuccess";
    }

}
