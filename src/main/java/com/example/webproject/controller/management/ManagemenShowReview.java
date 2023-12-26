package com.example.webproject.controller.management;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.model.Review;
import com.example.webproject.service.Wu.management.ManagementsImpl;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagemenShowReview", value = "/ManagemenShowReview")
public class ManagemenShowReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        DBhelper db = new DBhelper();
        db.init();
        ManagementsImpl managements=new ManagementsImpl();
        String reviewID = request.getParameter("reviewID"); // 评论id
        Review review = managements.getReview(Integer.parseInt(reviewID));
        request.setAttribute("review", review);
        request.getRequestDispatcher("review_detail.jsp").forward(request, response);
    }
}