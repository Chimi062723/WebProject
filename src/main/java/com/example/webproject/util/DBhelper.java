package com.example.webproject.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
