package com.edteam.course.dao;

import com.edteam.course.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User get(long id);
    User register(User user);
    User update(User user);
    void delete(long id);
    User login(User user);
}
