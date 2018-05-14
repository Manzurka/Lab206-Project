package com.mcajayon.productscategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcajayon.productscategories.models.Category;
import com.mcajayon.productscategories.models.Product;
import com.mcajayon.productscategories.services.CategoryService;
import com.mcajayon.productscategories.services.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
	model.addAttribute("products", productService.allProducts());
	model.addAttribute("categories", categoryService.allCategories());
	System.out.println("hello");
	return "index.jsp";
	}
	
	@RequestMapping("/product/new")
	public String newProduct(@ModelAttribute("product") Product p) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		if (result.hasErrors()) {
			return "newproduct.jsp";
		}
		productService.createProduct(p);
		return "displayproduct.jsp";
	}
	
	@RequestMapping("/product/display/{id}")
	public String displayProduct(@PathVariable("id") Long id, Model model) {
		Product p = productService.findById(id);
		model.addAttribute("product", p);
		model.addAttribute("categories", categoryService.allCategories());
		return "displayproduct.jsp";
	}
	
	@PostMapping("/product/{id}/addCategory")
	public String updateCategory(@PathVariable("id") Long id, @RequestParam("categories") Long c_id) {
		Category c = categoryService.findById(c_id);
		Product p = productService.findById(id);
		productService.updateCategories(p, c);
		return "redirect:/";
	}
}