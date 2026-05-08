package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.UserForm;

@Controller
public class UserController {

	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("form", new UserForm());
		return "user/register";
	}

	@PostMapping("/register")
	public String submitForm(@ModelAttribute UserForm form, Model model) {
		// まとめて受け取れているか確認
		System.out.println("name = " + form.getName());
		System.out.println("email = " + form.getEmail());
		System.out.println("password = " + form.getPassword());

		model.addAttribute("form", form);
		return "user/result";
	}
}