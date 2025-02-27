package com.fooddelivery.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fooddelivery.dao.userinterface;
import com.fooddelivery.model.User;
import com.fooddelivery.utility.DBConnection;

public class daouserimpl implements userinterface  {


	
	

	@Override
	public void addUser(User user)  {
		String INSERT_SQL="insert into `user`(`name`,`username`,`password`,`email`,`phone`,`address`)values (?,?,?,?,?,?)";
		Scanner scan=new Scanner(System.in);
		
		try( Connection con=DBConnection.getConnection();
				PreparedStatement stmt=con.prepareStatement(INSERT_SQL);) {
			 
			
			
			
			
			stmt.setString(1,user.getName());
		     stmt.setString(2,user.getUsername());
			stmt.setString(3,user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPhone());
			stmt.setString(6,user.getAddress());
			
			
			
			
			int res=stmt.executeUpdate();
			
			System.out.println(res);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
	String GET_SQL=	"SELECT * from user where userid=?";
	User user=null;
	try(Connection con=DBConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement(GET_SQL);
	)
	{
		stmt.setInt(1, userId);
	    
		  ResultSet res=  stmt.executeQuery();
		  
		  
		  
		  String name=res.getString("name");

			String username=res.getString("username");
			String password=res.getString("password");
			
			String email=res.getString("email");
			String phone=res.getString("phone");
			String address=res.getString("address");
			
			 user=	new User(userId, name, username, password, email, phone, address);
					
		
	}
	
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	return user;
	


	
		
	    
		
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
String UpdateSQL="Update `user` set `name`=?  `password`=? `phone`=? `address`=? ";
		
		
Scanner scan=new Scanner(System.in);
		
		try( Connection con=DBConnection.getConnection();
				PreparedStatement stmt=con.prepareStatement(UpdateSQL);) {
			 
			
			
			
			
			stmt.setString(1,user.getName());
		    
			stmt.setString(2,user.getPassword());
			
			stmt.setString(3, user.getPhone());
			stmt.setString(4,user.getAddress());
			
			
			
		stmt.executeUpdate();
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	@Override
	public void deleteuser(int userId) {
		// TODO Auto-generated method stub
		String DeleteSQL="Delete from `user` where userid=?";
		
		Scanner scan=new Scanner(System.in);
				
				try( Connection con=DBConnection.getConnection();
						PreparedStatement stmt=con.prepareStatement(DeleteSQL);) {
					 
					
					
					
					
					
					
				stmt.setInt(1, userId);	
					
					
				stmt.executeUpdate();
					
					
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		String GET_ALL_SQL=	"SELECT * from `user` ";
		ArrayList<User>userlist=new ArrayList<User>();
		
		try(Connection con=DBConnection.getConnection();
				Statement stmt=con.createStatement();
		)
		{
			
			
			ResultSet res=stmt.executeQuery(GET_ALL_SQL);
			
			while(res.next())
			{
				   int userId=res.getInt("userId");
				  String name=res.getString("name");
                   String username=res.getString("username");
					String password=res.getString("password");
					
					String email=res.getString("email");
					String phone=res.getString("phone");
					String address=res.getString("address");
					
					
					
				User user=new User(userId, name, username, password, email, phone, address);
				
				
				userlist.add(user);
			}
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return userlist;

		
	}
	
	
	
	
	@Override
    public User validateUser(String username, String password) {
		  String VALIDATE_USER_QUERY = "SELECT * FROM User WHERE username = ? AND password = ?";
		  User user=null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(VALIDATE_USER_QUERY)) {
                
            // Setting the parameters for the query
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            // If a record is found, create and return the User object
            if (rs.next()) {
           int userId=rs.getInt("userId");
           String name=rs.getString("name");
			
			String email=rs.getString("email");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			
            			
			 user=new User(userId, name, username, password, email, phone, address);
			
            }
            			
            			
            }
            
            
	
         catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
        
        
    }
}
	
	
	


