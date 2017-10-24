package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public User findByUsername(String username) {
        //Write the SQL
        try {
            String sql= "SELECT * FROM users WHERE username = ?";
            //Create a prepared statement using the SQL
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            //Bind the parameters values
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        //Retrieve the ResultSet
        //If there's at least one row, build a user
        //otherwise return null
        return null;
    }

    @Override
    public Long insert(User user) {
        //Write the SQL for the insert
        //Create a prepared statment with the insert, request the generated keys
        //Bind the parameters with their values
        //Execute the query
        //Return the generated key value
        try {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}
