package ru.firstproject.model;




import ru.firstproject.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class testjdbc {

    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();
      //  Connection connection = DBHelper.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

       List<User> usList = new ArrayList<>();
        while (resultSet.next()) {
            usList.add(
                    new User(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    ));
        }

        for (User user : usList) {
            System.out.println(user);
        }

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM users");
        List<UsersDataSet> usdList = new ArrayList<>();
        while (resultSet1.next()) {
            usdList.add(
                    new UsersDataSet(
                            resultSet1.getLong(1),
                            resultSet1.getString(2),
                            resultSet1.getString(3)
                    ));
        }

        for (UsersDataSet user : usdList) {
            System.out.println(user);
        }



        statement.execute("INSERT INTO users (name, login, password) VALUES ('banton', '123', '567')");

        resultSet.close();
        statement.close();

    }

    private static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            String url = "jdbc:mysql://localhost:3306/userbase?user=root&password=root";

            return DriverManager.getConnection(url);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
