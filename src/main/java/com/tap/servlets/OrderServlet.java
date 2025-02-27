package com.tap.servlets;

import java.io.IOException;

import com.fooddelivery.daoimplementation.daoimplemenationorderitem;
import com.fooddelivery.daoimplementation.daoorderimplemetation;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.OrderItem;
import com.tap.cart.Cart;
import com.tap.cart.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart"); // Get cart from session
        Integer userId = (Integer) session.getAttribute("userId"); // Get user ID from session

        if (cart == null || cart.getItems().isEmpty() || userId == null) {
            response.sendRedirect("cart.jsp"); // Redirect back to cart if invalid
            return;
        }

        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");
        int restaurantId=Integer.parseInt(request.getParameter("resturantId"));

        // Create and save Order
        daoorderimplemetation orderDao = new daoorderimplemetation();
        Order order = new Order();
        order.setUserId(userId);
        order.setRestaurantId(restaurantId); // Assuming restaurantId is stored in the cart
        order.setTotalAmount(cart.getTotalprice());
        order.setStatus("Placed");
        order.setPaymentMode(paymentMethod);
        int orderId = orderDao.addOrder(order);

        if (orderId != -1) {
            // Save Order Items
            daoimplemenationorderitem orderItemDao = new daoimplemenationorderitem();
            for (CartItem item : cart.getItems().values()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemId(0); // Assuming it's auto-generated
                orderItem.setOrderId(orderId);
                orderItem.setMenuId(item.getMenuId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setTotalPrice(item.getPrice() * item.getQuantity());

                orderItemDao.addOrderItem(orderItem);
            }

            // Clear cart after placing order
            session.removeAttribute("cart");

            // Redirect to order confirmation page
            response.sendRedirect("OrderConfirmed.jsp");
        } else {
            response.sendRedirect("checkout.jsp?error=failed"); // Redirect to retry on failure
        }
    }
}
