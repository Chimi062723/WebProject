package com.example.webproject.controller.admin;

import com.example.webproject.model.Canteen;
import com.example.webproject.service.xu.admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCanteen", value = "/DeleteCanteen")
public class DeleteCanteen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        Canteen canteen = adminAction.getCanteen(id);
        adminAction.deleteCanteen(canteen);
        HttpSession session = request.getSession();
        session.setAttribute("canteens",adminAction.getAllCanteen());
        request.getRequestDispatcher("admin_canteen_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}