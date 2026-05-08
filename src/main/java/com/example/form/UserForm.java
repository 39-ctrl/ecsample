package com.example.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {
	@NotBlank(message = "名前は必須です")
	private String name;

	@NotBlank(message = "メールアドレスは必須です")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;

	@NotBlank(message = "メール確認用アドレスを入力してください")
	private String emailConfirm;

	@NotBlank(message = "パスワードは必須です")
	@Size(min = 6, message = "パスワードは6文字以上で入力してください")
	private String password;

	@AssertTrue(message = "メールアドレスが一致しません")
	public boolean isEmailConfirmed() {
		return email != null && email.equals(emailConfirm);
	}

	public String getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
