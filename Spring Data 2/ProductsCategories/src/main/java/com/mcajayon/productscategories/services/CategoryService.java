package com.mcajayon.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcajayon.productscategories.models.Category;
import com.mcajayon.productscategories.models.Product;
import com.mcajayon.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRep;
	public CategoryService(CategoryRepository categoryRep) {
		this.categoryRep = categoryRep;
	}
	
	public List<Category> allCategories() {
		return categoryRep.findAll();
	}
	
	public Category createCategory(Category c) {
		return categoryRep.save(c);
	}
	
	public Category findById(Long id) {
		Optional<Category> c = categoryRep.findById(id);
		if (c != null) {
			return c.get();
		}
		return null;
	}
	
	public void updateProducts(Category c, Product p) {
		c.updateProducts(p);
		categoryRep.save(c);
	}
}