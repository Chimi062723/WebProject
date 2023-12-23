package com.example.webproject.controller.admin;

//import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteAccount", value = "/DeleteAccount")
public class DeleteAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        AdminActionImpl adminAction = new AdminActionImpl();
//        User user = adminAction.getAccount(id);
//        adminAction.deleteAccount(user);
        HttpSession session = request.getSession();
//        session.setAttribute("users",adminAction.getAllAccount());
        request.getRequestDispatcher("admin_account_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}