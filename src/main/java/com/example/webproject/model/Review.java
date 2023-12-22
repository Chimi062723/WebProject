package com.example.webproject.model;

import java.sql.Date;

public class Review {
    int reviewID;
    int userID;
    int dishID;
    int rating;
    String comment;
    int statue; //评论有无被回复
    public Review(int reviewID, int userID, int dishID, int rating, String comment, int statue, Date createDate,String picture) {
        this.reviewID=reviewID;
        this.userID = userID;

    }
}
