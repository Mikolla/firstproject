package ru.firstproject.model;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UsersDataSetDao {

    long saveUser(UsersDataSet usersDataSet) throws SQLException;

    User getUserById(long id);

    void editUser(UsersDataSet usersDataSet);

    void deleteUser(long id);

    List<UsersDataSet> getAllUsers() throws SQLException;

}
