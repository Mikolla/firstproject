package ru.firstproject.dao.impl.user;

import ru.firstproject.dao.abstraction.user.UserDao;
import ru.firstproject.dao.executor.Executor;
import ru.firstproject.dao.executor.ExecutorHelper;
import ru.firstproject.model.User;
import ru.firstproject.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {
      private final Executor executor;
    public UserDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }



    @Override
    public long saveUser(User user) throws SQLException {
        String query = String.format("insert into users (name, login, password) values ('%s', '%s', '%s')", user.getName(), user.getLogin(), user.getPassword());
        long id = executor.execUpdateWithKeys(query);
        return id;
    }

    @Override
    public User getUserById(long id) throws SQLException {
        String query = String.format("SELECT * FROM users where id='%s'", id);
        User user = executor.execQuery(query, new ExecutorHelper<User>() {
            @Override
            public User help(ResultSet resultSet) throws SQLException {
                resultSet.next();
                User user = new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getString(3));
                return user;
            }
        });
        return user;
    }



    @Override
    public List<User> getAllUsers() throws SQLException {
            String query = "SELECT * FROM users";
            List<User> users = executor.execQuery(query, new ExecutorHelper<List<User>>() {
                @Override
                public List<User> help(ResultSet resultSet) throws SQLException {
                    List<User> userList = new ArrayList<>();
                    while (resultSet.next()) {
                        User user = new User(
                                resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getString(4),
                                resultSet.getString(3));
                        userList.add(user);
                    }
                    return userList;
                }
            });
        return users;
    }


    @Override
    public void editUser(User user) {
        String query = String.format("update users set name='%s', login='%s', password='%s' where id='%s'",
        user.getName(), user.getLogin(), user.getPassword(), user.getId());
        executor.execUpdate(query);
    }



    @Override
    public void deleteUser(long id) throws SQLException {
        String query = String.format("delete from users where id='%s'", id);
        executor.execUpdate(query);
    }

}
