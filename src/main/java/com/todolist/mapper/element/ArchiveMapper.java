package com.todolist.mapper.element;

import com.todolist.pojo.element.Archive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ArchiveMapper {
    Archive findByArchiveId(Integer uid);
    List<Archive> findAllArchive();
    void create(Archive archive);
    void delete(Archive archive);
}
