package com.example.webproject.model;

import java.sql.Date;

public class Post {
    int postID;
    int userID;
    String title;
    String content;
    Date createDate;
    int like;
    public Post(int postId, int userID, String title, String content, Date createDate, int like) {
        this.postID = postId;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.like = like;
    }
}
