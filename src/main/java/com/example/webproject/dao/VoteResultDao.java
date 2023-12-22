package com.example.webproject.dao;

import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoteResultDao {
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
}
