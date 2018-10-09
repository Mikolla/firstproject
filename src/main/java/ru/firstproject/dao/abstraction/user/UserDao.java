package ru.firstproject.dao.abstraction.user;



import ru.firstproject.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    long saveUser(User usersDataSet);

    User getUserById(long id);

    void editUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

}
