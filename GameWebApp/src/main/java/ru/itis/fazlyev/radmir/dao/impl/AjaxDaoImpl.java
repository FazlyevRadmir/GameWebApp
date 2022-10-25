package ru.itis.fazlyev.radmir.dao.impl;

import ru.itis.fazlyev.radmir.util.PostgresConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjaxDaoImpl {

    public boolean checkingForTheExistenceOfUser(String username) throws SQLException {
        boolean result = false;
        PostgresConnectionUtil.loadDriver(PostgresConnectionUtil.DRIVER);
        Connection connection = PostgresConnectionUtil.getConnection();
        String sql = "SELECT * FROM users WHERE username=?;";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}
