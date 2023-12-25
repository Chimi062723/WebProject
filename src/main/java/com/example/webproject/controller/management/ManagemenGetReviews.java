package com.example.webproject.controller.management;

import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.model.Review;
import com.example.webproject.service.Wu.management.ManagementsImpl;
import com.example.webproject.util.DBhelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagemenReviews", value = "/ManagemenReviews")
public class ManagemenGetReviews extends HttpServlet {
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
        int userid = db.getUserID(db.dbconn, username); // 当前食堂管理员id
        //
        ManagementsImpl managements = new ManagementsImpl();
        // 获取食堂信息的的id
        Canteen canteen = managements.getCanteen(userid);
        // 通过食堂信息id拿到菜品集合
        List<Dish> dishes = managements.getDishs(canteen.getCanteenID());
        // 通过菜品id集合，得到所有的评论列表
        int[] dishIDs = dishes.stream().mapToInt(Dish::getDishID).toArray();
        List<Review> reviews = managements.getReviews(dishIDs);
        // 成功后 跳转到评论列表
        request.setAttribute("reviews", reviews);
        request.getRequestDispatcher("cantadmin_reviews_management.jsp").forward(request, response);
    }
}