package com.example.webproject.controller.admin;

import com.example.webproject.model.Review;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditReview", value = "/EditReview")
public class EditReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Review review;
        int reviewid = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        review = adminAction.getReview(reviewid);
        request.setAttribute("review",review);
        request.getRequestDispatcher("edit_review.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}