package com.todolist.controller;

import com.todolist.config.StorageProperties;
import com.todolist.exception.StorageFileNotFoundException;
import com.todolist.mapper.UserMapper;
import com.todolist.pojo.TaskHistory;
import com.todolist.pojo.User;
import com.todolist.pojo.operate.CompleteTask;
import com.todolist.service.Learning;
import com.todolist.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private final StorageService storageService;

    @Autowired
    public UploadController(StorageService storageService){
        this.storageService = storageService;
    }


    @GetMapping("/file")
    public String listUplodeFiles(Model model,@ModelAttribute("completeTask") CompleteTask completeTask){
        List<TaskHistory> taskHistoryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TaskHistory taskHistory = new TaskHistory();
            taskHistory.setTid(i);
            taskHistoryList.add(taskHistory);
        }
        model.addAttribute("taskHistoryList",taskHistoryList);
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(UploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/upload/file";
    }


    @PostMapping("/bookinfo")
    public String toBookInfo(@ModelAttribute("completeTask") CompleteTask completeTask) {
        storageService.store(completeTask.getImage());

        return "redirect:/upload/file";
    }


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Learning learning;
    @PostMapping("/complete")
    public String toComplete(@ModelAttribute("completeTask") CompleteTask completeTask,HttpServletRequest request) {

        storageService.store(completeTask.getImage());
        User userlogin = (User) request.getSession().getAttribute("userlogin");
        learning.complete(userlogin.getUid(),completeTask.getTid(),completeTask.getTitle(),completeTask.getImage().getOriginalFilename());
        request.getSession().setAttribute("userlogin",userMapper.findByUserId(userlogin.getUid()));
        return "redirect:/user/home";
    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
