package ru.itis.fazlyev.radmir.dao.impl;

import ru.itis.fazlyev.radmir.dao.Dao;
import ru.itis.fazlyev.radmir.dto.UserDto;
import ru.itis.fazlyev.radmir.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static ru.itis.fazlyev.radmir.util.PostgresConnectionUtil.*;

public class UserDaoImpl implements Dao {

    @Override
    public String save(User user) {
        loadDriver(DRIVER);
        String result = "Data entered successfully";
        String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSecondName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Try again";
        }
        return result;
    }

    @Override
    public boolean authentication(UserDto userDto) {
        loadDriver(DRIVER);
        String sql = "SELECT * FROM users WHERE username=? AND password=?;";
        boolean status = false;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, userDto.getUsername());
            preparedStatement.setString(2, userDto.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
