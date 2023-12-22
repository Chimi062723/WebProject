package com.example.webproject.controller.admin;

import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import com.example.webproject.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "editAccount", value = "/editAccount")
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}