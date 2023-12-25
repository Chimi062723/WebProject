package com.example.webproject.controller.management;

import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.service.Wu.management.ManagementsImpl;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagementGetDishs", value = "/ManagementGetDishs")
public class ManagementGetDishs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        DBhelper db = new DBhelper();
        db.init();
        int userid = db.getUserID(db.dbconn, username); // 当前用户的id
        ManagementsImpl managements=new ManagementsImpl();
        List<Dish> dishs=managements.getDishs(userid);
        request.setAttribute("dishes",dishs);
        request.getRequestDispatcher("cantadmin_dish_management.jsp").forward(request,response);
    }
}