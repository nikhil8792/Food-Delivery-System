<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, com.tap.cart.Cart, com.tap.cart.CartItem" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
      <link rel="stylesheet" href="cart.css">
</head>
<body>
    <div class="container">
        <h1>Your Cart</h1>
        <%
            Cart cart = (Cart) session.getAttribute("cart"); // Retrieve the cart from session
            Integer restaurantId = (Integer) session.getAttribute("resturantId"); // Retrieve restaurant ID

            if (cart == null || cart.getItems().isEmpty()) {
        %>
        <p class="empty-cart">Your cart is empty!</p>
        <a class="btn btn-add" href="resturant">Add More Items</a>
        <%
            } else {
        %>
        <div class="cart-container">
            <% for (CartItem item : cart.getItems().values()) { %>
            <div class="cart-item">
                <div class="cart-item-details">
                    <h3><%= item.getItemName() %></h3>
                    <p>Price: ₹<%= item.getPrice() %></p>
                    <p>Total: ₹<%= item.getPrice() * item.getQuantity() %></p>
                </div>
                <div class="quantity-controls">
                    <!-- Decrease Quantity -->
                    <form action="cartservlet" method="post">
                        <input type="hidden" name="resturantId" value="<%= item.getResturantId() %>">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                        <button class="btn btn-quantity" <%= item.getQuantity() == 1 ? "disabled" : "" %>>-</button>
                    </form>
                    <!-- Display Quantity -->
                    <p class="quantity"><%= item.getQuantity() %></p>
                    <!-- Increase Quantity -->
                    <form action="cartservlet" method="post">
                        <input type="hidden" name="resturantId" value="<%= item.getResturantId() %>">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                        <button class="btn btn-quantity">+</button>
                    </form>
                </div>
                <!-- Remove Item -->
                <form action="cartservlet" method="post">
                    <input type="hidden" name="resturantId" value="<%= item.getResturantId() %>">
                    <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                    <input type="hidden" name="action" value="remove">
                    <button class="btn btn-remove">Remove</button>
                </form>
            </div>
            <% } %>
        </div>
        <!-- Grand Total -->
        <div class="cart-summary">
            <p><strong>Grand Total: ₹<%= cart.getTotalprice() %></strong></p>
        </div>
        <!-- Proceed to Checkout -->
        <div class="actions">
            <a class="btn btn-add" href="menuservlet?resturantId=<%=restaurantId%>">Add More Items</a>
            <form action="checkout.jsp" method="get">
                <button class="btn btn-checkout">Proceed to Checkout</button>
            </form>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>



