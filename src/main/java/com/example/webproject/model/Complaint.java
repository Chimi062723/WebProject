package com.example.webproject.model;

import com.example.webproject.dao.CanteenDAO;
import com.example.webproject.dao.UserDAO;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Complaint {
    private int complaintID;
    private int userID;
    private int canteenID;
    private String content;
    private int status;
    private Timestamp createDate;
    private User user;
    private Canteen canteen;
    UserDAO userDAO = new UserDAO();
    CanteenDAO canteenDAO = new CanteenDAO();

    public Complaint() {
    }

    public Complaint(int complaintID, int userID, int canteenID, String content, int status, Timestamp createDate) {
        this.complaintID = complaintID;
        this.userID = userID;
        this.canteenID = canteenID;
        this.content = content;
        this.status = status;
        this.createDate = createDate;
        try {
            this.user=userDAO.getUserByID(userID);
            this.canteen=canteenDAO.getCanteenByID(canteenID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
        this.user=userDAO.getUserByID(userID);
    }

    public int getCanteenID() {
        return canteenID;
    }

    public void setCanteenID(int canteenID) {
        this.canteenID = canteenID;
        try {
            this.canteen=canteenDAO.getCanteenByID(canteenID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Canteen getCanteen() {
        return canteen;
    }

    public void setCanteen(Canteen canteen) {
        this.canteen = canteen;
    }
}
