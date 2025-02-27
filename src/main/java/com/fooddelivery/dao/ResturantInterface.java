package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.resturant;

public interface ResturantInterface {
	
	resturant getResturantById(int resturantid);
	
	 List<resturant>getAllResturant();
	
	void updateResturant(resturant res);
	
	 void deleteResturant(int resturantid);
	 
	 void addResturant(resturant resturant1);

	
	
	
	
	
	
}
