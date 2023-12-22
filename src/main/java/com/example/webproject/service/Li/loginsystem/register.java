package com.example.webproject.service.Li.loginsystem;

import com.example.webproject.dao.UserDAO;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "register", value = "/register")
public class register  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DBhelper db = new DBhelper();
        db.init();
        try {
            if(db.isAccountExists(db.dbconn, username)){
                response.sendRedirect("login.jsp?error=Account_is_Exists");
            }
            else if(db.registerAccount(db.dbconn, username, password,email)){
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
                }else {
                    response.sendRedirect("login.jsp");
                }


            }else{
                response.sendRedirect("register.jsp?error=registration-failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
