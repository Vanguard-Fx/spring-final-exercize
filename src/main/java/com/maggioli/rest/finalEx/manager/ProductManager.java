package com.maggioli.rest.finalEx.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggioli.rest.finalEx.model.Product;
import com.maggioli.rest.finalEx.repository.ProductRepository;

@Service
public class ProductManager {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
