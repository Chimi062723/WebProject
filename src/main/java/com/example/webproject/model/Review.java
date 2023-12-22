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

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }
}
