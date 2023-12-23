package com.example.webproject.dao;

import com.example.webproject.model.Review;
import com.example.webproject.util.DBhelper;
import com.example.webproject.util.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    private DBhelper dBhelper = new DBhelper();

    public List<Review> getAllReviews() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM Reviews";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Review review = new Review(
                    resultSet.getInt("reviewID"),
                    resultSet.getInt("userID"),
                    resultSet.getInt("dishID"),
                    resultSet.getInt("rating"),
                    resultSet.getString("comment"),
                    resultSet.getString("reply"),
                    resultSet.getTimestamp("createDate"),
                    resultSet.getString("Picture")
            );
//            review.setReviewID(resultSet.getInt("reviewID"));
//            review.setUserID(resultSet.getInt("userID"));
//            review.setDishID(resultSet.getInt("dishID"));
//            review.setRating(resultSet.getInt("rating"));
//            review.setComment(resultSet.getString("comment"));
//            review.setReply(resultSet.getString("reply"));
//            review.setCreateDate(resultSet.getTimestamp("createDate"));
//            构造方法已经将数据传入了，不需要再额外设置
            reviews.add(review);
        }
        return reviews;
    }

    public List<Review> getLastThreeReviews() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM Reviews ORDER BY CreateDate DESC LIMIT 3";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Review review = new Review(
                    resultSet.getInt("reviewID"),
                    resultSet.getInt("userID"),
                    resultSet.getInt("dishID"),
                    resultSet.getInt("rating"),
                    resultSet.getString("comment"),
                    resultSet.getString("reply"),
                    resultSet.getTimestamp("createDate"),
                    resultSet.getString("Picture")
            );
            reviews.add(review);
        }
        return reviews;
    }

    public List<Review> getReviewsByUserId(int userId) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM Reviews WHERE userID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Review review = new Review(
                    resultSet.getInt("reviewID"),
                    resultSet.getInt("userID"),
                    resultSet.getInt("dishID"),
                    resultSet.getInt("rating"),
                    resultSet.getString("comment"),
                    resultSet.getString("reply"),
                    resultSet.getTimestamp("createDate"),
                    resultSet.getString("Picture")
            );
            reviews.add(review);
        }
        return reviews;
    }

    public boolean addReview(Review review) throws SQLException {
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "INSERT INTO Reviews (userID, dishID, rating, comment, reply, createDate) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, review.getUserID());
        statement.setInt(2, review.getDishID());
        statement.setInt(3, review.getRating());
        statement.setString(4, review.getComment());
        statement.setString(5, review.getReply());
        statement.setTimestamp(6, review.getCreateDate());
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    public boolean updateReview(Review review) throws SQLException {
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "UPDATE Reviews SET userID = ?, dishID = ?, rating = ?, comment = ?, reply = ?, createDate = ? WHERE reviewID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, review.getUserID());
        statement.setInt(2, review.getDishID());
        statement.setInt(3, review.getRating());
        statement.setString(4, review.getComment());
        statement.setString(5, review.getReply());
        statement.setTimestamp(6, review.getCreateDate());
        statement.setInt(7, review.getReviewID());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    public boolean deleteReview(int reviewId) throws SQLException {
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "DELETE FROM Reviews WHERE reviewID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, reviewId);
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }

    public Review getReviewByReviewID(int reviewid) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        String sql = "select * from Reviews where ReviewID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,reviewid);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return new Review(
                    resultSet.getInt("ReviewID"),
                    resultSet.getInt("userID"),
                    resultSet.getInt("dishID"),
                    resultSet.getInt("rating"),
                    resultSet.getString("Comment"),
                    resultSet.getString("reply"),
                    resultSet.getTimestamp("createDate"),
                    resultSet.getString("Picture")
            );
        }else {
            return null;
        }
    }

}