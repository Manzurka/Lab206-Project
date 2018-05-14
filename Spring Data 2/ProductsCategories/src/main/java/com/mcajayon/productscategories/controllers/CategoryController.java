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
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category c) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Category c, BindingResult result) {
		if (result.hasErrors()) {
			return "newcategory.jsp";
		}
		categoryService.createCategory(c);
		return "displaycategory.jsp";
	}
	
	@RequestMapping("/category/display/{id}")
	public String displayCategory(@PathVariable("id") Long id, Model model) {
		Category c = categoryService.findById(id);
		if (c != null) {
			model.addAttribute("category", c);
			model.addAttribute("products", productService.allProducts());
			return "displaycategory.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/category/{id}/addProduct")
	public String updateProducts(@PathVariable("id") Long id, @RequestParam("products") Long p_id) {
		Product p = productService.findById(p_id);
		Category c = categoryService.findById(id);
		categoryService.updateProducts(c, p);
		return "redirect:/";
	}
}