package com.example.webproject.controller.admin;

import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeletePost", value = "/DeletePost")
public class DeletePost extends HttpServlet {
    //todo:删除帖子,页面内删除
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        adminAction.deletePost(id);
        HttpSession session = request.getSession();
        session.setAttribute("posts",adminAction.getAllPosts());
        request.getRequestDispatcher("admin_community_management.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}