package com.example.webproject.dao;

import com.example.webproject.model.Post;
import com.example.webproject.util.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private static final String GET_POST_BY_ID = "SELECT * FROM CommunityPosts WHERE PostID =?";
    private static final String GET_ALL_POSTS = "select * from CommunityPosts";

    public List<Post> getAllPosts() throws SQLException{
        List<Post> posts =new ArrayList<>();
        try(Connection connection = JDBCHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSTS)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
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
                }
            }
        }
        return post;
    }

    public void deletePost(int PostID) throws SQLException{

    }

    public void editPost(Post newPost) throws SQLException{
    }
}
