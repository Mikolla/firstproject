package ru.firstproject.model;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UsersDataSetDao {

    long saveUser(User user);

    User getUserById(long id);

    void editUser(User user);

    void deleteUser(long id);

    List<UsersDataSet> getAllUsers() throws SQLException;

}
