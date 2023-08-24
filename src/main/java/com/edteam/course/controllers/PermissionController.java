package com.edteam.course.controllers;

import com.edteam.course.models.Permission;
import com.edteam.course.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    PermissionService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permission> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permission get(@PathVariable long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permission register(@RequestBody Permission permission) {
        return service.register(permission);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permission update(@PathVariable long id, @RequestBody Permission permission) {
        return service.update(permission);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        service.delete(id);
    }
}
