package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

	@GetMapping("/product")
	public String showList() {
		// 商品一覧ページを表示する
		return "product/list";
	}

	@GetMapping("/product/{id}")
	public String showDetail(@PathVariable("id") int id) {
		// URL で指定された id を受け取る
		System.out.println("アクセスされたID：" + id);

		// 商品詳細ページを表示する
		return "product/detail";

	}
}
