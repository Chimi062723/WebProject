package com.example.webproject.controller.user;

import com.example.webproject.dao.PostDAO;
import com.example.webproject.model.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Post> postList = new ArrayList<>();
        PostDAO postDAO = new PostDAO();
        try {
            if ("time".equals(action)) {
                // 按时间排序的操作
                postList = postDAO.getPostOrderByTime();
            } else if ("popularity".equals(action)) {
                // 按热度排序的操作
                postList = postDAO.getPostOrderByLike();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("customer_community.jsp").forward(request, response);
    }
}