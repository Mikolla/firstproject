package ru.firstproject.model;



import java.sql.SQLException;
import java.util.List;

public interface UsersDataSetDao {

    long saveUser(UsersDataSet usersDataSet) throws SQLException;

    UsersDataSet getUserById(long id) throws SQLException;

    void editUser(UsersDataSet usersDataSet);

    void deleteUser(long id) throws SQLException;

    List<UsersDataSet> getAllUsers() throws SQLException;

}
