package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;



@RestController
@RequestMapping("/api/categories") 
public class CategoryController {

    @Autowired
    private CategoryService catService;

    
    @GetMapping
    public List<Category> displayCategories() {
        return catService.showAllCategory();
    }
   
    @GetMapping("/{cId}")
    public Category getCategoryById(@PathVariable int cId) {
        return catService.getCategoryById(cId).orElseThrow(() -> new RuntimeException("Category not found with ID: " + cId));
    }

    
    @DeleteMapping("/{cId}")
    public void deleteCategoryById(@PathVariable int cId) {
        catService.deleteCategorybyId(cId);
    }

    
    @PutMapping("/{cId}")
    public Category updateCategory(@PathVariable int cId, @RequestBody Category updateCategory) {
        return catService.updateCategory(cId, updateCategory);
    }
    
    @DeleteMapping
    public List<Category> deleteAllCategories() {
     return catService.deleteAllCategory();
    }

    
    @PostMapping
    public void addCategory(@RequestBody Category category) {
        catService.addCategory(category);
    }
}
