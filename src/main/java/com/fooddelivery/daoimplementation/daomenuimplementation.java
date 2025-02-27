package com.fooddelivery.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.menuinterface;
import com.fooddelivery.model.Menu;
import com.fooddelivery.utility.DBConnection;

public class daomenuimplementation implements menuinterface {
	



	    
	   
	   
	    
	    

	    @Override
	    public void addMenuItem(Menu menu) {
	    	String INSERT_MENU_QUERY = "INSERT INTO Menu (menuId, resturantId, itemName, description, price, ratings, isAvailable, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(INSERT_MENU_QUERY)) {

	            stmt.setInt(1, menu.getMenuId());
	            stmt.setInt(2, menu.getResturantId());
	            stmt.setString(3, menu.getItemName());
	            stmt.setString(4, menu.getDescription());
	            stmt.setDouble(5, menu.getPrice());
	            stmt.setDouble(6, menu.getRating());
	            stmt.setBoolean(7, menu.isAvailable());
	            stmt.setString(8, menu.getImagePath());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Menu getMenuItemById(int menuId) {
	    	  String SELECT_MENU_BY_ID_QUERY = "SELECT * FROM Menu WHERE menuId = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(SELECT_MENU_BY_ID_QUERY)) {

	            stmt.setInt(1, menuId);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                return new Menu(
	                    rs.getInt("menuId"),
	                    rs.getInt("resturantId"),
	                    rs.getString("itemName"),
	                    rs.getString("description"),
	                    rs.getDouble("price"),
	                    rs.getDouble("ratings"),
	                    rs.getBoolean("isAvailable"),
	                    rs.getString("imagePath")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null; // Return null if no record is found
	    }

	    @Override
	    public List<Menu> getAllMenuItemsByResturant(int resturantId) {
	    	 String SELECT_MENU_BY_RESTAURANT_QUERY = "SELECT * FROM `Menu` WHERE resturantId = ?";
	        List<Menu> menuItems = new ArrayList<>();
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(SELECT_MENU_BY_RESTAURANT_QUERY)) {

	            stmt.setInt(1, resturantId);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                menuItems.add(new Menu(
	                    rs.getInt("menuId"),
	                    rs.getInt("resturantId"),
	                    rs.getString("itemName"),
	                    rs.getString("description"),
	                    rs.getDouble("price"),
	                    rs.getDouble("ratings"),
	                    rs.getBoolean("isAvailable"),
	                    rs.getString("imagePath")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return menuItems;
	    }

	    @Override
	    public void updateMenuItem(Menu menuItem) {
	    	 String UPDATE_MENU_QUERY = "UPDATE Menu SET itemName = ?, description = ?, price = ?, ratings = ?, isAvailable = ?, imagePath = ? WHERE menuId = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(UPDATE_MENU_QUERY)) {

	            stmt.setString(1, menuItem.getItemName());
	            stmt.setString(2, menuItem.getDescription());
	            stmt.setDouble(3, menuItem.getPrice());
	            stmt.setDouble(4, menuItem.getRating());
	            stmt.setBoolean(5, menuItem.isAvailable());
	            stmt.setString(6, menuItem.getImagePath());
	            stmt.setInt(7, menuItem.getMenuId());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	 @Override
	    public void deleteMenuItem(int menuId) {
	    	 String DELETE_MENU_QUERY = "DELETE FROM Menu WHERE menuId = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(DELETE_MENU_QUERY)) {

	            stmt.setInt(1, menuId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	

