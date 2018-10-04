package ru.firstproject.dao.abstraction.user;



import ru.firstproject.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    long saveUser(User usersDataSet) throws SQLException;

    User getUserById(long id) throws SQLException;

    void editUser(User usersDataSet);

    void deleteUser(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

}
