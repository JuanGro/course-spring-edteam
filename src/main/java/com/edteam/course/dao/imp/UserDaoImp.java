package com.edteam.course.dao.imp;

import com.edteam.course.dao.UserDao;
import com.edteam.course.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAll() {
        String hql = "From User as u";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User register(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        User user = get(id);
        entityManager.remove(user);
    }

    @Override
    public User login(User dto) {
        boolean isAuthenticated = false;

        String hql = "FROM User as u WHERE u.password is not null and u.email = :email";

        List<User> result = entityManager.createQuery(hql.toString()).getResultList();

        if (result.isEmpty()) { return null; }

        User user = result.get(0);
        isAuthenticated = true;

        if (!StringUtils.isEmpty(dto.getPassword())) {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
            isAuthenticated = argon2.verify(user.getPassword(), dto.getPassword());
        }

        if (isAuthenticated) {
            return user;
        }

        return null;
    }
}
