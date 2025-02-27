package com.tap.servlets;

import java.io.IOException;

import com.fooddelivery.dao.userinterface;
import com.fooddelivery.daoimplementation.daouserimpl;
import com.fooddelivery.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Retrieve login credentials from request
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Call the DAO to validate user
	        userinterface userDao = new daouserimpl();
	        User user = userDao.validateUser(username, password);
try
{
	        if (user != null) {
	            // If valid, redirect to restaurant.jsp
	        	response.sendRedirect("resturant");
	           
	        } else {
	            // If invalid, redirect back to login.jsp with error
	        	response.getWriter().println("<h3>Invalid Username or Password. Try again!</h3>");
	            request.getRequestDispatcher("login.jsp").include(request, response);
	        }
	    }
catch(Exception e)
{
	e.printStackTrace();
}

	 }
	}



