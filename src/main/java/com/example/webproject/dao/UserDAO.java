package com.example.webproject.dao;

import com.example.webproject.dao.Impl.UserDaoImpl;
import com.example.webproject.model.User;
import com.example.webproject.util.JDBCHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDaoImpl {
    private static final String GET_ALL_USERS_SQL = "SELECT * FROM Users";
    private static final String GET_USER_BY_USERNAME_SQL = "SELECT * FROM Users WHERE UserName = ?";
    private static final String GET_USER_BY_USERID_SQL = "SELECT * FROM Users WHERE UserID = ?";
    private static final String ADD_USER_SQL = "INSERT INTO Users (UserName, Password, Role) VALUES (?, ?, ?)";
    private static final String UPDATE_USER_SQL = "UPDATE Users SET Password = ?, Role = ? WHERE UserName = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM Users WHERE UserName = ?";

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("Role"));
                user.setCreateDate(rs.getTimestamp("CreateDate"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
public User getUserByID(int id) {
    User user = null;
    try (Connection connection = JDBCHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERID_SQL)) {
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            user = new User();
            user.setUserID(rs.getInt("UserID"));
            user.setUserName(rs.getString("UserName"));
            user.setPassword(rs.getString("Password"));
            user.setEmail(rs.getString("Email"));
            user.setRole(rs.getString("Role"));
            user.setCreateDate(rs.getTimestamp("CreateDate"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}
    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_SQL)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("Role"));
                user.setCreateDate(rs.getTimestamp("CreateDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }



    @Override
    public void addUser(User user) throws SQLException{
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_SQL);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRole());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException{
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getRole());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.executeUpdate();

    }

    @Override
    public void deleteUser(String username) throws SQLException{
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }

    @Override
    public String judgeRole(String username) throws SQLException{
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_SQL);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getString("Role");
        }
        return null;
    }
}