package com.example.webproject.controller.res;

import com.example.webproject.model.Dish;
import com.example.webproject.service.Xu.resadmin.ResAdminImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditDish", value = "/EditDish")
public class EditDish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ResAdminImpl resAdmin = new ResAdminImpl();
        Dish dish = resAdmin.getDishByID(id);
        request.setAttribute("dish",dish);
        request.getRequestDispatcher("template/editdish.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishID = Integer.parseInt(request.getParameter("dishID"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double promptprice = Double.parseDouble(request.getParameter("promptprice"));
        String type = request.getParameter("type");
        ResAdminImpl resAdmin = new ResAdminImpl();
        resAdmin.editDishByID(dishID,name,price,promptprice,type);
        response.sendRedirect("cantadmin_dashboard.jsp");
    }
}