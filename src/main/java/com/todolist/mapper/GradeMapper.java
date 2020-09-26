package com.todolist.mapper;

import com.todolist.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GradeMapper {
    List<Grade> findByGradeId(Integer uid);
    List<Grade> findAllGrade();
    void create(Grade grade);
    void updateMidstatus(Grade grade);
}
