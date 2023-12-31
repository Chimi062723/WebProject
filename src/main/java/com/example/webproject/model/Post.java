package com.example.webproject.model;

import com.example.webproject.dao.PostDAO;
import com.example.webproject.dao.UserDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Post {
    int postID;
    int userID;
    String title;
    String content;
    String createDate;
    int like;
    String picture;
    int commentID;

    //以下author和comments为特殊封装对象
    User author;
    List<Post> comments;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public List<Post> getComments() {
        return comments;
    }

    public void setComments(List<Post> comments) {
        this.comments = comments;

    }

    UserDAO userDAO = new UserDAO();
    PostDAO postDAO = new PostDAO();

    public Post(int postID, int userID, String title, String content, Timestamp createDate, int like, String picture, int commentID) {
        this.postID = postID;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.createDate = createDate.toString();
        this.like = like;
        this.picture = picture;
        this.commentID = commentID;
        try {
            this.author = userDAO.getUserByID(userID);
            this.comments = postDAO.getPostByCommentID(postID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Post(int postID,  String title, String content, int userID,String createDate) {
        this.postID = postID;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public Post() {
    }


    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
        try {
            this.comments = postDAO.getPostByCommentID(postID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
        this.author = userDAO.getUserByID(userID);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
