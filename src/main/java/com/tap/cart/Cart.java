package com.tap.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> cart; // Map to store cart items

    // Constructor
    public Cart() {
        cart = new HashMap<>();
    }

    // Add an item to the cart
    public void addCartItem(CartItem cartItem) {
        if (cart.containsKey(cartItem.getMenuId())) {
            System.out.println("Item already exists in the cart. Updating the quantity.");
            CartItem existingItem = cart.get(cartItem.getMenuId());
            existingItem.setQuantity(existingItem.getQuantity() + cartItem.getQuantity());
        } else {
            cart.put(cartItem.getMenuId(), cartItem);
        }
    }

    // Update the quantity of a cart item
    public void updateCartItem(int menuId, int quantity) {
        if (cart.containsKey(menuId)) {
            if (quantity <= 0) {
                cart.remove(menuId); // Remove item if quantity is 0 or less
            } else {
                cart.get(menuId).setQuantity(quantity);
            }
        }
    }

    // Remove an item from the cart
    public void removeCartItem(int menuId) {
        cart.remove(menuId);
    }
    
    
    

    // Display all items in the cart
    public Map<Integer,CartItem>getItems()
    {
    	return cart;
    }
    
    public double getTotalprice()
    {
    	return cart.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
    public void clear()
    {
    	cart.clear();
    }
}



