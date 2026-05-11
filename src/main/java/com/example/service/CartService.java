package com.example.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.entity.CartItem;
import com.example.entity.Product;

@Service
public class CartService {

	private static final String CART_KEY = "cart";

	/** セッションからカートを取得する（存在しなければ空のリストを返す） */
	@SuppressWarnings("unchecked")
	public List<CartItem> getCart(HttpSession session) {
		List<CartItem> cart = (List<CartItem>) session.getAttribute(CART_KEY);
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute(CART_KEY, cart);
		}
		return cart;
	}

	/** カートに商品を追加する（同じ商品が既にあれば数量を増やす） */
	public void addItem(HttpSession session, Product product) {
		List<CartItem> cart = getCart(session);
		for (CartItem item : cart) {
			if (item.getProductId() == product.getId()) {
				item.incrementQuantity();
				return;
			}
		}
		cart.add(new CartItem(product.getId(), product.getName(), product.getPrice()));
	}

	/** カートから商品を削除する */
	public void removeItem(HttpSession session, int productId) {
		List<CartItem> cart = getCart(session);
		cart.removeIf(item -> item.getProductId() == productId);
	}

	/** カートを空にする */
	public void clearCart(HttpSession session) {
		session.removeAttribute(CART_KEY);
	}
}