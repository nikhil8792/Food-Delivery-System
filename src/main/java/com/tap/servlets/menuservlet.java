package com.tap.servlets;


import java.io.IOException;
import java.util.List;

import com.fooddelivery.daoimplementation.daomenuimplementation;
import com.fooddelivery.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menuservlet")
public class menuservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int resturantId = 0;

        try {
            resturantId = Integer.parseInt(req.getParameter("resturantId"));

            // Fetch the menu items
            daomenuimplementation daoMenu = new daomenuimplementation();
            List<Menu> menuList = daoMenu.getAllMenuItemsByResturant(resturantId);

            // Set the menu list as a request attribute
            req.setAttribute("menus", menuList);

            // Forward the request to menu.jsp
            RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
            dispatcher.forward(req, resp);

        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid restaurant ID.");
            e.printStackTrace();
        } catch (Exception e) {
            resp.getWriter().println("Error while fetching menu items.");
            e.printStackTrace();
        }
    }
}
