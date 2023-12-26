package com.example.webproject.controller.res;

import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.service.Xu.resadmin.ResAdminImpl;
import com.mysql.cj.CancelQueryTask;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DishMaintenance", value = "/DishMaintenance")
public class DishMaintenance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResAdminImpl resAdmin = new ResAdminImpl();
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        int canteenID = canteen.getCanteenID();
        List<Dish> dishes= resAdmin.getAllDishesByCanteenID(canteenID);
        request.setAttribute("dishes",dishes);
        request.getRequestDispatcher("cantadmin_dish_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}