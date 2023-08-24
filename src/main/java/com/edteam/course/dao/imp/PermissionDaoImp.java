package com.edteam.course.dao.imp;

import com.edteam.course.dao.PermissionDao;
import com.edteam.course.models.Permission;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermissionDaoImp implements PermissionDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Permission> getAll() {
        String hql = "From Permission as p";
        return (List<Permission>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Permission get(long id) {
        return entityManager.find(Permission.class, id);
    }

    @Transactional
    @Override
    public Permission register(Permission permission) {
        return entityManager.merge(permission);
    }

    @Transactional
    @Override
    public Permission update(Permission permission) {
        return entityManager.merge(permission);
    }

    @Transactional
    @Override
    public void delete(long id) {
        Permission permission = get(id);
        entityManager.remove(permission);
    }
}
