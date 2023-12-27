package com.example.webproject.dao;

import com.example.webproject.model.Dish;
import com.example.webproject.util.DBhelper;
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
    private static final String GET_DISH_BY_CANTEEN_ID = "SELECT * FROM Dishes WHERE CanteenID =?";

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
    public List<Dish> getAllDishesByCanteenID(int canteenID) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        List<Dish> dishes = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(GET_DISH_BY_CANTEEN_ID);
            ps.setInt(1, canteenID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setPromotionPrice(rs.getDouble("PromotionPrice"));
                dish.setType(rs.getString("CuisineType"));
                dish.setImage(rs.getString("ImageURL"));
                dishes.add(dish);
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        connection.close();
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
                    return dish;
                }else {
                    return null;
                }
            }
        }
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

    public void addDish2(Dish dish) throws SQLException {
        String sql = "INSERT INTO Dishes (Name, CuisineType, Price,PromotionPrice, canteenID, ImageURL) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dish.getName());
            ps.setString(2, dish.getType());
            ps.setDouble(3, dish.getPrice());
            ps.setDouble(4,dish.getPromotionPrice());
            ps.setInt(5, dish.getCanteenID());
            ps.setString(6, dish.getImage());
            ps.executeUpdate();
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
    public void updateDish2(Dish dish) throws SQLException {
        String sql = "UPDATE Dishes SET Name = ?, CuisineType = ?, Price = ?, canteenID = ?, ImageURL = ?, PromotionPrice = ?,ImageURL=? WHERE DishID = ?";
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dish.getName());
            ps.setString(2, dish.getType());
            ps.setDouble(3, dish.getPrice());
            ps.setInt(4, dish.getCanteenID());
            ps.setString(5, dish.getImage());
            ps.setDouble(6, dish.getPromotionPrice());
            ps.setString(7,dish.getImage());
            ps.setInt(8, dish.getDishID());
            ps.executeUpdate();
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
            connection.close();
            return resultSet.getInt("DishID");
        }else{
            connection.close();
            return 0;
        }
    }

    public List<String> getAllCuisines() {
        List<String> cuisines = new ArrayList<>();
        DBhelper db = new DBhelper();
        db.init();
        try (Connection conn = db.dbconn;
             PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT CuisineType FROM Dishes");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                cuisines.add(rs.getString("CuisineType"));
            }
            db.dbconn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuisines;
    }

    public List<Dish> getAllDishesByCanteenIDWithSearch(int canteenID, String text) {
        List<Dish> dishes = new ArrayList<>();
        String sql;
        sql = "select * from Dishes where CanteenID = ? and Name like ?";
        PreparedStatement ps = null;
        try (Connection connection = JDBCHelper.getConnection()){
            ps = connection.prepareStatement(sql);
            ps.setInt(1, canteenID);
            ps.setString(2,'%'+text+'%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setPromotionPrice(rs.getDouble("PromotionPrice"));
                dish.setType(rs.getString("CuisineType"));
                dish.setImage(rs.getString("ImageURL"));
                dishes.add(dish);
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dishes;
    }
}