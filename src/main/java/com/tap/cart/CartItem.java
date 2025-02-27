package com.tap.cart;

public class CartItem {
	private int menuId;
	private int resturantId;
	private String itemName;
	private double price;
	private int quantity;
	
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartItem(int menuId, int resturantId, String itemName, double price, int quantity) {
		super();
		this.menuId = menuId;
		this.resturantId = resturantId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getResturantId() {
		return resturantId;
	}


	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
