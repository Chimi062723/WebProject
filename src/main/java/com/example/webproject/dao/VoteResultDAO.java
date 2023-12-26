package com.example.webproject.dao;

import com.example.webproject.model.VoteResult;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteResultDAO {
    private static final String ADD_VOTE_RESULT_SQL = "INSERT INTO PollResults (PollID,UserID,SelectedOption)VALUES(?,?,?)";
    public boolean addVoteResult( int pollID, int userID,String answer) throws SQLException {
        try(Connection conn = JDBCHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(ADD_VOTE_RESULT_SQL)) {
            pstmt.setInt(1, pollID);
            pstmt.setInt(2, userID);
            pstmt.setString(3, answer);
            int res=pstmt.executeUpdate();
            if(res>0)
                return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<VoteResult> getVoteResults(int pollID) throws SQLException {
        List<VoteResult> voteResults = new ArrayList<>();
        try(Connection conn = JDBCHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM PollResults WHERE PollID=?")) {
            pstmt.setInt(1, pollID);
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    VoteResult voteResult = new VoteResult();
                    voteResult.setPollID(rs.getInt("PollID"));
                    voteResult.setUserID(rs.getInt("UserID"));
                    voteResult.setAnswer(rs.getString("SelectedOption"));
                    voteResults.add(voteResult);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return voteResults;
    }
    public VoteResult getVoteResult(int pollID, int userID) throws SQLException {
        VoteResult voteResult = null;
        try(Connection conn = JDBCHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM PollResults WHERE PollID=? AND UserID=?")) {
            pstmt.setInt(1, pollID);
            pstmt.setInt(2, userID);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    voteResult = new VoteResult();
                    voteResult.setPollID(rs.getInt("PollID"));
                    voteResult.setUserID(rs.getInt("UserID"));
                    voteResult.setAnswer(rs.getString("SelectedOption"));
                }
            }
        }
        return voteResult;
    }
}
