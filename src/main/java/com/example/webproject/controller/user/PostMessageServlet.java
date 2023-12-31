package com.example.webproject.controller.user;

import com.example.webproject.model.Post;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PostMessage", value = "/PostMessageServlet")
public class PostMessageServlet extends HttpServlet {
    private List<Post> postList = new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBhelper db = new DBhelper();
        db.init();
        try {
            postList = db.getPostList(db.dbconn);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        request.setAttribute("postList", postList);
        request.getRequestDispatcher("customer_community.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = (String) session.getAttribute("username");
        String pic = request.getParameter("url");
        DBhelper db = new DBhelper();
        db.init();
        int userid = db.getUserID(db.dbconn, username);
        try {
            if(db.addPost(db.dbconn,userid, title, content,pic)){
                response.sendRedirect("PostMessageServlet");
            }else{
                response.sendRedirect("PostMessageServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
