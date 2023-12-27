package com.example.webproject.service.Xu.resadmin;

import com.example.webproject.model.Dish;

import java.util.List;

public interface ResAdmin {
    public List<Dish> getAllDishesByCanteenID(int canteenID);

    public List<Dish> getAllDishesByCanteenIDWithSearch(int canteenID, String text);
    public void editDishByID(int id, String name, double price, double promptprice, String type,String picture);
}
