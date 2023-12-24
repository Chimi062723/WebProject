package com.example.webproject.model;
import com.example.webproject.dao.CanteenDAO;

import java.sql.SQLException;

public class Dish {
    private int dishID;
    private String name;
    private String type;
    private double price;
    private int canteenID;
    private String image;
    private double promotionPrice;
    private Canteen canteen;

    public Canteen getCanteen() {
        return canteen;
    }

    public void setCanteen(Canteen canteen) {
        this.canteen = canteen;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }
    public Dish() {
    }

    public Dish(int dishID, String name, String type, double price, int canteenID, String image) {
        this.dishID = dishID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.canteenID = canteenID;
        this.image = image;
        CanteenDAO canteenDAO = new CanteenDAO();
        try {
            this.canteen = canteenDAO.getCanteenByID(canteenID);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID= dishID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getCanteenID() {
        return canteenID;
    }

    public void setCanteenID(int canteenID){
        this.canteenID = canteenID;
        CanteenDAO canteenDAO = new CanteenDAO();
        try {
            this.canteen = canteenDAO.getCanteenByID(canteenID);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }
}
