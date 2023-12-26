package com.example.webproject.controller.res;

import com.example.webproject.service.Xu.resadmin.ResAdminImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteDish", value = "/DeleteDish")
public class DeleteDish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ResAdminImpl resAdmin = new ResAdminImpl();
        resAdmin.deleteDish(id);
        request.getRequestDispatcher("cantadmin_dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}