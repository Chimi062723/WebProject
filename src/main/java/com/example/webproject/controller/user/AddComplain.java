package com.example.webproject.controller.user;

import com.example.webproject.dao.ComplaintDAO;
import com.example.webproject.dao.UserDAO;
import com.example.webproject.model.Complaint;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ComplaintServlet", value = "/ComplaintServlet")
public class AddComplain extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        String username = (String) session.getAttribute("username");
        int userID = userDAO.getUserByUsername(username).getUserID();
        ComplaintDAO complaintDAO=new ComplaintDAO();
        try {
            List<Complaint> complaints=complaintDAO.getUserComplaints(userID);
            request.setAttribute("complaints",complaints);
            request.getRequestDispatcher("my_complaint.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        String username = (String) session.getAttribute("username");
        int userID = userDAO.getUserByUsername(username).getUserID();

        int canteenID= Integer.parseInt(request.getParameter("canteenID"));
        String content = request.getParameter("content");
        ComplaintDAO complaintDAO=new ComplaintDAO();
        try {
            if(complaintDAO.addComplaint(userID,canteenID,content)){
                response.sendRedirect("ComplaintServlet");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
