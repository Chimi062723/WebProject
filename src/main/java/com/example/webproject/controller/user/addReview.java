package com.example.webproject.controller.user;

import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addReview", value = "/addReview")
public class addReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishID = Integer.parseInt(request.getParameter("dishID"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String picture = request.getParameter("picture");
        String comment = request.getParameter("comment");
        HttpSession session = request.getSession();
        AdminActionImpl adminAction = new AdminActionImpl();
        int userID = adminAction.getAccountByUserName((String)session.getAttribute("username")).getUserID();
        adminAction.addReview(dishID,userID,rating,comment,picture);
        request.getRequestDispatcher("customer_dashboard.jsp").forward(request,response);
    }
}