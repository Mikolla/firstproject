package ru.firstproject.model;

import ru.firstproject.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDataSetDaoImpl implements UsersDataSetDao {
    Connection connection = DBHelper.getConnection();


    @Override
    public long saveUser(UsersDataSet usersDataSet) throws SQLException  {
        long id = 0;

        String query = String.format("insert into users (name, password, login) values ('%s', '%s', '%s')", usersDataSet.getName(), usersDataSet.getPassword(), usersDataSet.getLogin());
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while(rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public User getUserById(long id) {

        return null;
    }

    @Override
    public void editUser(UsersDataSet usersDataSet) {

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
