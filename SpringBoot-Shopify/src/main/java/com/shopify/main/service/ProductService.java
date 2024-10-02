package com.shopify.main.service;

import java.util.List;

import com.shopify.main.Dto.ProductDto;
import com.shopify.main.entities.Product;

public interface ProductService {

	 ProductDto createProduct(ProductDto product);
	
	 void  deleteProduct(long productId);
	
	 ProductDto updateProduct(long productId,ProductDto product);
	
	 ProductDto getSingleProduct(long productId);
	
	 List<ProductDto> getAllProduct();
}
