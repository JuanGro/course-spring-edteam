package com.edteam.course.dao;

import com.edteam.course.models.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> getAll();
    Permission get(long id);
    Permission register(Permission permission);
    Permission update(Permission permission);
    void delete(long id);
}
