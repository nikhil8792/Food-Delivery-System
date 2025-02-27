package com.fooddelivery.dao;


import java.util.List;

import com.fooddelivery.model.Menu;

public interface menuinterface {

	
	
	
	
	     void addMenuItem(Menu menu) ;

	     Menu getMenuItemById(int menuId) ;
	      
	    public List<Menu> getAllMenuItemsByResturant(int resturantId) ;

	    void updateMenuItem(Menu menuItem) ;
	      

	    public void deleteMenuItem(int menuId);
	    

}
