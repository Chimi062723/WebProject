//package com.example.webproject.controller.admin;
//
//import com.example.webproject.service.Xu.Admin.AdminActionImpl;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//
//@WebServlet(name = "UpdateAccountServlet", value = "/UpdateAccountServlet")
//public class UpdateAccountServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String role = request.getParameter("role");
//        AdminActionImpl adminAction = new AdminActionImpl();
//        adminAction.editAccount(username,email,role);
//    }
//}