package com.example.webproject.service.Xu.resadmin;

import com.example.webproject.dao.CanteenDAO;
import com.example.webproject.dao.DishDAO;
import com.example.webproject.model.Dish;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class ResAdminImpl implements ResAdmin{
    DishDAO dishDAO;
    void ResAdmin(){
    }

    public List<Dish> getAllDishesByCanteenID(int canteenID) {
        List<Dish> dishes;
        dishDAO = new DishDAO();
        try {
            dishes = dishDAO.getAllDishesByCanteenID(canteenID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dishes;
    }


    public List<Dish> getAllDishesByCanteenIDWithSearch(int canteenID, String text) {
        dishDAO = new DishDAO();
        List<Dish> dishes;
        dishes = dishDAO.getAllDishesByCanteenIDWithSearch(canteenID, text);
        return dishes;
    }

    public void editDishByID(int id, String name, double price, double promptprice, String type,String picture) {
        dishDAO = new DishDAO();
        Dish dish = getDishByID(id);
        dish.setName(name);
        dish.setPrice(price);
        dish.setPromotionPrice(promptprice);
        dish.setType(type);
        dish.setImage(picture);
        try {
            dishDAO.updateDish2(dish);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dish getDishByID(int id) {
        dishDAO = new DishDAO();
        Dish dish = new Dish();
        try {
            dish = dishDAO.getDish(id);
        } catch (SQLException e) {
            Logger.getLogger("获取菜品时出错了"+e);
        }
        return dish;
    }

    public void addDish(String name, double price, double promptprice, String type, int canteenID, String picture) {
        dishDAO = new DishDAO();
        try {
            if(dishDAO.getDishIDByName(name)==0){
                Dish dish = new Dish(
                        name,
                        price,
                        promptprice,
                        type,
                        canteenID
                );
                if(!Objects.equals(picture, "")){
                    dish.setImage(picture);
                }
                dishDAO.addDish2(dish);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDish(int id) {
        dishDAO = new DishDAO();
        try {
            if(dishDAO.getDish(id)!=null){
                dishDAO.deleteDish(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
