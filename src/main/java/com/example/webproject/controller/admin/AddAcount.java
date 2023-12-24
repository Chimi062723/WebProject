package com.example.webproject.controller.admin;

import com.example.webproject.model.User;
//import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddAcount", value = "/AddAcount")
public class AddAcount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
//        AdminActionImpl adminAction = new AdminActionImpl();
        User user = new User(name,"123456",email,role);
//        adminAction.addAccount(user);
        HttpSession session = request.getSession();
//        session.setAttribute("users",adminAction.getAllAccount());
        request.getRequestDispatcher("admin_account_management.jsp").forward(request,response);
    }
}