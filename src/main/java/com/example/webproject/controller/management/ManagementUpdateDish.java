package com.example.webproject.controller.management;

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

@WebServlet(name = "ManagementUpdateDish", value = "/ManagementUpdateDish")
public class ManagementUpdateDish extends HttpServlet {
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
        int userid = db.getUserID(db.dbconn, username); // 当前登录用户的id
        ManagementsImpl managements = new ManagementsImpl();
        String dishID = request.getParameter("dishID"); // 菜品id
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String image = request.getParameter("image");
        String promotionPrice = request.getParameter("promotionPrice");
        Dish dish = managements.getDish(Integer.parseInt(dishID));
        dish.setImage(image);
        dish.setName(name);
        dish.setPrice(Double.parseDouble(price));
        dish.setType(type);
        dish.setPromotionPrice(Double.parseDouble(promotionPrice));
        int a = managements.editDish(dish);
        Boolean msg = false;
        if (a >= 1) {
            msg = true;
        }
        //成功后 跳转到菜品列表信息
        request.getRequestDispatcher("ManagementGetDishs?msg=" + msg).forward(request, response);
    }
}