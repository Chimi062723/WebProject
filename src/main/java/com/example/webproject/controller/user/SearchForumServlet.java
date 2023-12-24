package com.example.webproject.controller.user;

import com.example.webproject.dao.UserDAO;
import com.example.webproject.model.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.webproject.dao.PostDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchForumServlet", value = "/SearchForumServlet")
public class SearchForumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchQuery = request.getParameter("searchQuery");
        PostDAO postDAO = new PostDAO();
        List<Post> posts = null;
        try {
            posts = postDAO.getPostsByTitle(searchQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!posts.isEmpty()){
            request.setAttribute("postList", posts);
            request.getRequestDispatcher("customer_community.jsp").forward(request, response);
        }else{
            try{
                UserDAO userDAO=new UserDAO();
                if(userDAO.getUserByUsername(searchQuery)!=null){
                    int userID=userDAO.getUserByUsername(searchQuery).getUserID();
                    posts=postDAO.getPostsByUserID(userID);
                    if (!posts.isEmpty()){
                        request.setAttribute("postList", posts);
                        request.getRequestDispatcher("customer_community.jsp").forward(request, response);
                    }else{
                        request.setAttribute("message","No posts found");
                        request.getRequestDispatcher("customer_community.jsp").forward(request, response);
                    }
                }else {
                    request.setAttribute("message","No user found");
                    request.getRequestDispatcher("customer_community.jsp").forward(request, response);
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}