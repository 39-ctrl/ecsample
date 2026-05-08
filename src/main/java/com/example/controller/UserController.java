package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public String submitForm(
			@Validated @ModelAttribute("form") UserForm form,
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "user/register"; // エラー時はフォームに戻す
		}

		// まとめて受け取れているか確認
		System.out.println("name = " + form.getName());
		System.out.println("email = " + form.getEmail());
		System.out.println("password = " + form.getPassword());

		model.addAttribute("form", form);
		return "user/result";
	}
}