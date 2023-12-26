package com.example.webproject.controller.management;

import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ReviewInfoRefresh", value = "/ReviewInfoRefresh")
public class ReviewInfoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        ReviewDAO reviewDAO = new ReviewDAO();
        try {
            request.setAttribute("reviews", reviewDAO.getAllReviews(canteen));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("cantadmin_reviews_management.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}