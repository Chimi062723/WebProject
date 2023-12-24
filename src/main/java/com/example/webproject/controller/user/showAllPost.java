package com.example.webproject.controller.user;

import com.example.webproject.model.Post;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "showAllPost", value = "/showAllPost")
public class showAllPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        AdminActionImpl adminAction = new AdminActionImpl();
        List<Post> postList = adminAction.getAllPostsByID(userID);
        request.setAttribute("username",username);
        if(postList.isEmpty()){
            request.setAttribute("empty",true);
        }
        request.setAttribute("posts",postList);
        request.getRequestDispatcher("MyPosts.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}