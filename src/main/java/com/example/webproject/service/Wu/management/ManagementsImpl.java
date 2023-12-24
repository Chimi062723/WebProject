package com.example.webproject.service.Wu.management;

import com.example.webproject.dao.CanteenDAO;
import com.example.webproject.dao.DishDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.dao.UserDAO;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.model.Review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagementsImpl implements Managements {

    UserDAO userDAO;

    CanteenDAO canteenDAO;


    DishDAO dishDAO;

    ReviewDAO reviewDAO;


    public ManagementsImpl(){
        this.userDAO = new UserDAO();
        this.canteenDAO = new CanteenDAO();
        this.dishDAO = new DishDAO();
        this.reviewDAO=new ReviewDAO();
    }


    @Override
    public int updateCanteen(Canteen canteen) {
        try {
            //先查詢食堂管理员 有没有创建对应的食堂信息 ，再进行 更新还是新增
            Canteen canteen0=getCanteen(canteen.getManagerID());
            if (canteen0==null){
                canteenDAO.addCanteen(canteen);
                return 1;
            }else{
                canteenDAO.updateCanteen(canteen);
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  0;
    }

    @Override
    public int addCanteen(Canteen canteen) throws SQLException {
        try {
            canteenDAO.addCanteen(canteen);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Canteen getCanteen(int userId) {
        try {
            return  canteenDAO.getCanteenByManagerID(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dish> getDishs(int canteenId) {
        List<Dish> dishes=new ArrayList<>();
        try {
            return dishDAO.getAllDishesByCanteenID(canteenId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dishes;
    }

    @Override
    public int addDish(Dish dish) {
        try {
            dishDAO.addDish(dish);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int editDish(Dish dish) {
        try {
            dishDAO.updateDish(dish);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteDish(Dish dish) {
        try {
            dishDAO.deleteDish(dish.getDishID());
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public Dish getDish(int dishID) {
        try {
            return dishDAO.getDish(dishID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateReview(Review review) {
        try {
            reviewDAO.updateReview(review);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Review> getReviews(int[] dishIDs) {
        try {
            return reviewDAO.getReviewsBydishIDs(dishIDs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Review getReview(int reviewID) {
        try {
            return reviewDAO.getReviewsByReviewID(reviewID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
