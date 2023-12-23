package com.example.webproject.dao;

import com.example.webproject.model.Vote;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteDAO {
    private static final String GET_VOTE_BY_ID = "SELECT * FROM Polls WHERE PollID =?";
    public Vote getVote(int voteID) throws SQLException {
        Vote vote = new Vote();
        try(
        Connection conn = JDBCHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement(GET_VOTE_BY_ID)) {
            ps.setInt(1,voteID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vote.setPollId(rs.getInt("PollID"));
                    vote.setCanteenID(rs.getInt("CanteenID"));
                    vote.setTitle(rs.getString("Title"));
                    vote.setQuestion(rs.getString("Question"));
                    vote.setCreateDate(rs.getTimestamp("CreateDate"));
                }
            }
        }
        return vote;
    }
}
