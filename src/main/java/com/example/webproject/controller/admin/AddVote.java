package com.example.webproject.controller.admin;

import com.example.webproject.dao.UserDAO;
import com.example.webproject.dao.VoteResultDao;
import com.example.webproject.model.Vote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "VoteServlet", value = "/VoteServlet")
public class AddVote extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String options=request.getParameter("result");
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("username");
        Vote vote=(Vote)session.getAttribute("vote");
        VoteResultDao voteResultDao=new VoteResultDao();
        UserDAO userDao=new UserDAO();
        try {
            voteResultDao.addVoteResult(vote.getPollId(),userDao.getUserByUsername(username).getUserID(),options);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
