package com.example.webproject.service.Li;

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
        ServletContext context= request.getServletContext();
        context.setAttribute("postList", postList);
        if(postList==null){
            postList= new ArrayList<>();
            context.setAttribute("postList", postList);
        }
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("customer_community.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = (String) session.getAttribute("username");
        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();


        DBhelper db = new DBhelper();
        db.init();
        int userid = db.getUserID(db.dbconn, username);
        try {
            if(db.addPost(db.dbconn,userid, title, content)){
                response.sendRedirect("customer_community.jsp?error=Add-success");
            }else{
                response.sendRedirect("customer_community.jsp?error=Add-failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
