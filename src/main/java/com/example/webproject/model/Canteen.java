package com.example.webproject.model;

import com.example.webproject.dao.UserDAO;

public class Canteen {
    private int canteenID;
    private String name;
    private String location;
    private String openTime;
    private int managerID;

    private String notice;
    //以下为特殊封装对象
    private User manager;
    UserDAO userDAO = new UserDAO();
    public Canteen() {
    }

    public Canteen(int canteenID, String name, String location, String openTime, int managerID,String notice) {
        this.canteenID = canteenID;
        this.name = name;
        this.location = location;
        this.openTime = openTime;
        this.managerID = managerID;
        this.manager = userDAO.getUserByID(managerID);
        this.notice = notice;
    }


    // getters and setters

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public int getCanteenID() {
        return canteenID;
    }

    public void setCanteenID(int canteenID) {
        this.canteenID = canteenID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID){
        this.managerID = managerID;
        this.manager = userDAO.getUserByID(managerID);
    }


    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}