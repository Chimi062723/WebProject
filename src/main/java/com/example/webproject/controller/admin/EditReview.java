package com.example.webproject.controller.admin;

import com.example.webproject.model.Review;
import com.example.webproject.model.User;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditReview", value = "/EditReview")
public class EditReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewid = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        Review review = adminAction.getReview(reviewid);
        User sender = adminAction.getAccount(review.getUserID());
        request.setAttribute("sender",sender);
        request.setAttribute("review",review);
        request.setAttribute("dish",adminAction.getDishByID(review.getDishID()));
        request.getRequestDispatcher("edit_review.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewID = Integer.parseInt(request.getParameter("reviewID"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String user = request.getParameter("sendername");
        String dish = request.getParameter("dishname");
        String comment = request.getParameter("comment");
        String reply = request.getParameter("reply");
        String createdate = request.getParameter("createDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(createdate);
            Timestamp timestamp = new Timestamp(date.getTime());
            AdminActionImpl adminAction = new AdminActionImpl();
            Review review = new Review(
                    reviewID,
                    adminAction.getAccountByUserName(user).getUserID(),
                    adminAction.getDishIDByName(dish),
                    rating,
                    comment,
                    reply,
                    timestamp,
                    ""
            );
            adminAction.editReview(review);
            HttpSession session = request.getSession();
            session.setAttribute("reviews",adminAction.getAllReview());
            request.getRequestDispatcher("admin_reviews_management.jsp").forward(request,response);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}