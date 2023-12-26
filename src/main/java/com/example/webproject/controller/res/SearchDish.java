package com.example.webproject.controller.res;

import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.service.Xu.resadmin.ResAdminImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchDish", value = "/SearchDish")
public class SearchDish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResAdminImpl resAdmin = new ResAdminImpl();
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        int canteenID = canteen.getCanteenID();
        String text = request.getParameter("text");
        List<Dish> dishes;
        if(text!=null){
            dishes= resAdmin.getAllDishesByCanteenIDWithSearch(canteenID,text);
        }else {
            dishes = resAdmin.getAllDishesByCanteenID(canteenID);
        }
        request.setAttribute("dishes",dishes);
        request.getRequestDispatcher("cantadmin_dish_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}