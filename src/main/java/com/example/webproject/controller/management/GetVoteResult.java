package com.example.webproject.controller.management;

import com.example.webproject.dao.UserDAO;
import com.example.webproject.dao.VoteResultDAO;
import com.example.webproject.model.User;
import com.example.webproject.model.VoteResult;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "GetVoteResult", value = "/GetVoteResult")
public class GetVoteResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pollID = Integer.parseInt(request.getParameter("pollID"));
        String title = request.getParameter("title");
        String question = request.getParameter("question");
        Timestamp createDate = Timestamp.valueOf(request.getParameter("createDate"));
        VoteResultDAO voteResultDao = new VoteResultDAO();
        UserDAO userDao = new UserDAO();
        try {
            List<VoteResult> voteResults = voteResultDao.getVoteResults(pollID);
            List<User> users = userDao.getAllUsers();
            HashMap<Integer, String> userMap = new HashMap<>();
            for (User user : users) {
                userMap.put(user.getUserID(), user.getUserName());
            }
            for (VoteResult voteResult : voteResults) {
                voteResult.setUserName(userMap.get(voteResult.getUserID()));
            }
            request.setAttribute("title", title);
            request.setAttribute("question", question);
            request.setAttribute("createDate", createDate);
            request.setAttribute("voteResults", voteResults);
            request.getRequestDispatcher("vote_result.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}