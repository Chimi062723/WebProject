package com.example.webproject.controller.management;

import com.example.webproject.model.Canteen;
import com.example.webproject.service.Wu.management.ManagementsImpl;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ManagementGetCanteen", value = "/ManagementGetCanteen")
public class ManagementGetCanteen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        DBhelper db = new DBhelper();
        db.init();
        int userid = db.getUserID(db.dbconn, username); // 当前用户的id
        ManagementsImpl managements = new ManagementsImpl();
        Canteen canteen = managements.getCanteen(userid);
        //如果餐厅信息没有的话，需要生成一个
        if (canteen == null){
            canteen = new Canteen();
            canteen.setOpenTime("");
            canteen.setLocation("");
            canteen.setName("");
            canteen.setManagerID(userid);
            try {
                managements.addCanteen(canteen);
                canteen = managements.getCanteen(userid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("canteen", canteen);
        request.getRequestDispatcher("cantadmin_canteen_management.jsp").forward(request, response);
    }
}