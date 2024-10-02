package com.shopify.main.service.implService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.main.Dto.ProductDto;
import com.shopify.main.Exception.ResourceNotFoundException;
import com.shopify.main.entities.Product;
import com.shopify.main.repository.ProductRepository;
import com.shopify.main.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository product_repository;
	
	@Autowired
	private ModelMapper model_conversion;
	
	//Create Product
	@Override
	public ProductDto createProduct(ProductDto product) {
		Product createproduct = this.model_conversion.map(product, Product.class);
		
		Product saveproduct = this.product_repository.save(createproduct);
		return model_conversion.map(saveproduct, ProductDto.class);
	}

	//Delete Product
	@Override
	public void deleteProduct(long productId) {
		Product product = this.product_repository.findById(productId).orElseThrow(
				()->new ResourceNotFoundException("Product", "product id", productId));
		
		this.product_repository.delete(product);
	}
	
	//Update Product
	@Override
	public ProductDto updateProduct(long productId, ProductDto product) {
		Product findProduct = this.product_repository.findById(productId).orElseThrow(
				()->new ResourceNotFoundException("Product", "product id", productId));
		
		findProduct.setName(product.getName());
		findProduct.setPrice(product.getPrice());
		findProduct.setDescription(product.getDescription());
		
		Product updateProduct = this.product_repository.save(findProduct);
		return model_conversion.map(updateProduct, ProductDto.class);
	}

	//Get a Product
	@Override
	public ProductDto getSingleProduct(long productId) {
		Product product = this.product_repository.findById(productId).orElseThrow(
				()->new ResourceNotFoundException("Product", "prodduct id", productId));
		
		return model_conversion.map(product, ProductDto.class);
	}

	//Get all product
	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products = this.product_repository.findAll();
		
		List<ProductDto> dtoProducts = products
												.stream()
												.map(product->this.model_conversion.map(product, ProductDto.class))
												.toList();
		
		return dtoProducts;
	}
	
	
}
