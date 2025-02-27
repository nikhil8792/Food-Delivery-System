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

@WebServlet("/register")
public class registerservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
     
    	
    	String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        

        // Create a User object with the form data
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        

        // Call the addUser method in the DAO implementation
        userinterface userDao = new daouserimpl();

        try {
            userDao.addUser(user);

            // Redirect to signin.jsp after successful signup
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();

            // Redirect back to signup.jsp with an error message
            response.sendRedirect("login.jsp?error=SignupFailed");
        }
    	
    	
    	
    	
    	
}
}

