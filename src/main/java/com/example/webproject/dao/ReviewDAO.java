package com.example.webproject.dao;

import com.example.webproject.model.Review;
import com.example.webproject.util.DBhelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    private DBhelper dBhelper = new DBhelper();

    public List<Review> getAllReviews() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM reviews";
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
//                    resultSet.getTimestamp("createDate")
//                    new java.sql.Date(System.currentTimeMillis()).toString(),
//                    resultSet.getDate("createDate").toString(),
                    new Timestamp(resultSet.getTimestamp("createDate").getTime()),
                    resultSet.getString("picture")
//                    resultSet.getTimestamp("createDate")
            );
            reviews.add(review);
        }
        return reviews;}
    public List<Review> getReviewsByUserId(int userId) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM reviews WHERE userID = ?";
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
                    resultSet.getString("picture")
            );
            reviews.add(review);
        }
        return reviews;
    }

    public boolean addReview(Review review) throws SQLException {
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "INSERT INTO reviews (userID, dishID, rating, comment, reply, createDate) VALUES (?, ?, ?, ?, ?, ?)";
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
        String sql = "UPDATE reviews SET userID = ?, dishID = ?, rating = ?, comment = ?, reply = ?, createDate = ? WHERE reviewID = ?";
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
        String sql = "DELETE FROM reviews WHERE reviewID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, reviewId);
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }
}