package com.example.webproject.dao;

import com.example.webproject.model.Dish;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DishDAO {
    private static final String GET_DISH_BY_ID = "SELECT * FROM Dishes WHERE DishID =?";
    //todo:DishDao
    public Dish getDish(int dishID){
        Dish dish = new Dish();
        try{
            Connection conn = JDBCHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_DISH_BY_ID);
            ps.setInt(1, dishID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                dish.setDishID(rs.getInt("DishID"));
                dish.setName(rs.getString("Name"));
                dish.settype(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setCanteenID(rs.getInt("canteenID"));
                dish.setImage(rs.getString("ImageURL"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return dish;
    }
}
