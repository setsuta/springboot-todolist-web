package com.todolist.mapper.element;

import com.todolist.pojo.element.Achievement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AchievementMapper {
    Achievement findByAchievementId(Integer cid);
    List<Achievement> findAllAchievement();
    void delete(Achievement achievement);
    void create(Achievement achievement);
}
