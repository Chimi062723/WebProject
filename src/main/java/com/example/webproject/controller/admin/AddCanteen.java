package com.example.webproject.controller.admin;

import com.example.webproject.model.Canteen;
//import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCanteen", value = "/AddCanteen")
public class AddCanteen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String time = request.getParameter("time");
        HttpSession session = request.getSession();
        int managerID = Integer.parseInt(request.getParameter("managerID"));
//        AdminActionImpl adminAction = new AdminActionImpl();
//        String managername = adminAction.getAccount(managerID).getUserName();
//        Canteen canteen = adminAction.canteenEncapsulation(-1,name,address,time,managername,"none");
//        adminAction.addCanteen(canteen);
//        List<Canteen> canteens = adminAction.getAllCanteen();
//        session.setAttribute("canteens",canteens);
        request.getRequestDispatcher("admin_canteen_management.jsp").forward(request,response);
    }
}