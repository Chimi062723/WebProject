package com.example.webproject.controller.management;

import com.example.webproject.dao.ReviewDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReplyReview", value = "/ReplyReview")
public class ReplyReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("id"));
        String action=request.getParameter("action");
        String reply = request.getParameter("reply"+reviewId);
        if(reply.isEmpty()){//判断评论是否为空
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("<script language='javascript'>" +
                    "alert('回复不能为空');" +
                    "window.location.href='cantadmin_dashboard.jsp';</script>')");
        }
        ReviewDAO reviewDAO = new ReviewDAO();
        try {
            if (reviewDAO.addReply(reviewId, reply)) {//管理员添加评论
                if(action.equals("unreply")){
                    response.sendRedirect("ManagemenGetUnReviews");
                }else if(action.equals("all")){
                    response.sendRedirect("ReviewInfoRefresh");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}