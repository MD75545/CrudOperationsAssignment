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

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/api/products") 
public class ProductController {

    @Autowired
    private ProductService proService;

  
    @GetMapping
    public List<Product> displayAllProducts(Product Product) {
        return proService.showAllProduct(Product); 
    }

 
    @GetMapping("/{pId}")
    public Product getProductById(@PathVariable int pId) {
        return proService.getProductById(pId).orElseThrow(() -> new RuntimeException("Product not found with ID: " + pId));
    }

  
    @DeleteMapping("/{pId}")
    public void deleteProductById(@PathVariable int pId) {
        proService.deleteProduct(pId);
    }

   
    @PutMapping("/{pId}")
    public Product updateProductById(@PathVariable int pId, @RequestBody Product updateProduct) {
        return proService.updateProduct(pId, updateProduct);
    }

   
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        proService.saveProducts(product);
    }
}
