package com.example.webproject.dao;

import com.example.webproject.model.Complaint;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {
    public List<Complaint> getUserComplaints(int userID) throws SQLException {
        Connection conn = JDBCHelper.getConnection();
        List<Complaint> complaints = new ArrayList<>();
        String sql = "SELECT * FROM Complaints WHERE UserID =?";
        PreparedStatement pstmt= null ;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Complaint complaint = new Complaint();
                complaint.setComplaintID(rs.getInt("ComplaintID"));
                complaint.setUserID(rs.getInt("UserID"));
                complaint.setCanteenID(rs.getInt("CanteenID"));
                complaint.setContent(rs.getString("Content"));
                complaint.setStatus(rs.getInt("Status"));
                complaint.setCreateDate(rs.getTimestamp("CreateDate"));
                complaints.add(complaint);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
        return complaints;
    }
    public boolean addComplaint(int userID,int canteenID,String content)throws SQLException {
        Connection conn = JDBCHelper.getConnection();
        String sql = "INSERT INTO Complaints(UserID,CanteenID,Content) VALUES(?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, canteenID);
            pstmt.setString(3, content);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }
}
