package com.BlackFlag.Inventory.services;

import com.BlackFlag.Inventory.models.Product;
import com.BlackFlag.Inventory.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product productDetails) {
		return productRepository.findById(id).map(product -> {
			product.setName(productDetails.getName());
			product.setPrice(productDetails.getPrice());
			return productRepository.save(product);
		}).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
