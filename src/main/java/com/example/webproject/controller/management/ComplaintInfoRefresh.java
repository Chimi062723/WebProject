package com.example.webproject.controller.management;

import com.example.webproject.dao.ComplaintDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ComplaintInfoRefresh", value = "/ComplaintInfoRefresh")
public class ComplaintInfoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        ComplaintDAO complaintDAO = new ComplaintDAO();
        try {
            request.setAttribute("complaints", complaintDAO.getComplaints(canteen.getCanteenID()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("cantadmin_complaint_management.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}