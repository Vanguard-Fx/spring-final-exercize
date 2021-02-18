package com.maggioli.rest.finalEx.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggioli.rest.finalEx.model.Category;
import com.maggioli.rest.finalEx.repository.CategoryRepository;

@Service
public class CategoryManager {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
}
