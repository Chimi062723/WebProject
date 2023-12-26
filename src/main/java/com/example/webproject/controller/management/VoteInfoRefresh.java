package com.example.webproject.controller.management;

import com.example.webproject.dao.VoteDAO;
import com.example.webproject.model.Canteen;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "VoteInfoRefresh", value = "/VoteInfoRefresh")
public class VoteInfoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Canteen canteen = (Canteen) session.getAttribute("canteen");
        VoteDAO voteDAO = new VoteDAO();
        try {
            request.setAttribute("votes", voteDAO.getVotes(canteen.getCanteenID()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("cantadmin_vote_management.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}