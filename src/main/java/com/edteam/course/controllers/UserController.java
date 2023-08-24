package com.edteam.course.controllers;

import com.edteam.course.models.User;
import com.edteam.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        service.register(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable long id, @RequestBody User user) {
        return service.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
