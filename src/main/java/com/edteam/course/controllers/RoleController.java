package com.edteam.course.controllers;

import com.edteam.course.models.Role;
import com.edteam.course.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Role> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role get(@PathVariable long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Role register(@RequestBody Role role) {
        return service.register(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Role update(@PathVariable long id, @RequestBody Role role) {
        return service.update(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
