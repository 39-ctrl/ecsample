package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Product;

@Controller
public class ProductController {

	@GetMapping("/product")
	public String showList(Model model) {
		// 仮のデータをべた書き
		List<Product> product = Arrays.asList(
				new Product(1, "コーヒーカップ", 1200),
				new Product(2, "ティーポット", 2400),
				new Product(3, "マグカップ", 1500));
		model.addAttribute("product", product);
		// 商品一覧ページを表示する
		return "product/list";
	}

	@GetMapping("/product/{id}")
	public String showDetail(@PathVariable("id") int id, Model model) {
		//	public String showDetail(@PathVariable("id") int id) {
		//		// URL で指定された id を受け取る
		//		System.out.println("アクセスされたID：" + id);

		Product product;
		if (id == 1) {
			product = new Product(1, "コーヒーカップ", 1200);
		} else if (id == 2) {
			product = new Product(2, "ティーポット", 2400);
		} else {
			product = new Product(0, "未登録の商品", 0);
		}
		model.addAttribute("product", product);
		// 商品詳細ページを表示する
		return "product/detail";

	}
}
