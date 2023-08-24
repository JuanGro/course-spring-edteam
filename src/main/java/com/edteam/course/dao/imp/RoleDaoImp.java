package com.edteam.course.dao.imp;

import com.edteam.course.dao.RoleDao;
import com.edteam.course.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll() {
        String hql = "From Role as p";
        return (List<Role>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Role get(long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    @Override
    public Role register(Role role) {
        return entityManager.merge(role);
    }

    @Transactional
    @Override
    public Role update(Role role) {
        return entityManager.merge(role);
    }

    @Transactional
    @Override
    public void delete(long id) {
        Role role = get(id);
        entityManager.remove(role);
    }
}
