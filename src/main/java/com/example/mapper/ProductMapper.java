package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Product;

@Mapper
public interface ProductMapper {

	/** 全商品を取得する */
	List<Product> findAll();

	/** IDで商品を1件取得する */
	Product findById(int id);
}