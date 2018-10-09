package ru.firstproject.service.abstraction.user;

import ru.firstproject.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    long saveUser(User user);

    User getUserById(long id);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();
}
