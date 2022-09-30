package org.example.Service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(int id);

    List<User> getAll();

    void update(int id, User newUser);

    void delete(int id);
}
