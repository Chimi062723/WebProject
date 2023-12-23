package com.example.webproject.dao;

import com.example.webproject.model.Post;
import com.example.webproject.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDAO {
    private static final String GET_POST_BY_ID = "SELECT * FROM CommunityPosts WHERE PostID =?";
    //todo:PostDAO
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
}
