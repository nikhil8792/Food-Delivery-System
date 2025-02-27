<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.fooddelivery.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Menu Page</title>
  <link rel="stylesheet" href="menu.css">
</head>
<body>
  <header>
    <nav class="navbar">
      <div class="logo">My Shop</div>
      <ul class="menu">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="resturant.jsp">Restaurants</a></li>
        <li><a href="cart.jsp">Go to Cart</a></li>
      </ul>
    </nav>
  </header>
  <main>
    <section id="products">
      <h2>Menu</h2>
      <div class="product-grid">
        <!-- Loop through menu list -->
        <%
          List<Menu> menuList = (List<Menu>) request.getAttribute("menus");
          if (menuList != null && !menuList.isEmpty()) {
            for (Menu menu : menuList) {
        %>
        <div class="product">
          <img src="<%= menu.getImagePath() %>" alt="<%= menu.getItemName() %>">
          <h3><%= menu.getItemName() %></h3>
          <p>₹<%= menu.getPrice() %></p>
          <form action="cartservlet" method="POST" class="cart-form">
            <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
            <input type="hidden" class="resturant-id" name="resturantId" value="<%= menu.getResturantId() %>">
            <input type="hidden" name="itemName" value="<%= menu.getItemName() %>">
            <input type="hidden" name="price" value="<%= menu.getPrice() %>">
            <input type="hidden" name="action" value="add">
            <label for="quantity" class="quantity-label">Qty:</label>
            <input type="number" name="quantity" value="1" min="1" class="quantity-input">
            <button type="submit" class="add-to-cart">Add to Cart</button>
          </form>
        </div>
        <%
            }
          } else {
        %>
        <p>No menu items available for this restaurant.</p>
        <%
          }
        %>
      </div>
    </section>
  </main>
  <footer>
    <p>&copy; 2025 My Shop. All rights reserved.</p>
  </footer>
</body>
</html>



    