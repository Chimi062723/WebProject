package com.example.webproject.dao;

import com.example.webproject.model.Dish;
import com.example.webproject.model.Review;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {
    private static final String GET_ALL_DISHES = "SELECT * FROM Dishes";
    private static final String GET_DISH_BY_ID = "SELECT * FROM Dishes WHERE DishID = ?";
    private static final String INSERT_DISH = "INSERT INTO Dishes (Name, CuisineType, Price, canteenID, ImageURL) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_DISH = "UPDATE Dishes SET Name = ?, CuisineType = ?, Price = ?, canteenID = ?, ImageURL = ? WHERE DishID = ?";
    private static final String DELETE_DISH = "DELETE FROM Dishes WHERE DishID = ?";

    public List<Dish> getAllDishes() throws SQLException {
        List<Dish> dishes = new ArrayList<>();
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_ALL_DISHES);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setName(rs.getString("Name"));
                dish.setType(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setPromotionPrice(rs.getDouble("PromotionPrice"));
                dish.setCanteenID(rs.getInt("canteenID"));
                dish.setImage(rs.getString("ImageURL"));
                dishes.add(dish);
            }
        }
        return dishes;
    }

    public Dish getDish(int dishID) throws SQLException {
        Dish dish = new Dish();
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_DISH_BY_ID)) {
            ps.setInt(1, dishID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dish.setDishID(rs.getInt("DishID"));
                    dish.setName(rs.getString("Name"));
                    dish.setType(rs.getString("CuisineType"));
                    dish.setPrice(rs.getDouble("Price"));
                    dish.setCanteenID(rs.getInt("canteenID"));
                    dish.setImage(rs.getString("ImageURL"));
                }
            }
        }
        return dish;
    }

    public boolean addDish(Dish dish) throws SQLException {
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_DISH)) {
            ps.setString(1, dish.getName());
            ps.setString(2, dish.getType());
            ps.setDouble(3, dish.getPrice());
            ps.setInt(4, dish.getCanteenID());
            ps.setString(5, dish.getImage());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        }
    }

    public boolean updateDish(Dish dish) throws SQLException {
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_DISH)) {
            ps.setString(1, dish.getName());
            ps.setString(2, dish.getType());
            ps.setDouble(3, dish.getPrice());
            ps.setInt(4, dish.getCanteenID());
            ps.setString(5, dish.getImage());
            ps.setInt(6, dish.getDishID());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    public boolean deleteDish(int dishID) throws SQLException {
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_DISH)) {
            ps.setInt(1, dishID);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        }
    }

    public int getDishIDByName(String dish) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        String sql = "select * from Dishes where Name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,dish);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt("DishID");
        }
        return 0;
    }
    public static List<Dish> getAllDishList() throws SQLException {
        Connection connection = JDBCHelper.getConnection();

        List<Dish> dishList = new ArrayList<>();
        String sql = "select * from Dishes";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Dish dish = new Dish();
            dish.setDishID(resultSet.getInt("DishID"));
            dish.setName(resultSet.getString("Name"));
            dish.setType(resultSet.getString("CuisineType"));
            dish.setPrice(resultSet.getDouble("Price"));
            dish.setCanteenID(resultSet.getInt("canteenID"));
            dish.setImage(resultSet.getString("ImageURL"));
            dishList.add(dish);
        }
        return dishList;
    }
}