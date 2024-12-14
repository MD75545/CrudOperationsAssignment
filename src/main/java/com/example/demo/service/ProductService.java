package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void saveProducts(Product product) {
		productRepository.save(product);

	}
	public List<Product> showAllProduct(Product product) {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(int pId) {
		return productRepository.findById(pId);
	}

	public Product updateProduct(int pId, Product productUpdate) {
		Product product = getProductById(pId)
				.orElseThrow(() -> new RuntimeException("Category not found with ID: " + pId));
		product.setpName(productUpdate.getpName());
		product.setDescription(productUpdate.getDescription());
		return productRepository.save(product);
	}

	public void deleteProduct(int pId) {
		productRepository.deleteById(pId);
	}
}
