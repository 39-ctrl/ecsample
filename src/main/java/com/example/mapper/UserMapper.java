package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.entity.User;

@Mapper
public interface UserMapper {

	/** メールアドレスでユーザを検索する */
	@Select("SELECT * FROM users WHERE email = #{email}")
	User findByEmail(String email);

	/** ユーザを登録する */
	@Insert("INSERT INTO users (name, email, password) VALUES (#{name}, #{email}, #{password})")
	void insert(User user);
}