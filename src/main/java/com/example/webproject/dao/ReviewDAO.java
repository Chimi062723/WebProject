package com.example.webproject.dao;

import com.example.webproject.model.Review;
import com.example.webproject.util.DBhelper;
import com.example.webproject.util.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Review> getReviewsByDishId(int dishId) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM Reviews WHERE dishID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, dishId);
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

    public void addReview(Review review) throws SQLException {
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "INSERT INTO Reviews (userID, dishID, rating, comment, reply, Picture) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, review.getUserID());
        statement.setInt(2, review.getDishID());
        statement.setInt(3, review.getRating());
        statement.setString(4, review.getComment());
        statement.setString(5, review.getReply());
        if (Objects.equals(review.getPicture(), "")) {
            statement.setNull(6, Types.VARCHAR);
        } else {
            statement.setString(6, review.getPicture());
        }
        statement.executeUpdate();
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


    public List<Review>  getReviewsBydishIDs(int[] dishIDs) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (int i = 0; i < dishIDs.length; i++) {
            builder.append("?");
            if (i != dishIDs.length - 1) {
                builder.append(",");
            }
        }
        builder.append(")");
        String sql = "SELECT * FROM Reviews WHERE DishID IN " + builder;

        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < dishIDs.length; i++) {
            statement.setInt(i + 1, dishIDs[i]);
        }

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

    public Review  getReviewsByReviewID(int reviewID) throws SQLException {
        dBhelper.init();
        Connection connection = dBhelper.dbconn;
        String sql = "SELECT * FROM Reviews WHERE reviewID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, reviewID);
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
            return review;
        }
        return null;
    }

}