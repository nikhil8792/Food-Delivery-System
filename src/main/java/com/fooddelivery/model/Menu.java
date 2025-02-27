package com.fooddelivery.model;

public class Menu {
    private int menuId;         // Primary Key
    private int resturantId;   // Foreign Key to Restaurant
    private String itemName;
    private String description;
    private double price;
    private double ratings;
    private boolean isAvailable;
    private String imagePath;

    // Default Constructor
    public Menu() {
    }

    // Parameterized Constructor
    public Menu(int menuId, int resturantId, String itemName, String description, double price, double ratings, boolean isAvailable, String imagePath) {
        this.menuId = menuId;
        this.resturantId = resturantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.ratings = ratings;
        this.isAvailable = isAvailable;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getResturantId() {
        return resturantId;
    }

    public void setResturantId(int resturantId) {
        this.resturantId = resturantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return ratings;
    }

    public void setRating(double ratings) {
        this.ratings = ratings;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // toString Method
    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", resturantId=" + resturantId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rating=" + ratings +
                ", isAvailable=" + isAvailable +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
