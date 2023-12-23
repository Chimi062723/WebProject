package com.example.webproject.dao.Impl;


import com.example.webproject.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoImpl{
    List<User> getAllUsers();
    User getUserByUsername(String username);
    void addUser(User user) throws SQLException;

    void updateUser(String username, String email, String role) throws SQLException;

    void deleteUser(String username) throws SQLException;

    String judgeRole(String username) throws SQLException;
}
