<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" href="checkout.css">
</head>
<body>
    <!-- Header Section -->
    <header class="header">
        <div class="container">
            <h1 class="logo">Your Store</h1>
        </div>
    </header>

    <!-- Main Checkout Section -->
    <main class="checkout-container">
        <div class="container">
            <h2 class="checkout-title">Checkout</h2>
            <form action="order" method="POST" class="checkout-form">
                <!-- Delivery Address Section -->
                <div class="form-group">
                    <label for="address">Delivery Address:</label>
                    <textarea 
                        id="address" 
                        name="address" 
                        rows="4" 
                        required 
                        placeholder="Enter your delivery address"></textarea>
                </div>

                <!-- Payment Method Section -->
                <div class="form-group">
                    <label>Payment Method:</label>
                    <div class="payment-options">
                        <div>
                            <input type="radio" id="upi" name="paymentMethod" value="UPI" required>
                            <label for="upi">UPI</label>
                        </div>
                        <div>
                            <input type="radio" id="netBanking" name="paymentMethod" value="Net Banking">
                            <label for="netBanking">Net Banking</label>
                        </div>
                        <div>
                            <input type="radio" id="creditCard" name="paymentMethod" value="Credit Card">
                            <label for="creditCard">Credit Card</label>
                        </div>
                        <div>
                            <input type="radio" id="debitCard" name="paymentMethod" value="Debit Card">
                            <label for="debitCard">Debit Card</label>
                        </div>
                        <div>
                            <input type="radio" id="cashOnDelivery" name="paymentMethod" value="Cash on Delivery">
                            <label for="cashOnDelivery">Cash on Delivery</label>
                        </div>
                    </div>
                </div>
                
                 <!-- Hidden Field for Restaurant ID -->
    <input type="hidden" name="resturantId" value="<%= request.getParameter("resturantId") %>">

                <!-- Submit Button -->
                <div class="form-group">
                    <button type="submit" class="btn-place-order">Place Order</button>
                </div>
            </form>
        </div>
    </main>

    <!-- Footer Section -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2025 Your Store. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>


