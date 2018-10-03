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
    public UsersDataSet getUserById(long id) throws SQLException {

        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM users where id='%s'", id);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            UsersDataSet usersDataSet = new UsersDataSet(
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        );
            return usersDataSet;

            }
    }

    @Override
    public void editUser(UsersDataSet usersDataSet) {
        System.out.println(usersDataSet.toString());
        try (Statement statement = connection.createStatement()) {
            String query = String.format("update users set name='%s', login='%s', password='%s' where id='%s'",
                    usersDataSet.getName(), usersDataSet.getLogin(), usersDataSet.getPassword(), usersDataSet.getId());
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteUser(long id) throws SQLException {
        String query = String.format("delete from users where id='%s'", id);
        try (Statement statement = connection.createStatement()) {
            boolean resultSet = statement.execute(query);
        }
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

            return usersDataSetListList;
        }



    }
}
