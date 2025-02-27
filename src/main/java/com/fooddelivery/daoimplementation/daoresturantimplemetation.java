package com.fooddelivery.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.ResturantInterface;
import com.fooddelivery.model.resturant;
import com.fooddelivery.utility.DBConnection;


public class daoresturantimplemetation implements ResturantInterface {

     
     
      
   

    // Add a new restaurant
    @Override
    public void addResturant(resturant resturant1) {
    	String INSERT_QUERY = "INSERT INTO resturant (resturantid, name, address, phone, rating, cuisinetype, isactive, eta, adminuserid, imagepath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {
            
            stmt.setInt(1, resturant1.getResturantid());
            stmt.setString(2, resturant1.getName());
            stmt.setString(3, resturant1.getAddress());
            stmt.setLong(4, resturant1.getPhone());
            stmt.setFloat(5, resturant1.getRating());
            stmt.setString(6, resturant1.getCusineType());
            stmt.setBoolean(7, resturant1.isIsactive());
            stmt.setString(8, resturant1.getEta());
            stmt.setString(9, resturant1.getAdminuserid());
            stmt.setString(10, resturant1.getImagepath());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a restaurant by ID
    @Override
    public resturant getResturantById(int resturantid) {
    	 String SELECT_BY_ID_QUERY = "SELECT * FROM resturant WHERE resturantid = ?";
    	 resturant res1=null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_QUERY)) {
            
            stmt.setInt(1, resturantid);
            ResultSet rs = stmt.executeQuery();

            
                
               
                   String name= rs.getString("name");
                   String address= rs.getString("address");
                  long phone=  rs.getLong("phone");
                  float rating=  rs.getFloat("rating");
                   String cusineType= rs.getString("cusineType");
                   boolean isactive= rs.getBoolean("isactive");
                   String eta= rs.getString("eta");
                  String adminuserid=  rs.getString("adminuserid");
                 String imagepath=   rs.getString("imagepath");
                 
                 
                res1=new resturant(resturantid,name,address,phone,rating,cusineType,isactive,eta,adminuserid,imagepath);
               
               
               
                 
            }
            
         catch (SQLException e) {
            e.printStackTrace();
        }
        
        return res1;
       
    }

    // Get all restaurants
    @Override
    public List<resturant> getAllResturant() {
    	String SELECT_ALL_QUERY = "SELECT * FROM resturant";
        List<resturant> restaurants = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                restaurants.add(new resturant(
                    rs.getInt("resturantid"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getLong("phone"),
                    rs.getFloat("rating"),
                    rs.getString("cusineType"),
                    rs.getBoolean("isactive"),
                    rs.getString("eta"),
                    rs.getString("adminuserid"),
                    rs.getString("imagepath")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    // Update a restaurant
    @Override
    public void updateResturant(resturant res) {
    	 String UPDATE_QUERY = "UPDATE resturant SET name = ?, address = ?, phone = ?, rating = ?, cuisinetype = ?, isactive = ?, eta = ?, adminuserid = ?, imagepath = ? WHERE resturantid = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {

            stmt.setString(1, res.getName());
            stmt.setString(2, res.getAddress());
            stmt.setLong(3, res.getPhone());
            stmt.setFloat(4, res.getRating());
            stmt.setString(5, res.getCusineType());
            stmt.setBoolean(6, res.isIsactive());
            stmt.setString(7, res.getEta());
            stmt.setString(8, res.getAdminuserid());
            stmt.setString(9, res.getImagepath());
            stmt.setInt(10, res.getResturantid());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a restaurant by ID
    @Override
    public void deleteResturant(int resturantid) {
    	String Delete_QUERY="Delete from `resturant` where restuarntid=?";
         
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(Delete_QUERY)) {

            stmt.setInt(1, resturantid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	

	
}

	

	

