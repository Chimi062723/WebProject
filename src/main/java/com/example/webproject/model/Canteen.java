package com.example.webproject.model;

public class Canteen {
    private int canteenId;
    private String name;
    private String location;
    private String openTime;
    private int managerId;

    public Canteen() {
    }

    public Canteen(int canteenId, String name, String location, String openTime, int managerId) {
        this.canteenId = canteenId;
        this.name = name;
        this.location = location;
        this.openTime = openTime;
        this.managerId = managerId;
    }
    // getters and setters
    public int getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(int canteenId) {
        this.canteenId = canteenId;
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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId){
        this.managerId = managerId;
    }


}