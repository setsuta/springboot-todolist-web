package com.todolist.service;

public interface Learning {
    void taskAdd(Integer uid,Integer tid);
    void complete(Integer uid,Integer tid,String path,String course);
}
