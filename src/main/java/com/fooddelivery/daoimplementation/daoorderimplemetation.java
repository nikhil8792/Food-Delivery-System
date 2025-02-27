package com.fooddelivery.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.orderinterface;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.resturant;
import com.fooddelivery.utility.DBConnection;

public class daoorderimplemetation implements orderinterface {

	public int addOrder(Order order) {
	    String INSERT_ORDER_QUERY = "INSERT INTO `Order` (userId, restaurantId, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?)";
	    int orderId = -1; // Initialize with a default value to handle cases when orderId is not generated.
	    try (
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS)
	    ) {
	        stmt.setInt(1, order.getUserId());
	        stmt.setInt(2, order.getRestaurantId());
	        stmt.setDouble(3, order.getTotalAmount());
	        stmt.setString(4, order.getStatus());
	        stmt.setString(5, order.getPaymentMode());

	        stmt.executeUpdate();

	        try (ResultSet rs = stmt.getGeneratedKeys()) {
	            if (rs.next()) {
	                orderId = rs.getInt(1); // Retrieve the generated key
	                System.out.println("Generated Order ID: " + orderId);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Consider logging instead of printing the stack trace
	    }
	    return orderId;
	}


    @Override
    public Order getOrderById(int orderId) {
    	Order order=null;
    	 String SELECT_ORDER_BY_ID_QUERY = "SELECT * FROM `Order` WHERE orderId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_BY_ID_QUERY)) {

            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

           
           
            int userId= rs.getInt("userId");
           int restaurantId=  rs.getInt("restaurantId");
           double totalAmount=  rs.getFloat("totalAmount");
           String status=rs.getString("status");
           String paymentMode=rs.getString("paymentMode");
          
          
         order=new Order(orderId,userId,restaurantId,totalAmount,status,paymentMode);
            
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
}
       

    @Override
    public List<Order> getAllOrdersByUser(int userId) {
    	
    	String SELECT_ORDERS_BY_USER_QUERY = "SELECT * FROM `Order` WHERE userId = ?";
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ORDERS_BY_USER_QUERY)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getInt("restaurantId"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentMode")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void updateOrder(Order order) {
    	 String UPDATE_ORDER_QUERY = "UPDATE `Order` SET userId = ?, restaurantId = ?, totalAmount = ?, status = ?, paymentMode = ? WHERE orderId = ?";
    	
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER_QUERY)) {

            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setDouble(3, order.getTotalAmount());
            stmt.setString(4, order.getStatus());
            stmt.setString(5, order.getPaymentMode());
            stmt.setInt(6, order.getOrderId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
    	 String DELETE_ORDER_QUERY = "DELETE FROM `Order` WHERE orderId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_QUERY)) {

            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



