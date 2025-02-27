<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.fooddelivery.model.resturant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Restaurants</title>
    <link rel="stylesheet" href="resturant.css">
</head>
<body>
    <div class="header">
        <h1>Available Restaurants</h1>
    </div>
    
    <!-- Fetch restaurants from request attribute -->
    <%
        List<resturant> resturants = (List<resturant>) request.getAttribute("resturants");
        if (resturants != null && !resturants.isEmpty()) {
    %>

    <div class="container">
        <!-- Loop through the restaurants and display them -->
        <%
            for (resturant r : resturants) {
        %>
            <div class="restaurant-card">
                <a href="menuservlet?resturantId=<%=r.getResturantid() %>">
                    <img src="<%= r.getImagepath() %>" alt="<%= r.getName() %>" width="150" height="150">
                    <div class="card-content">
                        <h3><%= r.getName() %></h3>
                        <p><strong>Rating:</strong> <%= r.getRating() %>/5</p>
                        <p><strong>Cuisine:</strong> <%= r.getCusineType() %></p>
                        <p><strong>ETA:</strong> <%= r.getEta() %></p>
                    </div>
                </a>
            </div>
        <%
            }
        %>
    </div>
    <%
        } else {
    %>
    <p>No restaurants available.</p>
    <%
        }
    %>

    <div class="footer">
        <p>&copy; 2025 Food Delivery Platform</p>
    </div>
</body>
</html>

