package com.example.webproject.dao;

import com.example.webproject.model.Post;
import com.example.webproject.util.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private static final String GET_POST_BY_ID = "SELECT * FROM CommunityPosts WHERE PostID =?";
    private static final String GET_ALL_POSTS = "select * from CommunityPosts";
    private static final String GET_POST_BY_USER_ID = "SELECT * FROM CommunityPosts WHERE UserID =?";

    public List<Post> getAllPosts() throws SQLException {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post(
                        resultSet.getInt("PostID"),
                        resultSet.getInt("UserID"),
                        resultSet.getString("Title"),
                        resultSet.getString("Content"),
                        resultSet.getTimestamp("CreateDate"),
                        resultSet.getInt("Like"),
                        resultSet.getString("Picture"),
                        resultSet.getInt("CommentID")
                );
                posts.add(post);
            }
        }
        return posts;
    }

    public List<Post> getPostsByUserID(int userID) throws SQLException {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_POST_BY_USER_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post(
                        resultSet.getInt("PostID"),
                        resultSet.getInt("UserID"),
                        resultSet.getString("Title"),
                        resultSet.getString("Content"),
                        resultSet.getTimestamp("CreateDate"),
                        resultSet.getInt("Like"),
                        resultSet.getString("Picture"),
                        resultSet.getInt("CommentID")
                );
                posts.add(post);
            }
        }
        return posts;
    }

    public List<Post> getMostLikesThreePosts() throws SQLException {
        List<Post> posts = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        String sql = "SELECT * FROM CommunityPosts ORDER BY `Like` DESC LIMIT 3";
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostID(resultSet.getInt("PostID"));
                post.setUserID(resultSet.getInt("UserID"));
                post.setTitle(resultSet.getString("Title"));
                post.setContent(resultSet.getString("Content"));
                post.setCreateDate(resultSet.getTimestamp("CreateDate").toString());
                post.setLike(resultSet.getInt("Like"));
                post.setPicture(resultSet.getString("Picture"));
                post.setAuthor(userDAO.getUserByID(resultSet.getInt("UserID")));
                post.setCommentID(resultSet.getInt("CommentID"));
                posts.add(post);
            }
        }
        return posts;
    }

    public Post getPost(int postID) throws SQLException {
        Post post = new Post();
        UserDAO userDAO = new UserDAO();
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_POST_BY_ID)) {
            ps.setInt(1, postID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    post.setPostID(rs.getInt("PostID"));
                    post.setUserID(rs.getInt("UserID"));
                    post.setTitle(rs.getString("Title"));
                    post.setContent(rs.getString("Content"));
                    post.setCreateDate(rs.getTimestamp("CreateDate").toString());
                    post.setLike(rs.getInt("Like"));
                    post.setPicture(rs.getString("Picture"));
                    post.setAuthor(userDAO.getUserByID(rs.getInt("UserID")));
                    post.setCommentID(rs.getInt("CommentID"));
                }
            }
        }
        return post;
    }
public List<Post> getPostByCommentID(int commentID) throws SQLException {
        List<Post> posts = null;
        UserDAO userDAO = new UserDAO();
        String sql = "SELECT * FROM CommunityPosts WHERE CommentID =? ORDER BY CreateDate DESC";
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            posts=new ArrayList<>();
            preparedStatement.setInt(1,commentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostID(resultSet.getInt("PostID"));
                post.setUserID(resultSet.getInt("UserID"));
                post.setTitle(resultSet.getString("Title"));
                post.setContent(resultSet.getString("Content"));
                post.setCreateDate(resultSet.getTimestamp("CreateDate").toString());
                post.setLike(resultSet.getInt("Like"));
                post.setPicture(resultSet.getString("Picture"));
                post.setAuthor(userDAO.getUserByID(resultSet.getInt("UserID")));
                post.setCommentID(resultSet.getInt("CommentID"));
                posts.add(post);
            }
        }
        return posts;
    }
    public void deletePost(int PostID) throws SQLException {

    }

    public void editPost(Post newPost) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        String editSQL = "update CommunityPosts set UserID=?,Title =?,Content=?,CreateDate=? where PostID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(editSQL);
        preparedStatement.setInt(1, newPost.getUserID());
        preparedStatement.setString(2, newPost.getTitle());
        preparedStatement.setString(3, newPost.getContent());
        preparedStatement.setString(4, newPost.getCreateDate());
        preparedStatement.setInt(5, newPost.getPostID());
        preparedStatement.executeUpdate();
    }
}
