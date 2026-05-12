package com.example.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.form.UserForm;
import com.example.mapper.UserMapper;

@Service
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void register(UserForm form) {
		System.out.println("ユーザ登録：" + form.getName() + " <" + form.getEmail() + ">");
		User user = new User();
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		userMapper.insert(user);
	}
}