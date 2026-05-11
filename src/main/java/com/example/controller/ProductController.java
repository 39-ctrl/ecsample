package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Product;
import com.example.mapper.ProductMapper;

@Controller
public class ProductController {

	private final ProductMapper productMapper;

	public ProductController(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@GetMapping("/product")
	public String showList(Model model) {//Controllerからviewを渡すためのモデル
		// 仮のデータをべた書き
		List<Product> products = productMapper.findAll();
		model.addAttribute("products", products);
		// 商品一覧ページを表示する
		return "product/list";
	}

	@GetMapping("/product/{id}")
	public String showDetail(@PathVariable("id") int id, Model model) {
		//	public String showDetail(@PathVariable("id") int id) {
		//		// URL で指定された id を受け取る
		//		System.out.println("アクセスされたID：" + id);

		Product product = productMapper.findById(id);
		model.addAttribute("product", product);
		// 商品詳細ページを表示する
		return "product/detail";

	}
}
