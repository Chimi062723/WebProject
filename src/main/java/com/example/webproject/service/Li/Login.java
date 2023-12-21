package com.example.webproject.service.Li;


import com.example.webproject.dao.UserDAO;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")
public class Login  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        DBhelper db = new DBhelper();
        db.init();
        try {
            if(db.isAccountExists(db.dbconn, username)){
                if(db.verifyPassword(db.dbconn, username, password)){
                    String role=null;
                    UserDAO userDAO = new UserDAO();
                    role= userDAO.judgeRole(username);
                    if(role.equals("sys_admin")){
                        response.sendRedirect("admin_dashboard.jsp");
                    }
                    else if(role.equals("res_admin")){
                        response.sendRedirect("cantadmin_dashboard.jsp");
                    }
                    else  if(role.equals("normal_user")){
                        response.sendRedirect("customer_dashboard.jsp");
                    }
                }else {
                    response.sendRedirect("login.jsp?error=password_error");

                }
            }else{
                response.sendRedirect("login.jsp?error=Account_is_not_Exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    //TODO 做一个过滤器，如果用户没有登录，就不能访问其他页面
}
