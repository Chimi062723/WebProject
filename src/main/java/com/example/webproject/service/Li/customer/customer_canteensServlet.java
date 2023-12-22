package com.example.webproject.service.Li.customer;

import com.example.webproject.model.Canteen;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customer_canteens", value = "/customer_canteens")

public class customer_canteensServlet extends HttpServlet {
     private List<Canteen> canteensList=new ArrayList<>();
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req,res);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        DBhelper db = new DBhelper();
        db.init();
        String canteen_name = req.getParameter("canteenName");
        try{
            if(canteensList==null){
                canteensList= new ArrayList<>();
            }
            canteensList = db.performFuzzySearch(db.dbconn,canteen_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("canteens",canteensList);
        req.getRequestDispatcher("customer_canteen.jsp").forward(req,res);
    }

}
