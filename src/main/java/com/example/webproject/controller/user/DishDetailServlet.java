package com.example.webproject.controller.user;

import com.example.webproject.dao.DishDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.Dish;
import com.example.webproject.model.Review;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DishDetailServlet", value = "/DishDetailServlet")
public class DishDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int dishId= Integer.parseInt(request.getParameter("id"));
        DishDAO dishDAO=new DishDAO();
        String idParam = request.getParameter("id");
        int dishId = 0;
        if (idParam != null && !idParam.isEmpty()) {
            dishId = Integer.parseInt(idParam);
        }
        ReviewDAO reviewDAO=new ReviewDAO();
        if(dishId!=0) {
            Dish dish;
            List<Review> reviews;
            try {
                dish = dishDAO.getDish(dishId);
                reviews = reviewDAO.getReviewsByDishId(dishId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            request.setAttribute("dish", dish);
            request.setAttribute("reviews", reviews);
            request.getRequestDispatcher("dish_detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}