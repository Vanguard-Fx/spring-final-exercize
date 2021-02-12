package com.maggioli.rest.finalEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maggioli.rest.finalEx.manager.ProductManager;
import com.maggioli.rest.finalEx.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductManager pManager;
	
	//TODO: Add CategoryManager
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Product>> getAllMethod() {
		return ResponseEntity.ok(pManager.getAll());
	}
}

