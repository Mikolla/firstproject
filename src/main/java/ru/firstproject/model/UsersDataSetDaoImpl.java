package ru.firstproject.model;

import ru.firstproject.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDataSetDaoImpl implements UsersDataSetDao {
    Connection connection = DBHelper.getConnection();


    @Override
    public long saveUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(long id) {

        return null;
    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public List<UsersDataSet> getAllUsers() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            List<UsersDataSet> usersDataSetListList = new ArrayList<>();
            while (resultSet.next()) {
                usersDataSetListList.add(
                        new UsersDataSet(
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        ));
            }
            for (UsersDataSet user : usersDataSetListList) {
                System.out.println(user);
            }
            return usersDataSetListList;
        }



    }
}
