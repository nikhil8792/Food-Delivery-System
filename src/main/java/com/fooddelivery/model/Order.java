package com.fooddelivery.model;

public class Order {
    private int orderId;       // Primary Key
    private int userId;        // Foreign Key to User
    private int restaurantId;  // Foreign Key to Restaurant
    private double totalAmount;
    private String status;     // e.g., "Ordered", "Placed", "Delivered"
    private String paymentMode; // e.g., "UPI", "Card", "Cash"

    // Default Constructor
    public Order() {
    }

    // Parameterized Constructor
    public Order(int orderId, int userId, int restaurantId, double totalAmount, String status, String paymentMode) {
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMode = paymentMode;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    // toString Method
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                '}';
    }
}

	