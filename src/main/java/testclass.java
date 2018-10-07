import ru.firstproject.dao.abstraction.user.UserDao;
import ru.firstproject.dao.executor.Executor;
import ru.firstproject.dao.impl.user.UserDaoImpl;
import ru.firstproject.model.User;
import ru.firstproject.service.abstraction.user.UserService;
import ru.firstproject.service.impl.user.UserServiceImpl;
import ru.firstproject.util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testclass {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String query = String.format("SELECT * FROM users where id='%s'", 1);
     /*   Executor executor = new Executor(DBHelper.getConnection());
        ResultSet resultSet = executor.execQuery(query);
        resultSet.wasNull();

        boolean b = resultSet.next();
        System.out.println(b);
        System.out.println(resultSet.toString());
        User user = new User(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4)
        );

        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(3));
        System.out.println(resultSet.getString(4));

        UserDaoImpl userDao = new UserDaoImpl(DBHelper.getConnection());
        User user = userDao.getUserById(1);
        */

     UserService userService = new UserServiceImpl();
     User user = userService.getUserById(1);
     userService.deleteUser(16);
     userService.editUser(new User(19,"Bigban123", "passik112", "doomer"));
     userService.getAllUsers().stream().forEach(System.out::println);



    }
}
