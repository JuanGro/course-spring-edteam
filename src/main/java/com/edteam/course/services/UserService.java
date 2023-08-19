package com.edteam.course.services;

import com.edteam.course.dao.UserDao;
import com.edteam.course.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User get(long id) {
        return userDao.get(id);
    }

    public User register(User user) {
        return userDao.register(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }
}
