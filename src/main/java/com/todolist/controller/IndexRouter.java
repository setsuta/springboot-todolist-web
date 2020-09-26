package com.todolist.controller;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.UserMapper;
import com.todolist.mapper.element.TaskMapper;
import com.todolist.pojo.Status;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Task;
import com.todolist.service.Learning;
import com.todolist.service.StatusService;
import com.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexRouter {

    @GetMapping("/article")
    public String toarticle(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "article";
        }else {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/activities")
    public String toactivities(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "activities";
        }else {
            return "redirect:/user/login";
        }
    }


    @GetMapping("/datatables")
    public String todatatables(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "datatables";
        }else {
            return "redirect:/user/login";
        }
    }


    @GetMapping("/postcreate")
    public String topostcreate(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "postcreate";
        }else {
            return "redirect:/user/login";
        }
    }


    @GetMapping("/pricing")
    public String topricing(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "pricing";
        }else {
            return "redirect:/user/login";
        }
    }


    @GetMapping("/profile")
    public String toprofile(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "profile";
        }else {
            return "redirect:/user/login";
        }
    }


    @GetMapping("/settings")
    public String tosettings(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            return "settings";
        }else {
            return "redirect:/user/login";
        }
    }



    @Autowired
    private StatusService statusService;
    @GetMapping("/status")
    public String tostatus(HttpServletRequest request, Model model) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            model.addAttribute("statusList",statusService.getStatus(userlogin.getUid()));
            return "status";
        }else {
            return "redirect:/user/login";
        }
    }


}
