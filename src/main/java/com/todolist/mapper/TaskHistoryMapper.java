package com.todolist.mapper;


import com.todolist.pojo.TaskHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Mapper
public interface TaskHistoryMapper {
    List<TaskHistory> findByTaskHistoryId(Integer uid);
    List<TaskHistory> findAllTaskHistory();
    void create(TaskHistory taskHistory);
    void updateStatus(TaskHistory taskHistory);
}
