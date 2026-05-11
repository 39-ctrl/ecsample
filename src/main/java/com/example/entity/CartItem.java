package com.example.entity;

public class CartItem {
	private int productId;
	private String name;
	private int price;
	private int quantity;

	public CartItem(int productId, String name, int price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = 1;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void incrementQuantity() {
		this.quantity++;
	}

	public int getSubtotal() {
		return price * quantity;
	}
}