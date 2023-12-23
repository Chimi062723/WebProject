package com.example.webproject.controller.admin;

import com.example.webproject.model.Canteen;
import com.example.webproject.model.User;
import com.example.webproject.service.xu.admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditCanteen", value = "/EditCanteen")
public class EditCanteen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Canteen canteen;
        int canteenID = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        canteen = adminAction.getCanteen(canteenID);
        User manager = adminAction.getAccount(canteen.getManagerID());
        request.setAttribute("canteen",canteen);
        request.setAttribute("manager",manager);
        request.getRequestDispatcher("edit_canteen.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("canteenID"));
        String canteenName = request.getParameter("canteenName");
        String location = request.getParameter("location");
        String opentime = request.getParameter("opentime");
        String managerName = request.getParameter("managerName");
        String notice = request.getParameter("notice");
        AdminActionImpl adminAction = new AdminActionImpl();
        Canteen newcanteen = adminAction.canteenEncapsulation(id,canteenName,location,opentime,managerName,notice);
        adminAction.editCanteen(newcanteen);
        HttpSession session = request.getSession();
        session.setAttribute("canteens",adminAction.getAllCanteen());
        request.getRequestDispatcher("admin_canteen_management.jsp").forward(request,response);
    }
}