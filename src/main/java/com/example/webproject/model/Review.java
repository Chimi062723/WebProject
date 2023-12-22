package com.example.webproject.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Review {
    int reviewID;
    int userID;
    int dishID;
    int rating;
    String comment;
    Timestamp createDate;

    String reply;

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Review(int reviewID, int userID, int dishID, int rating, String comment, String reply, Date createDate,String picture) {
        this.reviewID=reviewID;
        this.userID = userID;

    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
