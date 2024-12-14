package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;    

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> showAllCategory() {
	    return categoryRepository.findAll();
	}

	public Optional<Category> getCategoryById(Integer cId) {
		return categoryRepository.findById(cId);
	}

	public Category updateCategory(Integer id, Category updatedCategory) {
		Category category = getCategoryById(id)
				.orElseThrow(() -> new RuntimeException("Category not found with ID: " + id)); 
		category.setcName(updatedCategory.getcName());
		return categoryRepository.save(category);
	}

	@Transactional
	public void deleteCategorybyId(int categoryId) {
	    productRepository.deleteById(categoryId);
	    categoryRepository.deleteById(categoryId);
	}
	
	public List<Category> deleteAllCategory() {
			List<Category> allcategories=categoryRepository.findAll();
			categoryRepository.deleteAll();
			return allcategories;
	}

}
