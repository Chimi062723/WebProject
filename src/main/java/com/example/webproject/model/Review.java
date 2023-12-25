package com.example.webproject.model;

import com.example.webproject.dao.DishDAO;
import com.example.webproject.dao.UserDAO;
import java.sql.Timestamp;

public class Review {
    int reviewID;
    int userID;
    int dishID;
    int rating;
    String comment;
    Timestamp createDate;
    String reply;
    String picture;
    User sender;
    Dish dish;

    //addReview使用,只可
    public Review(int dishID, int userID, int rating, String comment, String picture) {
        this.dishID = dishID;
        this.userID = userID;
        this.rating = rating;
        this.comment = comment;
        this.picture = picture;
        UserDAO userDAO = new UserDAO();
        DishDAO dishDAO = new DishDAO();
        try {
            this.sender = userDAO.getUserByID(userID);
            this.dish = dishDAO.getDish(dishID);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Review(int reviewID, int userID, int dishID, int rating, String comment, String reply, Timestamp createDate, String picture) {
        this.reviewID=reviewID;
        this.userID = userID;
        this.dishID = dishID;
        this.rating = rating;
        this.comment = comment;
        this.reply = reply;
        this.createDate = createDate;
        this.picture=picture;
        UserDAO userDAO = new UserDAO();
        DishDAO dishDAO = new DishDAO();
        try {
            this.sender = userDAO.getUserByID(userID);
            this.dish = dishDAO.getDish(dishID);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        UserDAO userDAO = new UserDAO();
        try {
            this.sender = userDAO.getUserByID(userID);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID)
    {
        this.dishID = dishID;
        DishDAO dishDAO = new DishDAO();
        try {
            this.dish = dishDAO.getDish(dishID);
        }catch (Exception e) {
            e.printStackTrace();
        }
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
