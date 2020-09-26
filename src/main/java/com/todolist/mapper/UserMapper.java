package com.todolist.mapper;

import com.todolist.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> findAllUser();
    void create(User user);
    void updateCoin(User user);
    void updatePassword(User user);
    User findByUserId(Integer uid);
    User login(String username);
}
