package com.mcajayon.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcajayon.productscategories.models.Category;
import com.mcajayon.productscategories.models.Product;
import com.mcajayon.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRep;
	public ProductService(ProductRepository productRep) {
		this.productRep = productRep;
	}

	public List<Product> allProducts() {
		return productRep.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRep.save(p);
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRep.findById(id);
		if (product != null) {
			return product.get();
		}
		return null;
	}
	
	public void updateCategories(Product p, Category c) {
		p.updateCategories(c);
		productRep.save(p);
	}
}