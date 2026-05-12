package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginForm {

	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;

	@NotBlank(message = "パスワードを入力してください")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}