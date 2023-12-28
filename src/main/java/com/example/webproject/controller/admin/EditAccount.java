package com.example.webproject.controller.admin;

import com.example.webproject.model.Canteen;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import com.example.webproject.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "EditAccount", value = "/EditAccount")
public class EditAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("id"));
        AdminActionImpl adminAction = new AdminActionImpl();
        User user = adminAction.getAccount(userID);
        request.setAttribute("user",user);
        request.getRequestDispatcher("edit_account.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        AdminActionImpl adminAction = new AdminActionImpl();
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(request.getParameter("userID"));
        if(request.getParameter("res")!=null && !Objects.equals(request.getParameter("res"), "")){
            int canteenID = Integer.parseInt(request.getParameter("res"));
            Canteen canteen = adminAction.getCanteen(canteenID);
            if(canteen!=null){
                if(canteen.getManagerID()==1){
                    canteen.setManagerID(userID);
                    adminAction.editCanteen(canteen);
                }else {
                    role="normal_user";
                }
            }else {
                role="normal_user";
            }
        }else {
            role="normal_user";
        }
        adminAction.editAccount(username,email,role,userID);
        session.setAttribute("users",adminAction.getAllAccount());
        request.getRequestDispatcher("admin_account_management.jsp").forward(request,response);
    }
}