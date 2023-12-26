package com.example.webproject.controller.management;

import com.example.webproject.dao.ComplaintDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ManagemenGetUnComplaints", value = "/ManagemenGetUnComplaints")
public class ManagemenGetUnComplaints extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ComplaintDAO complaintDAO = new ComplaintDAO();
        Canteen canteen= (Canteen) session.getAttribute("canteen");
        try {
            //获取未处理的投诉
            session.setAttribute("uncomplaints", complaintDAO.getUnprocessedComplaints(canteen.getCanteenID()));
        }catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("cantadmin_unprocessed_complaints.jsp").forward(request, response);
    }
}