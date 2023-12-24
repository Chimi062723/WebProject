package com.example.webproject.dao;

import com.example.webproject.util.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuisineDAO {
    public List<String> getAllCuisine(){
        String sql = "select CuisineType from Dishes group by CuisineType";
        Connection connection = JDBCHelper.getConnection();
        List<String> cuisineTypes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String temp = resultSet.getString("CuisineType");
                cuisineTypes.add(temp);
            }
            return cuisineTypes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
