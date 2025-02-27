package com.fooddelivery.model;

public class OrderItem {
    private int orderItemId;    // Primary Key
    private int orderId;        // Foreign Key to Order
    private int menuId;         // Foreign Key to Menu
    private int quantity;       // Quantity of the menu item
    private double totalPrice;  // Total price for this order item

    // Default Constructor
    public OrderItem() {
    }

    // Parameterized Constructor
    public OrderItem(int orderItemId, int orderId, int menuId, int quantity, double totalPrice) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // toString Method
    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", menuId=" + menuId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

