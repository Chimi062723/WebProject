package com.example.webproject.controller.admin;

import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetCanteens", value = "/GetCanteens")
public class GetCanteens extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminActionImpl adminAction = new AdminActionImpl();
        session.setAttribute("canteens",adminAction.getAllCanteen());
        request.getRequestDispatcher("admin_canteen_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}