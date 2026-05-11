package com.example.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private final CartService cartService;
	private final ProductMapper productMapper;

	public CartController(CartService cartService, ProductMapper productMapper) {
		this.cartService = cartService;
		this.productMapper = productMapper;
	}

	/** カート一覧を表示する */
	@GetMapping
	public String showCart(HttpSession session, Model model) {
		List<CartItem> cart = cartService.getCart(session);
		int total = cart.stream().mapToInt(CartItem::getSubtotal).sum();
		model.addAttribute("cart", cart);
		model.addAttribute("total", total);
		return "cart/index";
	}

	/** カートに商品を追加する */
	@PostMapping("/add")
	public String addToCart(@RequestParam("productId") int productId,
			HttpSession session) {
		Product product = productMapper.findById(productId);
		if (product != null) {
			cartService.addItem(session, product);
		}
		return "redirect:/cart";
	}

	/** カートから商品を削除する */
	@PostMapping("/remove")
	public String removeFromCart(@RequestParam("productId") int productId,
			HttpSession session) {
		cartService.removeItem(session, productId);
		return "redirect:/cart";
	}
}