package com.example.webproject.util;

import com.example.webproject.dao.UserDAO;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Dish;
import com.example.webproject.model.Post;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                post.setPostID(rs.getInt("PostID"));
                post.setUserID(rs.getInt("UserID"));
                post.setTitle(rs.getString("Title"));
                post.setContent(rs.getString("Content"));
                Timestamp createTimestamp = rs.getTimestamp("CreateDate");
                if (createTimestamp != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = sdf.format( createTimestamp.getTime());
                    post.setCreateDate(formattedDateTime);
                }
                post.setLike(rs.getInt("Like"));
                post.setPicture(rs.getString("Picture"));
                post.setCommentID(rs.getInt("CommentID"));
                postList.add(post);
            }
            return postList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean addPost(Connection dbconn, int userid,String title, String content) {
        String sql = "INSERT INTO CommunityPosts (UserID,Title,Content) VALUES (?,?,?)";
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
    public String getUserName(Connection dbconn, int userid) {
        String sql = "SELECT Username FROM Users WHERE UserID = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("Username");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public List<Dish> getDishList(Connection dbconn, String cuisine) {
        String sql = "SELECT * FROM Dishes WHERE CuisineType = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setString(1, cuisine);
            ResultSet rs = ps.executeQuery();
            List<Dish> dishList = new java.util.ArrayList<>();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setType(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setImage(rs.getString("ImageURL"));
                dishList.add(dish);
            }
            return dishList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Dish> getAllDishList(Connection dbconn) {
        String sql = "SELECT * FROM Dishes";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Dish> dishList = new java.util.ArrayList<>();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setType(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setImage(rs.getString("ImageURL"));
                dishList.add(dish);
            }
            return dishList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public List<Canteen> performFuzzySearch(Connection connection , String canteenName) {
        List<Canteen> canteens = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM Canteens WHERE Name LIKE ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + canteenName + "%"); // 设置模糊查询条件
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Canteen canteen = new Canteen();
                canteen.setCanteenID(resultSet.getInt("CanteenID"));
                canteen.setName(resultSet.getString("Name"));
                canteen.setLocation(resultSet.getString("Location"));
                canteen.setOpenTime(resultSet.getString("OpenTime"));
                canteen.setManagerID(resultSet.getInt("ManagerID"));
                canteen.setNotice(resultSet.getString("Notice"));
                canteens.add(canteen);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return canteens;
    }

    public List<Dish> getDishListByCanteen(Connection dbconn, String canteenName) {
        String sql = "SELECT * FROM Dishes WHERE CanteenID = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setInt(1, getCanteenID(dbconn, canteenName));
            ResultSet rs = ps.executeQuery();
            List<Dish> dishList = new java.util.ArrayList<>();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setType(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setImage(rs.getString("ImageURL"));
                dishList.add(dish);
            }
            return dishList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private int getCanteenID(Connection dbconn, String canteenName) {
        String sql = "SELECT CanteenID FROM Canteens WHERE Name = ?";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ps.setString(1, canteenName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("CanteenID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public List<Dish> getDishListByPriceAscending(Connection dbconn) {
        String sql = "SELECT * FROM Dishes ORDER BY Price ASC";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Dish> dishList = new java.util.ArrayList<>();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setType(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setImage(rs.getString("ImageURL"));
                dishList.add(dish);
            }
            return dishList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Dish> getDishListByPriceDescending(Connection dbconn) {
        String sql = "SELECT * FROM Dishes ORDER BY Price DESC";
        PreparedStatement ps = null;
        try {
            ps = dbconn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Dish> dishList = new java.util.ArrayList<>();
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setDishID(rs.getInt("DishID"));
                dish.setCanteenID(rs.getInt("CanteenID"));
                dish.setName(rs.getString("Name"));
                dish.setType(rs.getString("CuisineType"));
                dish.setPrice(rs.getDouble("Price"));
                dish.setImage(rs.getString("ImageURL"));
                dishList.add(dish);
            }
            return dishList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
