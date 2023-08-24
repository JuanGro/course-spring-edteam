package com.edteam.course.services;

import com.edteam.course.dao.UserDao;
import com.edteam.course.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    public List<User> getAll() {
        return dao.getAll();
    }

    public User get(long id) {
        return dao.get(id);
    }

    public User register(User user) {
        return dao.register(user);
    }

    public User update(User user) {
        return dao.update(user);
    }

    public void delete(long id) {
        dao.delete(id);
    }
}
