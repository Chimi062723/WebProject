package com.example.webproject.controller.management;

import com.example.webproject.dao.ComplaintDAO;
import com.example.webproject.dao.ReviewDAO;
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

@WebServlet(name = "ManagemenGetUnReviews", value = "/ManagemenGetUnReviews")
public class ManagemenGetUnReviews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ReviewDAO reviewDAO = new ReviewDAO();
        Canteen canteen= (Canteen) session.getAttribute("canteen");
        try {
            //获取未回复的评论
            session.setAttribute("unreviews", reviewDAO.getUnReplyReviews(canteen));
        }catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("cantadmin_unreply_reviews.jsp").forward(request, response);
    }
}