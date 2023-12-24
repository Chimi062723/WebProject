package com.example.webproject.controller.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import java.io.IOException;

@WebServlet(name = "getAllDishes", value = "/getAllDishes")
public class getAllDishes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminActionImpl adminAction = new AdminActionImpl();
        request.setAttribute("dishList",adminAction.getAllDish());
        request.getRequestDispatcher("customer_dish.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}