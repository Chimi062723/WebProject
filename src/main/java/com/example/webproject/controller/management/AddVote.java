package com.example.webproject.controller.management;

import com.example.webproject.dao.VoteDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddVote", value = "/AddVote")
public class AddVote extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("newtitle");
        String question = request.getParameter("newquestion");
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        VoteDAO voteDAO = new VoteDAO();
        try {
            if(voteDAO.addVote(canteen.getCanteenID(), title, question)){
                response.sendRedirect("VoteInfoRefresh");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}