package com.example.webproject.controller.user;

import com.example.webproject.dao.PostDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GetPostServlet", value = "/GetPostServlet")
public class GetPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PostDAO postDAO = new PostDAO();
        try {
            session.setAttribute("posts", postDAO.getMostLikesThreePosts());
            response.sendRedirect("customer_dashboard.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}