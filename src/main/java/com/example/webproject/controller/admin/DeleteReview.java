package com.example.webproject.controller.admin;

import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteReview", value = "/DeleteReview")
public class DeleteReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewID = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        adminAction.deleteReview(reviewID);
        HttpSession session = request.getSession();
        session.setAttribute("reviews",adminAction.getAllReview());
        request.getRequestDispatcher("admin_reviews_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}