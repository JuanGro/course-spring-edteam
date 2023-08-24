package com.edteam.course.services;

import com.edteam.course.dao.UserDao;
import com.edteam.course.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    public void register(User user) {
        String hash = generateHash(user.getPassword());
        user.setPassword(hash);
        dao.register(user);
    }

    public User update(User user) {
        return dao.update(user);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    private String generateHash(String password)
    {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        return argon2.hash(1, 1024 * 1, 1, password);
    }

    public User login(User user) {
        return dao.login(user);
    }
}
