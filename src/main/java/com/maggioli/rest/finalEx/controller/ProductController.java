package com.maggioli.rest.finalEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maggioli.rest.finalEx.manager.CategoryManager;
import com.maggioli.rest.finalEx.manager.ProductManager;
import com.maggioli.rest.finalEx.model.Category;
import com.maggioli.rest.finalEx.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductManager pManager;

	@Autowired
	CategoryManager cManager;
	
	//TODO: Add CategoryManager
	
	@GetMapping(path = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProductsMethod(
			@RequestParam(name = "category_id", required = false) Integer categoryId) {
		return ResponseEntity.ok(pManager.getAllProducts(categoryId));
	}
	
	@GetMapping(path = "/getAllCategories")
	public ResponseEntity<List<Category>> getAllCategoriesMethod() {
		return ResponseEntity.ok(cManager.getAllCategories()); 
	}
}

