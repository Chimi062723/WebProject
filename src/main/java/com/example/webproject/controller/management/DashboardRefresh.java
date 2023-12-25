package com.example.webproject.controller.management;

import com.example.webproject.dao.ComplaintDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DashboardRefresh", value = "/DashboardRefresh")
public class DashboardRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ReviewDAO reviewDAO = new ReviewDAO();
        ComplaintDAO complaintDAO = new ComplaintDAO();
        Canteen canteen= (Canteen) session.getAttribute("canteen");
        try {
            //获取未回复的评论
            session.setAttribute("unreviews", reviewDAO.getUnReplyReviews(canteen));
            //获取未处理的投诉
            session.setAttribute("uncomplaints", complaintDAO.getUnprocessedComplaints(canteen.getCanteenID()));
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("cantadmin_dashboard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}