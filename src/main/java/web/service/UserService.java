package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(long id);
    User getUser(long id);
    User redactUser(long id, User updated);
    List<User> getUserList();
}
