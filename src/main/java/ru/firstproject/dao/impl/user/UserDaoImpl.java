package ru.firstproject.dao.impl.user;

import ru.firstproject.dao.abstraction.user.UserDao;
import ru.firstproject.dao.executor.Executor;
import ru.firstproject.model.User;
import ru.firstproject.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {
  /* private Connection connection;


    {
        try {
            connection = DBHelper.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
   */

    private final Executor executor;
    public UserDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }





/*
    @Override
    public long saveUser(User usersDataSet) throws SQLException  {
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
*/

    @Override
    public long saveUser(User usersDataSet) throws SQLException {
        return 0;
    }



    @Override
    public User getUserById(long id) throws SQLException {
        String query = String.format("SELECT * FROM users where id='%s'", id);
        ResultSet resultSet = executor.execQuery(query, );
        resultSet.next();
        User user = new User(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4)
        );
        return user;
    }





    @Override
    public void editUser(User usersDataSet) {

    }

    @Override
    public void deleteUser(long id) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

 /*   @Override
    public User getUserById(long id) throws SQLException {

        try (Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM users where id='%s'", id);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            User usersDataSet = new User(
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        );
            return usersDataSet;

            }
    } */


/*
    @Override
    public void editUser(User usersDataSet) {
        System.out.println(usersDataSet.toString());
        try (Statement statement = connection.createStatement()) {
            String query = String.format("update users set name='%s', login='%s', password='%s' where id='%s'",
                    usersDataSet.getName(), usersDataSet.getLogin(), usersDataSet.getPassword(), usersDataSet.getId());
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

/*
    @Override
    public void deleteUser(long id) throws SQLException {
        String query = String.format("delete from users where id='%s'", id);
        try (Statement statement = connection.createStatement()) {
            boolean resultSet = statement.execute(query);
        }
    }
    */

 /*   @Override
    public List<User> getAllUsers() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            List<User> usersDataSetListList = new ArrayList<>();
            while (resultSet.next()) {
                usersDataSetListList.add(
                        new User(
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        ));
            }

            return usersDataSetListList;
        }



    } */




}
