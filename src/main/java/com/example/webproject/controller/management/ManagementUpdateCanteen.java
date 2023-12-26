package com.example.webproject.controller.management;

import com.example.webproject.model.Canteen;
import com.example.webproject.service.Xu.Admin.AdminActionImpl;
import com.example.webproject.service.Wu.management.ManagementsImpl;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "managementUpdateCanteen", value = "/managementUpdateCanteen")
public class ManagementUpdateCanteen extends HttpServlet {
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
        String canteenName = request.getParameter("canteenName");
        String location = request.getParameter("location");
        String opentime = request.getParameter("opentime");
        String notice = request.getParameter("notice");
        Canteen canteen = new Canteen();
        canteen.setLocation(location);
        canteen.setManagerID(userid);
        canteen.setOpenTime(opentime);
        canteen.setName(canteenName);
        canteen.setNotice(notice);
        managements.updateCanteen(canteen);
        request.getRequestDispatcher("cantadmin_canteen_management.jsp").forward(request, response);
    }
}