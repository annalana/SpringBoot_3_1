package web.dao;

import web.models.User;
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
        entityManager.remove(getUser(id));
    }
    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public User redactUser(long id, User updated) {
        User user = entityManager.find(User.class, id);
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
