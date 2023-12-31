package com.example.webproject.controller.user;

import com.example.webproject.model.Dish;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customers_dish", value = "/customers_dish")
public class Customers_dishServlet extends HttpServlet {
    List<Dish> dishList = new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuisine = request.getParameter("cuisine");
        String canteenName = request.getParameter("canteenName");
        String ascending = request.getParameter("ascending");
        String descending = request.getParameter("descending");
        DBhelper db = new DBhelper();
        db.init();
        if(cuisine!=null){
            try {
                if(cuisine.equals("all")){
                    dishList = db.getAllDishList(db.dbconn);
                }
                else{
                    dishList = db.getDishList(db.dbconn,cuisine);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(canteenName!=null){
            try {
                if(canteenName.equals("all")){
                    dishList = db.getAllDishList(db.dbconn);
                }
                else{
                    dishList = db.getDishListByCanteen(db.dbconn,canteenName);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(ascending!=null){
            try {
                dishList = db.getDishListByPriceAscending(db.dbconn);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(descending!=null){
            try {
                dishList = db.getDishListByPriceDescending(db.dbconn);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //清空选项
        request.setAttribute("cuisine",null);
        request.setAttribute("canteenName",null);
        request.setAttribute("ascending",null);
        request.setAttribute("descending",null);
        request.setAttribute("dishList", dishList);
        request.setAttribute("dishListSize",dishList.size());
        request.getRequestDispatcher("customer_dish.jsp").forward(request, response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rating = request.getParameter("rating");
        String comment = request.getParameter("comment");

        // 检查是否进行了评分
        if (rating == null || rating.isEmpty()) {
            rating = "未评分";
        }
        if (comment == null || comment.isEmpty()) {
            comment = "该用户未做出评价";
        }

        // 保存评论，返回到当前界面
        response.sendRedirect("dish_detail.jsp");
    }
}
