package com.fooddelivery.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.orderitemdao;
import com.fooddelivery.model.OrderItem;
import com.fooddelivery.utility.DBConnection;

public class daoimplemenationorderitem  implements orderitemdao{
	

	

	     
	  @Override
	    public void addOrderItem(OrderItem orderItem) {
	    	String INSERT_ORDER_ITEM_QUERY = "INSERT INTO OrderItem (orderItemId, orderId, menuId, quantity, totalPrice) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER_ITEM_QUERY)) {

	            stmt.setInt(1, orderItem.getOrderItemId());
	            stmt.setInt(2, orderItem.getOrderId());
	            stmt.setInt(3, orderItem.getMenuId());
	            stmt.setInt(4, orderItem.getQuantity());
	            stmt.setDouble(5, orderItem.getTotalPrice());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<OrderItem> getOrderItemsByOrderId(int orderitem) {
	    	String SELECT_ORDER_ITEMS_BY_ORDER_ID_QUERY = "SELECT * FROM OrderItem WHERE orderId = ?";
	        List<OrderItem> orderItems = new ArrayList<>();
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_ITEMS_BY_ORDER_ID_QUERY)) {

	            stmt.setInt(1, orderitem);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                orderItems.add(new OrderItem(
	                    rs.getInt("orderItemId"),
	                    rs.getInt("orderId"),
	                    rs.getInt("menuId"),
	                    rs.getInt("quantity"),
	                    rs.getDouble("totalPrice")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orderItems;
	    }

	    @Override
	    public void updateOrderItem(OrderItem orderItem) {
	    	 String UPDATE_ORDER_ITEM_QUERY = "UPDATE OrderItem SET orderId = ?, menuId = ?, quantity = ?, totalPrice = ? WHERE orderItemId = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER_ITEM_QUERY)) {

	            stmt.setInt(1, orderItem.getOrderId());
	            stmt.setInt(2, orderItem.getMenuId());
	            stmt.setInt(3, orderItem.getQuantity());
	            stmt.setDouble(4, orderItem.getTotalPrice());
	            stmt.setInt(5, orderItem.getOrderItemId());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteOrderItem(int orderItemId) {
	    	String DELETE_ORDER_ITEM_QUERY = "DELETE FROM OrderItem WHERE orderItemId = ?";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_ITEM_QUERY)) {

	            stmt.setInt(1, orderItemId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


