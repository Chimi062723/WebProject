package com.example.webproject.controller.management;

import com.example.webproject.dao.CanteenDAO;
import com.example.webproject.dao.ComplaintDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CanteenInfoRefresh", value = "/CanteenInfoRefresh")
public class CanteenInfoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userID=(Integer) session.getAttribute("userID");
        CanteenDAO canteenDAO = new CanteenDAO();
        Canteen canteen = null;
        try {
            canteen = canteenDAO.getCanteenByManagerID(userID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("canteen", canteen);

        response.sendRedirect("cantadmin_canteen_management.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}