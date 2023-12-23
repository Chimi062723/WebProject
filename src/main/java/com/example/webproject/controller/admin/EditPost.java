package com.example.webproject.controller.admin;

import com.example.webproject.model.Post;
import com.example.webproject.service.xu.admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditPost", value = "/EditPost")
public class EditPost extends HttpServlet {
    //todo:编辑帖子，通过跳转进行显示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        Post post = adminAction.getPost(id);
        int userid = post.getUserID();
        request.setAttribute("post",post);
        request.setAttribute("user",adminAction.getAccount(userid));
        request.getRequestDispatcher("edit_post.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("postID"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = request.getParameter("username");
        String createDate = request.getParameter("createdate");
        AdminActionImpl adminAction = new AdminActionImpl();
        adminAction.editPost(id,title,content,username,createDate);
        HttpSession session = request.getSession();
        session.setAttribute("posts",adminAction.getAllPosts());
        request.getRequestDispatcher("admin_community_management.jsp").forward(request,response);
    }
}