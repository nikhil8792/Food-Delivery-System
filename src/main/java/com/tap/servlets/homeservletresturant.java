package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.fooddelivery.daoimplementation.daoresturantimplemetation;
import com.fooddelivery.model.resturant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resturant")
public class homeservletresturant extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			
		
		daoresturantimplemetation resturantdao=new daoresturantimplemetation();
		
		List<resturant>all=resturantdao.getAllResturant();
		
		req.setAttribute("resturants", all);
	        
		RequestDispatcher rd=req.getRequestDispatcher("resturant.jsp");
		rd.forward(req, resp);
		
		
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
