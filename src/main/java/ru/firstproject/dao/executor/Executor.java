package ru.firstproject.dao.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private  final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public <T> T execQuery(String query, ExecutorHelper<T> helper) {
        T result = null;

    try {
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        result = helper.help(resultSet);
        resultSet.close();
        statement.close();


        connection.commit();

    } catch (SQLException e) {
        e.printStackTrace();
        try {
            connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {

            try {
                connection.setAutoCommit(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    return result;
}

}
