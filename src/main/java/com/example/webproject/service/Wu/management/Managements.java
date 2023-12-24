package com.example.webproject.service.Wu.management;

import com.example.webproject.model.*;

import java.sql.SQLException;
import java.util.List;

public interface Managements {


    //更新食堂信息
    int updateCanteen(Canteen canteen);

    //新增食堂信息
    int addCanteen(Canteen canteen) throws SQLException;

    //查询食堂信息
    Canteen getCanteen(int userId);

    /**
     * 查询菜品信息
     * @return
     */
    List<Dish> getDishs(int canteenId);


    Dish  getDish(int dishID);


    //新增菜品
    int addDish(Dish dish);

    int editDish(Dish dish);

    int deleteDish(Dish dish);

    Review getReview(int reviewID);

    int   updateReview(Review review);

    //获取 dishID 集合的所有评论信息
    List<Review>  getReviews(int[] dishIDs);


}
