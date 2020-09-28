package com.todolist.controller;

import com.todolist.mapper.TaskHistoryMapper;
import com.todolist.mapper.element.MallMapper;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.User;
import com.todolist.pojo.element.Mall;
import com.todolist.pojo.operate.CompleteTask;
import com.todolist.service.StatusService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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


    @Autowired
    private TaskHistoryMapper taskHistoryMapper;

    public List<TaskHistory> CurrentTask(HttpServletRequest request){
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        List<TaskHistory> taskHistoryList = taskHistoryMapper.findByTaskHistoryId(userlogin.getUid());
        taskHistoryList.removeIf(taskHistory -> taskHistory.getStatus().equals("1"));
        return taskHistoryList;
    }

    @GetMapping("/postcreate")
    public String topostcreate(HttpServletRequest request, Model model,
                               @ModelAttribute("completeTask") CompleteTask completeTask) {
        User userlogin = (User) request.getSession().getAttribute("userlogin");

        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            List<TaskHistory> taskHistoryList = CurrentTask(request);

            model.addAttribute("taskHistoryList",taskHistoryList);
            return "postcreate";
        }else {
            return "redirect:/user/login";
        }
    }

    @Autowired
    private MallMapper mallMapper;
    @GetMapping("/pricing")
    public String topricing(HttpServletRequest request, Model model) {


        User userlogin = (User) request.getSession().getAttribute("userlogin");
        model.addAttribute("userlogin",userlogin);
        if(model.getAttribute("userlogin")!= null){
            List<Mall> mallList=mallMapper.findAllMall();
            /*for (Mall mall : mallList) {
                mall.setImage("/upload/file/"+mall.getImage());
            }*/
            model.addAttribute("mallList",mallList);
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
