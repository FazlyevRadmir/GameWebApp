package ru.itis.fazlyev.radmir.dao.impl;

import ru.itis.fazlyev.radmir.model.Profile;

import java.sql.*;
import java.util.HashMap;

import static ru.itis.fazlyev.radmir.util.PostgresConnectionUtil.*;

public class ProfileDaoImpl {

    public HashMap createProfile(String user) throws SQLException {

        HashMap<String, String> artib = new HashMap<>();

        loadDriver(DRIVER);
        Connection connection = getConnection();
        String sql = "select * from users where username :: varchar='" + user + "'";
        String sql2 = "select * from profile where username :: varchar='" + user + "'";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            String username = resultSet.getString(1);
            artib.put("username", username);
            String password = resultSet.getString(2);
            artib.put("password", password);
            String firstName = resultSet.getString(3);
            artib.put("firstName", firstName);
            String secondName = resultSet.getString(4);
            artib.put("secondName", secondName);
            String email = resultSet.getString(5);
            artib.put("email", email);
            String phoneNumber = resultSet.getString(6);
            artib.put("phoneNumber", phoneNumber);
        }

        ResultSet resultSet2 = statement.executeQuery(sql2);
        while (resultSet2.next()) {
            String city = resultSet2.getString(2);
            artib.put("city", city);
            String gender = resultSet2.getString(3);
            artib.put("gender", gender);
        }
        return artib;
    }

    public void updateProfile(Profile profile) {
        loadDriver(DRIVER);
        String sql = "UPDATE users SET first_name ='"+profile.getName()+"', second_name ='"+profile.getSurname()+"', email ='"+profile.getEmail()+"', phone_number ='"+profile.getPhone()+"' WHERE username :: varchar='"+profile.getUsername()+"'";
        String sql2 = "UPDATE profile SET city = '"+profile.getCity()+"', gender = '"+profile.getGender()+"'  WHERE username :: varchar='"+profile.getUsername()+"'";
        String sql3 = "INSERT INTO profile VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql3);
            preparedStatement.setString(1, profile.getUsername());
            preparedStatement.setString(2, profile.getCity());
            preparedStatement.setString(3, profile.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(profile.getCity());
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
