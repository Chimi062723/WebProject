package com.example.webproject.controller.management;

import com.example.webproject.dao.ComplaintDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ComplaintHandle", value = "/ComplaintHandle")
public class ComplaintHandle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int complaintId = Integer.parseInt(request.getParameter("complaintID"));
        String action = request.getParameter("action");
        ComplaintDAO complaintDAO = new ComplaintDAO();
        try {
            if (complaintDAO.handleComplaint(complaintId)) {//管理员改变状态为已处理
                if(action.equals("unprocessed")) {
                    response.sendRedirect("ManagemenGetUnComplaints");
                }else if(action.equals("all")) {
                    response.sendRedirect("ComplaintInfoRefresh");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}