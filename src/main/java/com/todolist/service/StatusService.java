package com.todolist.service;

import com.todolist.pojo.Status;

import java.util.List;

public interface StatusService {
    List<Status> getStatus(Integer uid);
}
