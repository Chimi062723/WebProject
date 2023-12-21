package com.example.webproject.model;

import java.sql.Date;

public class Post {
    int postID;
    int userID;
    String author;
    String title;
    String content;
    String createDate;
    int like;
    String picture;

    public Post() {
    }
    public Post(int postId, int userID, String title, String content,String createDate, int like, String picture) {
        this.postID = postId;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.like = like;
        this.picture = picture;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
