package com.example.webproject.model;

public class Dish {
    private int dishID;
    private String name;
    private String type;
    private double price;
    private int canteenID;
    private String image;

    public Dish() {
    }

    public Dish(int dishID, String name, String type, double price, int canteenID, String image) {
        this.dishID = dishID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.canteenID = canteenID;
        this.image = image;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID= dishID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type){
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getCanteenID() {
        return canteenID;
    }

    public void setCanteenID(int canteenID){
        this.canteenID = canteenID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
}
