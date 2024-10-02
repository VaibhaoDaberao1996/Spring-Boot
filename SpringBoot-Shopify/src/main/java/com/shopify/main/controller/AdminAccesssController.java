package com.shopify.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.main.service.CategoryService;
import com.shopify.main.service.ProductService;
import com.shopify.main.service.UserService;

@RestController
@RequestMapping("/shopify/admin/apis")
public class AdminAccesssController {
	
	@Autowired
	private CategoryService category_service;
	
	@Autowired
	private ProductService product_service;
	
	@Autowired
	private UserService user_service;
	
	
}
