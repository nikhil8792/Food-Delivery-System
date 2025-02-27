package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.OrderItem;

public interface orderitemdao {
	
	     void addOrderItem(OrderItem orderItem) ;
	      List<OrderItem> getOrderItemsByOrderId(int orderId) ;
	      void updateOrderItem(OrderItem orderItem) ;
	     public void deleteOrderItem(int orderItemId) ;
	      
}

