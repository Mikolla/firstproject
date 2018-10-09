package ru.firstproject.service.impl.user;

import ru.firstproject.dao.abstraction.user.UserDao;
import ru.firstproject.dao.impl.user.UserDaoImpl;
import ru.firstproject.model.User;
import ru.firstproject.service.abstraction.user.UserService;
import ru.firstproject.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.userDao = new UserDaoImpl(connection);
    }

    @Override
    public long saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User getUserById(long id) {
       return userDao.getUserById(id);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(long id) {
         userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
