package com.example.webproject.service.Li.loginsystem;

import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "forgotPassword", value = "/forgotPassword")
public class forgotPasswordAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");

        DBhelper db = new DBhelper();
        db.init();
        try {
            if(db.isAccountExists(db.dbconn, username)){
                if(db.verifyEmail(db.dbconn, username, email)){
                     db.changePassword(db.dbconn, username, newPassword);
                    response.sendRedirect("login.jsp");
                }else {
                    response.sendRedirect("forgot_password.jsp?error=email_error");

                }
            }else{
                response.sendRedirect("forgot_password.jsp?error=Account_is_not_Exists");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
