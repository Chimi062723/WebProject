package com.example.webproject.service.Li.loginsystem;


import com.example.webproject.dao.*;
import com.example.webproject.model.Dish;
import com.example.webproject.model.Post;
import com.example.webproject.model.User;
import com.example.webproject.util.DBhelper;
import com.example.webproject.model.Canteen;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
                    CanteenDAO canteenDAO = new CanteenDAO();
                    DishDAO dishDAO = new DishDAO();//todo:DishDAO
                    PostDAO postDAO = new PostDAO();//todo:PostDAO完善
                    ReviewDAO reviewDAO = new ReviewDAO(); //todo:ReviewDAO完善
                    role= userDAO.judgeRole(username);
                    if(role.equals("sys_admin")){
                        List<User> users = userDAO.getAllUsers();
                        List<Canteen> canteens = canteenDAO.getAllCanteens();
                        session.setAttribute("users",users);
                        session.setAttribute("canteens",canteens);
                        request.getRequestDispatcher("admin_dashboard.jsp").forward(request,response);
                    }
                    else if(role.equals("res_admin")){
                        response.sendRedirect("cantadmin_dashboard.jsp");
                    }
                    else  if(role.equals("normal_user")){
                        Dish dish1 = dishDAO.getDish(1);
                        Dish dish2 = dishDAO.getDish(2);
                        Dish dish3 = dishDAO.getDish(3);
                        Dish dish4 = dishDAO.getDish(4);
                        Dish dish5 = dishDAO.getDish(5);
                        Dish dish6 = dishDAO.getDish(6);
                        session.setAttribute("dish1",dish1);
                        session.setAttribute("dish2",dish2);
                        session.setAttribute("dish3",dish3);
                        session.setAttribute("dish4",dish4);
                        session.setAttribute("dish5",dish5);
                        session.setAttribute("dish6",dish6);
                        //以上传入菜品上新菜品
                        Post post1 = postDAO.getPost(1);
                        Post post2 = postDAO.getPost(2);
                        Post post3 = postDAO.getPost(6);

                        session.setAttribute("post1",post1);
                        session.setAttribute("post2",post2);
                        session.setAttribute("post3",post3);
                        request.getRequestDispatcher("customer_dashboard.jsp").forward(request,response);
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
