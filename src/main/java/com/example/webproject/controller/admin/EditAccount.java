package com.example.webproject.controller.admin;

import com.example.webproject.service.xu.admin.AdminActionImpl;
import com.example.webproject.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditAccount", value = "/EditAccount")
public class EditAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        User user = adminAction.getAccount(userID);
        request.setAttribute("user",user);
        request.getRequestDispatcher("edit_account.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        AdminActionImpl adminAction = new AdminActionImpl();
        adminAction.editAccount(username,email,role);
        HttpSession session= request.getSession();
        session.setAttribute("users",adminAction.getAllAccount());
        request.getRequestDispatcher("admin_account_management.jsp").forward(request,response);
    }
}