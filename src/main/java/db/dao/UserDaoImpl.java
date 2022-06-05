package db.dao;


import db.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public void removeUser(long id) {
        entityManager
                .createQuery("delete from User where id=?1")
                .setParameter(1, id).executeUpdate();
    }
    @Override
    public User getUser(long id) {
        return entityManager.createQuery("from User where id=?1", User.class)
                .setParameter(1, id).getSingleResult();
    }
    @Override
    public User redactUser(long id, User updated) {

        User user = entityManager
                .createQuery("from User where id=?1", User.class).setParameter(1,id)
                .getSingleResult();
        System.out.println(user);
        user.setEmail(updated.getEmail());
        user.setLastName(updated.getLastName());
        user.setPhoneNumber(updated.getPhoneNumber());
        user.setName(updated.getName());
        entityManager.merge(user);
        return user;
    }
    @Override
    public List<User> getUserList() {
        return entityManager
                .createQuery("from User", User.class).getResultList();
    }
}
