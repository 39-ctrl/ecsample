package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.UserForm;
import com.example.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

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

		userService.register(form);

		model.addAttribute("form", form);
		return "user/result";
	}
}