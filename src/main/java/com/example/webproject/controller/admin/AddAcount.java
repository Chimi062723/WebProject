package com.example.webproject.controller.admin;

import com.example.webproject.model.Canteen;
import com.example.webproject.model.User;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AddAcount", value = "/AddAcount")
public class AddAcount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        AdminActionImpl adminAction = new AdminActionImpl();
        if(Objects.equals(role, "res_admin")){
            int canteenID = Integer.parseInt(request.getParameter("canteenID"));
            if(adminAction.getAccountByUserName(name) == null){
                User user = new User(name,password,email,role);
                Canteen newCanteen = adminAction.getCanteen(canteenID);
                if(newCanteen!=null){
                    User user1 = newCanteen.getManager();
                    newCanteen.setManagerID(user.getUserID());
                    if (user1.getUserID()!=1){
                        adminAction.editAccount(user1.getUserName(),user1.getEmail(),"normal_user");
                    }
                    adminAction.editCanteen(newCanteen);
                }else{
                    user.setRole("normal_user");
                }
                adminAction.addAccount(user);
            }
        }else {
            adminAction.addAccount(new User(name,password,email,role));
        }
        HttpSession session = request.getSession();
        session.setAttribute("users",adminAction.getAllAccount());
        request.getRequestDispatcher("admin_account_management.jsp").forward(request,response);
    }
}