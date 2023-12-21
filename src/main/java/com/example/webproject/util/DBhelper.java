package com.example.webproject.util;

import com.example.webproject.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBhelper {
    public Connection dbconn = null;
    public void init() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://119.3.158.9:3306/web_restaurant?useSSL=false&serverTimezone=Asia/Shanghai";
        String user="webteam";
        String Password="webweb";
        try {
            Class.forName(driver); // 加载驱动程序
            dbconn = java.sql.DriverManager.getConnection(url, user, Password);//创建连接对象
        } catch ( ClassNotFoundException e1) {
            System.out.println(e1);
        } catch (java.sql.SQLException e2) {
            e2.printStackTrace();

        }
    }
    //检查账号是否已经存在
    public static boolean isAccountExists(Connection conn, String Username) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Users WHERE Username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }
    // 验证密码
    public static boolean verifyPassword(Connection conn, String Username, String Password) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Users WHERE Username = ? AND Password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Username);
        ps.setString(2, Password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
        return false;
    }
    // 注册账号
    public static boolean registerAccount(Connection conn, String Username, String Password,String email) throws SQLException {
        String sql = "INSERT INTO Users (Username, Password,Email) VALUES (?, ?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Username);
        ps.setString(2, Password);
        ps.setString(3, email);
        int result = ps.executeUpdate();
        return result > 0;
    }

    public boolean verifyEmail(Connection dbconn, String username, String email) {
        String sql = "SELECT COUNT(*) FROM Users WHERE Username = ? AND Email = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void changePassword(Connection dbconn, String username, String newPassword) {
        String sql = "UPDATE Users SET Password = ? WHERE Username = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Post> getPostList(Connection dbconn) {
        String sql = "SELECT * FROM CommunityPosts";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Post> postList = new java.util.ArrayList<>();
            while (rs.next()) {
                Post post = new Post();
                post.setPostID(rs.getInt("PostId"));
                post.setUserID(rs.getInt("UserId"));
                post.setTitle(rs.getString("Title"));
                post.setContent(rs.getString("Content"));
                post.setCreateDate(rs.getDate("CreateDate"));
                post.setLike(rs.getInt("Like"));
                post.setPicture(rs.getString("Picture"));
                postList.add(post);
            }
            return postList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean addPost(Connection dbconn, int userid,String title, String content) {
        String sql = "INSERT INTO CommunityPosts (UserID,Title, Content) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setInt(1,userid);
            ps.setString(2, title);
            ps.setString(3, content);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int getUserID(Connection dbconn, String username) {
        String sql = "SELECT UserID FROM Users WHERE Username = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("UserID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
