package com.tap.servlets;



import java.io.IOException;

import com.fooddelivery.daoimplementation.daomenuimplementation;
import com.fooddelivery.model.Menu;
import com.tap.cart.Cart;
import com.tap.cart.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartservlet")
public class cartservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Retrieve cart from session or create a new one
        Cart cart = (Cart) session.getAttribute("cart");

        try {
            // Fetch restaurant ID from session and request
            Integer currentResturantId = (Integer) session.getAttribute("resturantId");
           int newResturantId=Integer.parseInt(String.valueOf(request.getParameter("resturantId")));
           


            // Reset cart if restaurant changes
            if ( cart==null||newResturantId!=currentResturantId) {
            	cart = new Cart();
                session.setAttribute("cart", cart);
               
                session.setAttribute("resturantId", newResturantId);
            }

            // Determine action type
            String action = request.getParameter("action");
            if (action == null) {
                throw new IllegalArgumentException("Action parameter is missing.");
            }

            // Perform action
            switch (action) {
                case "add":
                    addItemToCart(request, cart);
                    break;
                case "update":
                    updateCartItem(request, cart);
                    break;
                case "remove":
                    removeItemFromCart(request, cart);
                    break;
                case "checkout":
                    handleCheckout(request, response, cart);
                    return; // Prevent redirect after checkout
                default:
                    throw new IllegalArgumentException("Invalid action: " + action);
            }

            // Redirect to cart.jsp after operation
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("cart.jsp").forward(request, response);

        } catch (NumberFormatException e) {
        	e.printStackTrace();
            response.getWriter().println("Invalid numeric input: " + e.getMessage());
        } catch (IllegalArgumentException e) {
        	e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            response.getWriter().println("An error occurred: " + e.getMessage());
        }
    }

    // Add an item to the cart
    private void addItemToCart(HttpServletRequest request, Cart cart) throws NumberFormatException {
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        daomenuimplementation menuDAO = new daomenuimplementation();
        Menu menuItem = menuDAO.getMenuItemById(menuId);

        if (menuItem != null) {
            CartItem item = new CartItem(
                    menuItem.getMenuId(),
                    menuItem.getResturantId(),
                    menuItem.getItemName(),
                    menuItem.getPrice(),
                    quantity
            );
            cart.addCartItem(item);
        } else {
            System.out.println("Menu item not found for menuId: " + menuId);
        }
    }

    // Update an item in the cart
    private void updateCartItem(HttpServletRequest request, Cart cart) throws NumberFormatException {
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (quantity > 0) {
            cart.updateCartItem(menuId, quantity);
        } else {
            cart.removeCartItem(menuId); // Remove if quantity is 0 or less
        }
    }

    // Remove an item from the cart
    private void removeItemFromCart(HttpServletRequest request, Cart cart) throws NumberFormatException {
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        cart.removeCartItem(menuId);
    }

    // Handle checkout operation
    private void handleCheckout(HttpServletRequest request, HttpServletResponse response, Cart cart)
            throws IOException {
        // Perform checkout logic (e.g., save to database, clear cart)
        cart.clear();

        // Redirect to a checkout confirmation page
        response.sendRedirect("checkout.jsp");
    }
}
