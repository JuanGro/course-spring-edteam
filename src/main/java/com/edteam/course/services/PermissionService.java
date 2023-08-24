package com.edteam.course.services;

import com.edteam.course.dao.PermissionDao;
import com.edteam.course.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionDao dao;

    public List<Permission> getAll() {
        return dao.getAll();
    }

    public Permission get(long id) {
        return dao.get(id);
    }

    public Permission register(Permission permission) {
        return dao.register(permission);
    }

    public Permission update(Permission permission) {
        return dao.update(permission);
    }

    public void delete(long id) {
        dao.delete(id);
    }
}
