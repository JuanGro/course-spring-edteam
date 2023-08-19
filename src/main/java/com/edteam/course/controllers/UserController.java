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
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    User register(@RequestBody User user) {
        return userService.register(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@PathVariable long id, @RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        userService.delete(id);
    }

}
