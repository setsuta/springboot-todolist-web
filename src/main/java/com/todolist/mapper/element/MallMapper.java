package com.todolist.mapper.element;

import com.todolist.pojo.element.Mall;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface MallMapper {
    Mall findByMallId(Integer mid);
    List<Mall> findAllMall();
    void create(Mall mall);
    void delete(Mall mall);
}
