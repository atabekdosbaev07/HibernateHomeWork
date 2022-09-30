package org.example.Service;

import org.example.Dao.UserDaoImpl;
import org.example.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();


    public User create(User user) {

        return userDao.create(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void update(int id, User newUser) {
        userDao.update(id,newUser);
    }

    public void delete(int id) {
        userDao.delete(id);
    }
}
