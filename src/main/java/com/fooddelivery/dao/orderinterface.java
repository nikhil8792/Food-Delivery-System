package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.Order;



	public interface orderinterface {
	    
	    
	     Order getOrderById(int orderId) ;
	      

	     List<Order> getAllOrdersByUser(int userId) ;
	        
	     int addOrder(Order order) ;
	     void updateOrder(Order order) ;
	      
	     void deleteOrder(int orderId) ;
	     
	}


