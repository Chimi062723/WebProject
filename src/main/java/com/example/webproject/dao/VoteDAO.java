package com.example.webproject.dao;

import com.example.webproject.model.Vote;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteDAO {
    private static final String GET_VOTE_BY_ID = "SELECT * FROM Polls WHERE PollID =?";
    private static final String GET_VOTES_BY_CANTEEN_ID = "SELECT * FROM Polls WHERE CanteenID =?";
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
    public List<Vote> getVotes(int canteenID) throws SQLException {
        List<Vote> votes = new ArrayList<>();
        try(
        Connection conn = JDBCHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement(GET_VOTES_BY_CANTEEN_ID)) {
            ps.setInt(1,canteenID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vote vote = new Vote();
                    vote.setPollId(rs.getInt("PollID"));
                    vote.setCanteenID(rs.getInt("CanteenID"));
                    vote.setTitle(rs.getString("Title"));
                    vote.setQuestion(rs.getString("Question"));
                    vote.setCreateDate(rs.getTimestamp("CreateDate"));
                    votes.add(vote);
                }
            }
        }
        return votes;
    }
    public boolean addVote(int canteenID,String title,String question) throws SQLException {
        try(
        Connection conn = JDBCHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Polls (CanteenID, Title, Question) VALUES (?,?,?)")) {
            ps.setInt(1,canteenID);
            ps.setString(2,title);
            ps.setString(3,question);
            int result = ps.executeUpdate();
            if(result>0){
                conn.close();
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
