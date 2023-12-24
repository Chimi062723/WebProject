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
public class ManagemenDeleteDish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBhelper db = new DBhelper();
        db.init();
        ManagementsImpl managements=new ManagementsImpl();
        String dishID = request.getParameter("dishID");//菜品id
        Dish dish=managements.getDish(Integer.parseInt(dishID));
        int a=managements.deleteDish(dish);
        Boolean msg=false;
        if (a>=1) {
            msg = true;
        }
        //成功后 跳转到菜品列表信息
        request.getRequestDispatcher("ManagementGetDishs?msg="+msg).forward(request,response);
    }
}