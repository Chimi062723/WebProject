//package com.example.webproject.controller.admin;
//
//import com.example.webproject.model.Canteen;
//import com.example.webproject.service.Xu.Admin.AdminActionImpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(name = "UpdateCanteen", value = "/UpdateCanteen")
//public class UpdateCanteen extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("canteenID"));
//        String canteenName = request.getParameter("canteenName");
//        String location = request.getParameter("location");
//        String opentime = request.getParameter("opentime");
//        String managerName = request.getParameter("managerName");
//        String notice = request.getParameter("notice");
//        AdminActionImpl adminAction = new AdminActionImpl();
//        Canteen newcanteen = adminAction.canteenEncapsulation(id,canteenName,location,opentime,managerName,notice);
//        adminAction.editCanteen(newcanteen);
//        request.getRequestDispatcher("edit_canteen.jsp").forward(request,response);
//    }
//}