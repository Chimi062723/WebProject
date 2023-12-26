package com.example.webproject.controller.res;

import com.example.webproject.model.Canteen;
import com.example.webproject.service.Xu.resadmin.ResAdminImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddDish", value = "/AddDish")
public class AddDish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("template/addDish.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        double promptprice = Double.parseDouble(request.getParameter("promptprice"));
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        int canteenID = canteen.getCanteenID();
        ResAdminImpl resAdmin = new ResAdminImpl();
        resAdmin.addDish(name,price,promptprice,type,canteenID);
        request.getRequestDispatcher("cantadmin_dashboard.jsp").forward(request,response);
    }
}