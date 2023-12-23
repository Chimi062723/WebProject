package com.example.webproject.service.Li.loginsystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class Logout  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null) {
            session.invalidate();//销毁session,标记用户为离线状态
        }

        response.sendRedirect("login.jsp");
        // 从会话中移除用户昵称
        session.removeAttribute("username");

    }
}
