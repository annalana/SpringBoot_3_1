package web.service;

import web.dao.UserDao;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServeceImpl implements UserService{
    UserDao userDao;
    @Autowired
    UserServeceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
    @Transactional
    @Override
    public User redactUser(long id, User updated) {
        return userDao.redactUser(id, updated);
    }
    @Transactional
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
}
