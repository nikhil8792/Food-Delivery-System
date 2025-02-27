package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.User;

public interface userinterface {
	
	
	void addUser(User user);
	
	User getUser(int userId);
	
	 void updateUser(User user);
	 
	 void deleteuser(int userId);
	 
	 List<User>getAllUsers();
	 
	 User validateUser(String username,String password);
	
	 
	

}
