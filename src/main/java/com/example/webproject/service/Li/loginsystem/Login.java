package com.example.webproject.service.Li.loginsystem;


import com.example.webproject.dao.*;
//import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.model.*;
import com.example.webproject.util.DBhelper;
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
                    int userID=userDAO.getUserByUsername(username).getUserID();
                    session.setAttribute("userID",userID);
                    CanteenDAO canteenDAO = new CanteenDAO();
                    DishDAO dishDAO = new DishDAO();
                    PostDAO postDAO = new PostDAO();
                    ComplaintDAO complaintDAO = new ComplaintDAO();
                    VoteDAO voteDAO = new VoteDAO();
                    VoteResultDao voteResultDAO = new VoteResultDao();
                    ReviewDAO reviewDAO = new ReviewDAO();
                    role= userDAO.judgeRole(username);
                    switch (role) {
                        case "sys_admin":
                            session.setAttribute("users", userDAO.getAllUsers());
                            session.setAttribute("canteens", canteenDAO.getAllCanteens());
                            session.setAttribute("reviews", reviewDAO.getAllReviews());
                            session.setAttribute("posts", postDAO.getAllPosts());
                            request.getRequestDispatcher("admin_dashboard.jsp").forward(request, response);
                            break;
                        case "res_admin":
                            //先确认其管理的对应的食堂
                            Canteen canteen = canteenDAO.getCanteenByManagerID(userID);
                            session.setAttribute("canteen", canteen);
                            //获取未回复的评论
                            session.setAttribute("unreviews", reviewDAO.getUnReplyReviews(canteen));
                            //获取未处理的投诉
                            session.setAttribute("uncomplaints", complaintDAO.getUnprocessedComplaints(canteen.getCanteenID()));

                            request.getRequestDispatcher("cantadmin_dashboard.jsp").forward(request, response);
                            break;
                        case "normal_user":
                            session.setAttribute("dish1", dishDAO.getDish(1));
                            session.setAttribute("dish2", dishDAO.getDish(2));
                            session.setAttribute("dish3", dishDAO.getDish(3));
                            session.setAttribute("dish4", dishDAO.getDish(4));
                            session.setAttribute("dish5", dishDAO.getDish(5));
                            session.setAttribute("dish6", dishDAO.getDish(6));
                            //以上传入上新菜品

                            session.setAttribute("posts", postDAO.getMostLikesThreePosts());
                            //以上传入社区热点

                            List<Canteen> canteens = canteenDAO.getAllCanteens();
                            session.setAttribute("canteens", canteens);
                            //以上传入食堂信息

                            Vote vote = voteDAO.getVote(1);
                            session.setAttribute("vote", vote);
                            VoteResult voteResult = voteResultDAO.getVoteResult(1,userDAO.getUserByUsername(username).getUserID());
                            session.setAttribute("voteResult", voteResult);
                            //以上传入投票信息

                            //传入菜系信息
                            List<String> cuisines = dishDAO.getAllCuisines();
                            session.setAttribute("cuisinestype", cuisines);

                            //传入最新3条评论
                            List<Review> lastThreeReviews = reviewDAO.getLastThreeReviews();
                            session.setAttribute("lastThreeReviews", lastThreeReviews);

                            request.getRequestDispatcher("customer_dashboard.jsp").forward(request, response);
                            break;
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
