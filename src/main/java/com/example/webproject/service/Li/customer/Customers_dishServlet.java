package com.example.webproject.service.Li.customer;

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
        DBhelper db = new DBhelper();
        db.init();

        try {
            if(cuisine.equals("all")){
                dishList = db.getAllDishList(db.dbconn);
            }
            else{
                dishList = db.getDishList(db.dbconn,cuisine);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        request.setAttribute("dishList", dishList);
        request.getRequestDispatcher("customer_dish.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}