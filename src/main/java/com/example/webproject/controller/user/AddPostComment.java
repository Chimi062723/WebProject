package com.example.webproject.controller.user;

import com.example.webproject.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.webproject.dao.PostDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddPostComment", value = "/AddPostComment")
public class AddPostComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postID = Integer.parseInt(request.getParameter("postID"));
        String content = request.getParameter("commentContent");
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        String username = (String) session.getAttribute("username");
        int userID = userDAO.getUserByUsername(username).getUserID();
        PostDAO postDAO = new PostDAO();
        try {
            if(postDAO.addPostComment(userID,content,postID)){
                session.setAttribute("posts", postDAO.getMostLikesThreePosts());
                response.sendRedirect("customer_dashboard.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}