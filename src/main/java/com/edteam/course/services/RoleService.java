package com.edteam.course.services;

import com.edteam.course.dao.RoleDao;
import com.edteam.course.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao dao;

    public List<Role> getAll() {
        return dao.getAll();
    }

    public Role get(long id) {
        return dao.get(id);
    }

    public Role register(Role role) {
        return dao.register(role);
    }

    public Role update(Role role) {
        return dao.update(role);
    }

    public void delete(long id) {
        dao.delete(id);
    }
}
