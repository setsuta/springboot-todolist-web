package com.todolist.mapper.element;

import com.todolist.pojo.element.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Mapper
public interface TaskMapper {
    Task findByTaskId(Integer tid);
    List<Task> findAllTask();
    void create(Task task);
    void delete(Task task);
}
