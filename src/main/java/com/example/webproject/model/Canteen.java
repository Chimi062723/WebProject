package com.example.webproject.model;

public class Canteen {
    private int canteenID;
    private String name;
    private String location;
    private String openTime;
    private int managerID;

    public Canteen() {
    }

    public Canteen(int canteenID, String name, String location, String openTime, int managerID) {
        this.canteenID = canteenID;
        this.name = name;
        this.location = location;
        this.openTime = openTime;
        this.managerID = managerID;
    }
    // getters and setters
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
    }


}